package xy.core.factory.impl;

import java.util.List;

import xy.core.bean.BeanDefinition;
import xy.core.factory.AnnotationBeanFactory;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;

public class AnnotationBeanFactoryImpl implements AnnotationBeanFactory {

	@Override
	public <T> T getBean(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(String name, Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(Class<T> clazz, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(String name, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getBean(String name, Class<T> clazz, Object... params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getNewBean(Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getNewBean(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T getNewBean(String name, Class<T> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Class<?>> getConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDefinition getBeanDefinition(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDefinition getBeanDefinition(Class<?> clazz) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BeanDefintionRegistry getDefRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefRegistry(BeanDefintionRegistry registry) {
		// TODO Auto-generated method stub

	}

	@Override
	public BeanSingletonRegistry getInstRegistry() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setInstRegistry(BeanSingletonRegistry registry) {
		// TODO Auto-generated method stub

	}

}
