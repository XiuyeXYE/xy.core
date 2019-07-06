package xy.core.annotaion.processor.impl;

import java.util.List;

import xy.core.annotaion.processor.InstanceProcessor;
import xy.core.bean.BeanDefinition;
import xy.core.constant.BeanDefinitionScope;
import xy.core.constant.BeanDefinitionStatus;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;
import xy.core.util.xy;

public class BeanInstProcessor implements InstanceProcessor {

	@Override
	public void process(BeanDefinition bi, BeanDefintionRegistry defRegistry, BeanSingletonRegistry instRegistry) {

		if (bi.getStatus() == BeanDefinitionStatus.INST) {
			return;
		}

		List<String> dependsBeanNames = bi.getDependsOn();
		for (String beanName : dependsBeanNames) {
			this.process(defRegistry.getDefinition(beanName), defRegistry, instRegistry);
		}

		String parent = bi.getParentName();

		if (xy.nonNull(parent)) {
			this.process(defRegistry.getDefinition(parent), defRegistry, instRegistry);
		}

		BeanDefinitionScope scope = bi.getScope();
		switch(scope) {
		case SINGLETON:
			bi.getMethod();
			bi.getInstType();
			bi.getClazz();
			
			break;
		case PROTOTYPE:
			break;
		default:
			
			break;
		}
		
		bi.setStatus(BeanDefinitionStatus.INST);
	}

}
