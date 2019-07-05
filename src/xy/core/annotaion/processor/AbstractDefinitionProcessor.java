package xy.core.annotaion.processor;

import xy.core.annotaion.Scope;
import xy.core.bean.BeanDefinition;
import xy.core.util.xy;

public abstract class AbstractDefinitionProcessor implements DefinitionProcessor{

	protected void processScope(Class<?> clazz, BeanDefinition bd) {
		Scope scope = clazz.getAnnotation(Scope.class);
		xy.ifAnnotationNonNull(scope, s->{
			bd.setScope(s.value());
		});		
	}
	
}
