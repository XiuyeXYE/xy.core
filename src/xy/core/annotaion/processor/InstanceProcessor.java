package xy.core.annotaion.processor;

import xy.core.bean.BeanDefinition;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;

public interface InstanceProcessor {

	/**
	 * singleton
	 * 
	 * @param name
	 * @param registry
	 */
	void process(BeanDefinition bi, BeanDefintionRegistry defRegistry, BeanSingletonRegistry instRegistry);

}
