package xy.core.registry;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import xy.core.bean.BeanDefinition;
import xy.core.map.AliasMap;
import xy.core.map.BeanDefinitionMap;
import xy.core.map.ClassMap;
import xy.core.util.xy;

public class BeanDefintionRegistry implements Iterable<Entry<String, BeanDefinition>> {

	// name => definition
	private BeanDefinitionMap biMap = new BeanDefinitionMap();

	// name => aliases
	// alias => name
	private AliasMap aMap = new AliasMap();

	// class => name
	private ClassMap cMap = new ClassMap();

	public void registerBeanDefinition(String name, BeanDefinition bi) {
		if (this.biMap.containsKey(name)) {
			xy.throwRuntimeException("name => definition: " + name + " already exists!");
		}
		this.biMap.put(name, bi);

		List<String> names = this.cMap.get(bi.getClass());
		if (xy.isNull(names)) {
			names = xy.list();
			this.cMap.put(bi.getClazz(), names);
		}
		if (names.contains(name)) {
			xy.throwRuntimeException("class => name: " + name + " already exists!");
		}
		names.add(name);
	}

	public BeanDefinition getDefinition(String name) {
		return this.biMap.get(name);
	}

	public BeanDefinition getDefinition(Class<?> clazz) {
		List<String> names = this.cMap.get(clazz);
		if (xy.isNull(names)) {
			xy.throwRuntimeException(clazz + " is not managed!");
		}
		if (names.isEmpty()) {
			xy.throwRuntimeException(clazz + " has no names!");
		}
		if (names.size() > 1) {
			xy.throwRuntimeException(clazz + "'s names are more than one!");
		}
		return this.biMap.get(names.get(0));
	}

	@Override
	public Iterator<Entry<String, BeanDefinition>> iterator() {
		return this.biMap.entrySet().iterator();
	}

	public void registerAlias(String name, String alias) {
		this.aMap.put(name, alias);
	}

	public List<String> getAlias(String name) {
		return this.aMap.getAliases(name);
	}

	public String getName(String alias) {
		return this.aMap.getName(alias);
	}

	@Override
	public String toString() {
		return "BeanDefintionRegistry [biMap=" + biMap + ", aMap=" + aMap + ", cMap=" + cMap + "]";
	}

}
