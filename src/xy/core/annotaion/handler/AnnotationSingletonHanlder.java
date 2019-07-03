package xy.core.annotaion.handler;

import java.util.Map.Entry;

import xy.core.annotaion.Configuration;
import xy.core.annotaion.processor.BeanProcessor;
import xy.core.annotaion.processor.ConfigurationProcessor;
import xy.core.annotaion.processor.ModuleProcessor;
import xy.core.annotaion.processor.ModuleScanProcessor;
import xy.core.bean.BeanDefinition;
import xy.core.bean.BeanDefintionRegistry;
import xy.core.bean.BeanSingletonRegistry;
import xy.core.constant.BeanDefinitionStatus;
import xy.core.util.xy;

public class AnnotationSingletonHanlder {

	private BeanProcessor bp;
	private ConfigurationProcessor cp;
	private ModuleProcessor mp;
	private ModuleScanProcessor msp;

	public AnnotationSingletonHanlder() {
		this.bp = new BeanProcessor();
		this.cp = new ConfigurationProcessor();
		this.mp = new ModuleProcessor();
		this.msp = new ModuleScanProcessor();
	}

	private void checkConfig(Class<?>... configClasses) {
		for (Class<?> cls : configClasses) {
			if (xy.isNull(cls.getAnnotation(Configuration.class))) {
				throw new RuntimeException(cls + " is not configuration class!");
			}
		}
	}

	public BeanDefintionRegistry preHandle(Class<?>... configClasses) {
		this.checkConfig(configClasses);

		BeanDefintionRegistry registry = new BeanDefintionRegistry();

		for (Class<?> clazz : configClasses) {
			this.cp.obtainBeanDefinitionProxy(clazz, null, registry);
			this.msp.obtainBeanDefinitionProxy(clazz, null, registry);
		}

		return registry;

	}

	public void handle(BeanDefintionRegistry registry, BeanSingletonRegistry beans) {
		for(Entry<String, BeanDefinition> en : registry ) {
			String k = en.getKey();
			BeanDefinition bi = en.getValue();
			
			if(bi.getStatus() == BeanDefinitionStatus.INST) {
				
			}
			
			Object o = beans.get(k);
			if(xy.isNull(o)) {
				this.cp.processProxy(bi, registry, null);
				
//				beans.registerBeanDefinition(k,);
			}
			
		}
		
	}

}
