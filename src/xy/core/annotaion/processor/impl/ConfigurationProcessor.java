package xy.core.annotaion.processor.impl;

import java.lang.reflect.Constructor;
import java.util.List;


import xy.core.annotaion.Configuration;
import xy.core.annotaion.processor.DefinitionProcessor;
import xy.core.bean.BeanDefinition;
import xy.core.bean.MethodDef;
import xy.core.bean.ParamterTypes;
import xy.core.constant.BeanDefinitionScope;
import xy.core.constant.BeanDefinitionStatus;
import xy.core.constant.BeanType;
import xy.core.constant.InstType;
import xy.core.constant.MethodName;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.util.xy;
import xy.core.annotaion.Scope;

public class ConfigurationProcessor implements DefinitionProcessor {

	private void processScope(Class<?> clazz, BeanDefinition bd) {
		Scope scope = clazz.getAnnotation(Scope.class);
		xy.ifAnnotationNonNull(scope, s->{
			bd.setScope(s.value());
		});		
	}
	
	private void processBean(Class<?> clazz, BeanDefintionRegistry registry) {
		
	}
	
	private void processModuleScan(Class<?> clazz,BeanDefintionRegistry registry) {
		
		
		
	}
	
	
	@Override
	public void process(Class<?> clazz, BeanDefintionRegistry registry) {

		Configuration config = clazz.getAnnotation(Configuration.class);

		if (xy.nonNull(config)) {

			

			Constructor<?>[] cons = clazz.getDeclaredConstructors();
//			if (cons.length == 0) {
//				throw new RuntimeException("It has no public constructor.");
//			}

			BeanDefinition bd = new BeanDefinition();
			bd.setBeanId(xy.uuid());
			bd.setClazz(clazz);
			bd.setInstType(InstType.NEW);
			bd.setStatus(BeanDefinitionStatus.READY);
			bd.setType(BeanType.M);
			bd.setScope(BeanDefinitionScope.SINGLETON);

			List<MethodDef> mds = xy.list();

			for (Constructor<?> con : cons) {
				MethodDef md = new MethodDef();
				int pCount = con.getParameterCount();
				if (pCount == 0) {
					md.setMethodName(MethodName.CONSTRUCTOR_WITHOUT_PARAMS);
				} else {
					md.setMethodName(MethodName.CONSTRUCTOR_WITH_PARAMS);
					Class<?>[] types = con.getParameterTypes();
					ParamterTypes pt = new ParamterTypes(types);
					md.setParamTypes(pt);
				}
				mds.add(md);
			}

			bd.setMethod(mds);
			
			String name = config.value();
			
			if(xy.isNull(name)||name.isEmpty())name = xy.name(clazz);
			
			registry.registerBeanDefinition(name, bd);

			this.processScope(clazz, bd);
			
			this.processBean(clazz,registry);
			
			this.processModuleScan(clazz,registry);
			
		}

	}

	

}
