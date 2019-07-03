package xy.core.annotaion;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import xy.core.constant.BeanDefinitionScope;

@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface Scope {
	BeanDefinitionScope value() default BeanDefinitionScope.SINGLETON;
}
