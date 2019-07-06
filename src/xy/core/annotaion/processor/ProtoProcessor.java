package xy.core.annotaion.processor;

import xy.core.bean.BeanDefinition;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;

public interface ProtoProcessor {

	/**
	 * prototype
	 * 
	 * @param name
	 * @param registry
	 */
	Object process(String name, BeanDefinition bi, BeanDefintionRegistry defRegistry, BeanSingletonRegistry instRegistry);
	
}
