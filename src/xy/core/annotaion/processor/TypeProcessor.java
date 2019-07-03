package xy.core.annotaion.processor;

import java.util.Objects;

import xy.core.bean.BeanDefinition;
import xy.core.bean.BeanDefintionRegistry;
import xy.core.util.xy;

public interface TypeProcessor extends Processor {

	default BeanDefinition obtainBeanDefinitionProxy(Class<?> clazz, BeanDefinition bi,
			BeanDefintionRegistry registry) {
		if (Objects.isNull(bi)) {
			bi = xy.createBeanDefinition();
		}
		this.obtainBeanDefinition(clazz, bi, registry);
		return bi;
	}

	void obtainBeanDefinition(Class<?> clazz, BeanDefinition bi, BeanDefintionRegistry registry);

	

}
