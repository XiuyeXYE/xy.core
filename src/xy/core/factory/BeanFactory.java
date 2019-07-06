package xy.core.factory;

import java.util.List;

import xy.core.bean.BeanDefinition;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;

public interface BeanFactory {

	BeanDefinition getBeanDefinition(String name);

	BeanDefinition getBeanDefinition(Class<?> clazz);
	
	BeanDefinition getBeanDefinition(Class<?> clazz,String name);

	BeanDefintionRegistry getDefRegistry();

	void setDefRegistry(BeanDefintionRegistry registry);

	BeanSingletonRegistry getInstRegistry();

	void setInstRegistry(BeanSingletonRegistry registry);
	
	List<String> getAliases(String name);

	
	
	<T> T getBean(Class<T> clazz);

	<T> T getBean(String name);

	<T> T getBean(String name, Class<T> clazz);

	<T> T getBean(Class<T> clazz, Object... params);

	<T> T getBean(String name, Object... params);

	<T> T getBean(String name, Class<T> clazz, Object... params);

	// force new bean
	<T> T getNewBean(Class<T> clazz);

	<T> T getNewBean(String name);

	<T> T getNewBean(String name, Class<T> clazz);

	default <T> T getNewBean(Class<T> clazz, Object... params) {
		return this.getBean(clazz, params);
	}

	default <T> T getNewBean(String name, Object... params) {
		return this.getBean(name, params);
	}

	default <T> T getNewBean(String name, Class<T> clazz, Object... params) {
		return this.getBean(name, clazz, params);
	}

}
