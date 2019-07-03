package xy.core.annotaion.processor;

import java.lang.reflect.Method;
import java.util.Objects;

import xy.core.bean.BeanDefinition;
import xy.core.bean.BeanDefintionRegistry;
import xy.core.util.xy;

public interface MethodProcessor extends Processor{

	
	default BeanDefinition obtainBeanDefinitionProxy(Class<?> clazz, Method method, BeanDefinition bi,
			BeanDefintionRegistry registry) {
		if (Objects.isNull(bi)) {
			bi = xy.createBeanDefinition();
		}
		this.obtainBeanDefinition(clazz, method, bi, registry);
		return bi;
	}

	void obtainBeanDefinition(Class<?> clazz, Method method, BeanDefinition bi, BeanDefintionRegistry registry);

//	/**
//	 * return bean instance
//	 * 
//	 * @param receiver
//	 * @param method
//	 * @param params
//	 * @return
//	 */
//	Object process(Object receiver, Method method, Object... params);

}
