package xy.core.bean;

import java.util.Iterator;
import java.util.Map.Entry;

import xy.core.map.BeanDefinitionMap;

public class BeanDefintionRegistry implements Iterable<Entry<String, BeanDefinition>>{

	private BeanDefinitionMap biMap = new BeanDefinitionMap();
	
	public void registerBeanDefinition(String name,BeanDefinition bi) {
		this.biMap.put(name, bi);
	}
	
	public BeanDefinition get(String name) {
		return this.biMap.get(name);
	}

	@Override
	public Iterator<Entry<String, BeanDefinition>> iterator() {
		return this.biMap.entrySet().iterator();
	}

	
}
