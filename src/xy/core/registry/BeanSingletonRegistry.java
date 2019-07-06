package xy.core.registry;

import xy.core.map.BeanSingletonMap;

public class BeanSingletonRegistry {

	private BeanSingletonMap bsMap = new BeanSingletonMap();

	public void registerBeanDefinition(String name, Object obj) {
		this.bsMap.put(name, obj);
	}

	public Object get(String name) {
		return this.bsMap.get(name);
	}

}
