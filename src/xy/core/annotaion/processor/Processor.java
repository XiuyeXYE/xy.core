package xy.core.annotaion.processor;

import xy.core.bean.BeanDefinition;
import xy.core.bean.BeanDefintionRegistry;
import xy.core.constant.BeanDefinitionScope;
import xy.core.util.xy;

public interface Processor {

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

	default Object processProxy(BeanDefinition bi, BeanDefintionRegistry registry, Object... params) {

		if (bi.getScope() == BeanDefinitionScope.SINGLETON) {
			return this.process(bi, registry, params);
		}

		return null;

	}

	/**
	 * return bean instance
	 * 
	 * @param receiver
	 * @param method
	 * @param params
	 * @return
	 */
	Object process(BeanDefinition bi, BeanDefintionRegistry registry, Object... params);

}
