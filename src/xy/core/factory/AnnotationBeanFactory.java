package xy.core.factory;

import java.util.List;

public interface AnnotationBeanFactory extends BeanFactory{

	List<Class<?>> getConfigClasses();
	
}
