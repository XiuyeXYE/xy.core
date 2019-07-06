package xy.core.annotaion.processor.impl;

import java.lang.reflect.Constructor;
import java.util.Map;

import xy.core.annotaion.Module;
import xy.core.annotaion.processor.AbstractMDefinitionProcessor;
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

public class ModuleDefProcessor extends AbstractMDefinitionProcessor {

	@Override
	public void process(Class<?> clazz, BeanDefintionRegistry registry) {

		xy.ifAnnotationNonNull(clazz.getAnnotation(Module.class), module -> {

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

			Map<String, MethodDef> mds = xy.map();

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
				mds.put(md.mId(), md);
			}

			bd.setMethod(mds);

			String name = module.value();

			if (xy.isNull(name) || name.isEmpty())
				name = xy.name(clazz);

			registry.registerBeanDefinition(name, bd);

			this.processScope(clazz, bd);

			this.processBean(clazz, registry);
		});
	}

}
