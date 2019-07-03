package xy.core.bean;

import java.lang.reflect.Method;

//
public class BeanBeanDefinition extends BeanDefinition{

	private BeanDefinition parentDefinition;
	//no parameter
	private Method parentMethod;
	
	
	@Override
	public String toString() {
		return "BeanBeanDefinition [parentDefinition=" + parentDefinition + ", parentMethod=" + parentMethod
				+ ", clazz=" + clazz + ", beanId=" + beanId + ", type=" + type + ", status=" + status + ", scope="
				+ scope + ", instType=" + instType + ", paramTypes=" + paramTypes + ", paramValues=" + paramValues
				+ "]";
	}
	
	
	
	
}
