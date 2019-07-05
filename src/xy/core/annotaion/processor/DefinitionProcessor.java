package xy.core.annotaion.processor;

import xy.core.bean.BeanDefinition;
import xy.core.constant.BeanDefinitionScope;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;
import xy.core.util.xy;

public interface DefinitionProcessor {

	/**
	 * handle bean definition and registor
	 * 		@param clazz
	 * 		@param registry
	 */
	void process(Class<?> clazz,BeanDefintionRegistry registry);
	
	
	
	default void checkExist(String name, BeanDefintionRegistry registry) {
		if (xy.nonNull(registry.get(name))) {
			throw new RuntimeException(name + " already exist!");
		}
	}

	default Class<?>[] pTypes(Object... params) {
		Class<?>[] pType = new Class<?>[params.length];

		for (int i = 0; i < params.length; i++) {
			pType[i] = params[i].getClass();
		}
		return pType;
	}

	

}
