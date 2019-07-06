package xy.core.context;

import java.util.Arrays;
import java.util.List;

import xy.core.annotaion.processor.DefinitionProcessor;
import xy.core.annotaion.processor.impl.ConfigurationDefProcessor;
import xy.core.bean.BeanDefinition;
import xy.core.factory.AnnotationBeanFactory;
import xy.core.global.Global;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;

public class AnnotationApplicationContext implements AnnotationBeanFactory, ApplicationContext {

	private DefinitionProcessor processor = new ConfigurationDefProcessor();

	private List<Class<?>> classes;

	private BeanDefintionRegistry defReistry;

	public AnnotationApplicationContext(Class<?>... classes) {

		this(Arrays.asList(classes));

	}

	public AnnotationApplicationContext(List<Class<?>> classes) {

		this.classes = classes;

		this.checkConfigurationClass(classes);
		this.defReistry = Global.beansDefRegistry;
		classes.forEach(cls -> {
			this.processor.process(cls, this.defReistry);
		});
	}

	@Override
	public BeanDefinition getBeanDefinition(String name) {
		return this.defReistry.getDefinition(name);
	}

	@Override
	public BeanDefinition getBeanDefinition(Class<?> clazz) {
		return this.defReistry.getDefinition(clazz);
	}

	@Override
	public BeanDefintionRegistry getDefRegistry() {
		return this.defReistry;
	}

	@Override
	public void setDefRegistry(BeanDefintionRegistry registry) {
		this.defReistry = registry;
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
		return this.classes;
	}

	@Override
	public List<String> getAliases(String name) {
		return this.defReistry.getAlias(name);
	}

	@Override
	public BeanDefinition getBeanDefinition(Class<?> clazz, String name) {
		return this.defReistry.getDefinition(clazz, name);
	}

}
