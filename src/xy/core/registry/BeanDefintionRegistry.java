package xy.core.registry;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import xy.core.bean.BeanDefinition;
import xy.core.map.AliasesMap;
import xy.core.map.BeanDefinitionMap;
import xy.core.util.xy;

public class BeanDefintionRegistry implements Iterable<Entry<String, BeanDefinition>>{

	private BeanDefinitionMap biMap = new BeanDefinitionMap();
	
	private AliasesMap aMap = new AliasesMap();
	
	public void registerBeanDefinition(String name,BeanDefinition bi) {
		if(this.biMap.containsKey(name)){
			xy.throwRuntimeException(name +" already exists!");
		}
		this.biMap.put(name, bi);
	}
	
	public BeanDefinition get(String name) {
		return this.biMap.get(name);
	}

	@Override
	public Iterator<Entry<String, BeanDefinition>> iterator() {
		return this.biMap.entrySet().iterator();
	}

	public void registerAlias(String name,String alias) {
		this.aMap.put(name, alias);
	}
	
	public List<String> getAlias(String name) {
		return this.aMap.getAliases(name);
	}
	
	public String getName(String alias) {
		return this.aMap.getName(alias);
	}
	
}
