package xy.core.factory;

import java.util.List;

import xy.core.annotaion.Configuration;
import xy.core.util.xy;

public interface AnnotationBeanFactory extends BeanFactory {

	List<Class<?>> getConfigClasses();

	default void checkConfigurationClass(List<Class<?>> classes) {
		classes.forEach(cls -> {
			if (!cls.isAnnotationPresent(Configuration.class)) {
				xy.throwRuntimeException(cls + " is not configuration class!");
			}
		});
	}

}
