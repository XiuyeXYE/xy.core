package xy.core.context;

import java.util.Arrays;
import java.util.List;

import com.xiuye.util.cls.TypeUtil;

import xy.core.annotaion.processor.DefinitionProcessor;
import xy.core.annotaion.processor.InstanceProcessor;
import xy.core.annotaion.processor.impl.BeanInstProcessor;
import xy.core.annotaion.processor.impl.ConfigurationDefProcessor;
import xy.core.bean.BeanDefinition;
import xy.core.factory.AnnotationBeanFactory;
import xy.core.global.Global;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;
import xy.core.util.xy;

public class AnnotationApplicationContext implements AnnotationBeanFactory, ApplicationContext {

	private DefinitionProcessor defProcessor = new ConfigurationDefProcessor();

	private InstanceProcessor instProcessor = new BeanInstProcessor();

	private List<Class<?>> classes;

	private BeanDefintionRegistry defRegistry;

	private BeanSingletonRegistry instRegistry;

	public AnnotationApplicationContext(Class<?>... classes) {

		this(Arrays.asList(classes));

	}

	public AnnotationApplicationContext(List<Class<?>> classes) {

		this.classes = classes;

		this.checkConfigurationClass(classes);
		this.defRegistry = Global.beansDefRegistry;
		this.instRegistry = Global.beansInstRegistry;
		classes.forEach(cls -> {
			this.defProcessor.process(cls, this.defRegistry);
		});
		this.defRegistry.forEach(en -> {
			String name = en.getKey();
			BeanDefinition bi = en.getValue();
			this.instProcessor.process(name, bi, this.defRegistry, this.instRegistry);
		});
	}

	@Override
	public BeanDefinition getBeanDefinition(String name) {
		return this.defRegistry.getDefinition(name);
	}

	@Override
	public BeanDefinition getBeanDefinition(Class<?> clazz) {
		return this.defRegistry.getDefinition(clazz);
	}

	@Override
	public BeanDefintionRegistry getDefRegistry() {
		return this.defRegistry;
	}

	@Override
	public void setDefRegistry(BeanDefintionRegistry registry) {
		this.defRegistry = registry;
	}

	@Override
	public BeanSingletonRegistry getInstRegistry() {
		return this.instRegistry;
	}

	@Override
	public void setInstRegistry(BeanSingletonRegistry registry) {
		this.instRegistry = registry;
	}

	@Override
	public <T> T getBean(Class<T> clazz) {
		List<String> ns = this.defRegistry.getNames(clazz);
		T obj = xy.ifNonNull(ns, names -> {
			if (names.isEmpty())
				return null;
			else if (names.size() == 1)
				return TypeUtil.dynamic_cast(this.instRegistry.get(names.get(0)));
			else
				return xy.throwRuntimeException(
						clazz + " cannot find instance because of multiple instance of this class!");
		});
//		obj = xy.ifNull(obj, () -> {
//			BeanDefinition bd = this.defRegistry.getDefinition(clazz);
//			
//		});
		return obj;
	}

	@Override
	public <T> T getBean(String name) {
		return TypeUtil.dynamic_cast(this.instRegistry.get(name));
	}

	@Override
	public <T> T getBean(String name, Class<T> clazz) {
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
		return this.defRegistry.getAlias(name);
	}

	@Override
	public BeanDefinition getBeanDefinition(Class<?> clazz, String name) {
		return this.defRegistry.getDefinition(clazz, name);
	}

}
