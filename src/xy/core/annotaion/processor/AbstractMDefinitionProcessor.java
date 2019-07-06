package xy.core.annotaion.processor;

import xy.core.annotaion.processor.impl.BeanDefProcessor;
import xy.core.registry.BeanDefintionRegistry;

public abstract class AbstractMDefinitionProcessor extends AbstractDefinitionProcessor {

	private DefinitionProcessor beanAnProcessor = new BeanDefProcessor();

	protected void processBean(Class<?> clazz, BeanDefintionRegistry registry) {
		this.beanAnProcessor.process(clazz, registry);
	}

}
