package xy.core.annotaion.processor.impl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import xy.core.annotaion.processor.InstanceProcessor;
import xy.core.bean.BeanDefinition;
import xy.core.bean.MethodDef;
import xy.core.bean.ParamterTypes;
import xy.core.bean.ParamterValues;
import xy.core.constant.BeanDefinitionScope;
import xy.core.constant.BeanDefinitionStatus;
import xy.core.constant.InstType;
import xy.core.constant.MethodName;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;
import xy.core.util.xy;

public class BeanInstProcessor implements InstanceProcessor {

	@Override
	public void process(String name, BeanDefinition bi, BeanDefintionRegistry defRegistry,
			BeanSingletonRegistry instRegistry) {

		if (bi.getStatus() == BeanDefinitionStatus.INST) {
			return;
		}

		xy.ifNonNull(bi.getDependsOn(), dependsBeanNames -> {
			for (String beanName : dependsBeanNames) {
				this.process(beanName, defRegistry.getDefinition(beanName), defRegistry, instRegistry);
			}
		});

		String parent = bi.getParentName();

		if (xy.nonNull(parent)) {
			this.process(parent, defRegistry.getDefinition(parent), defRegistry, instRegistry);
		}

		BeanDefinitionScope scope = bi.getScope();
		switch (scope) {
		case SINGLETON:
			Map<String, MethodDef> methodDefs = bi.getMethod();
			String instType = bi.getInstType();
			Class<?> clazz = bi.getClazz();
			switch (instType) {
			case InstType.NEW:
				this.newInstance(name, defRegistry, instRegistry, methodDefs, clazz);
				break;
			case InstType.PARENT_METHOD:
			case InstType.STATIC_METHOD:
				this.parentMethodInstance(name, defRegistry, instRegistry, parent, methodDefs);
				break;
			default:
				break;
			}

			break;
		case PROTOTYPE:
			break;
		default:

			break;
		}

		bi.setStatus(BeanDefinitionStatus.INST);
	}

	private void parentMethodInstance(String name, BeanDefintionRegistry defRegistry,
			BeanSingletonRegistry instRegistry, String parent, Map<String, MethodDef> methodDefs) {
		Object po = instRegistry.get(parent);
		methodDefs.forEach((k, md) -> {
			String mn = md.getMethodName();
			ParamterTypes pt = md.getParamTypes();
			ParamterValues pv = md.getParamValues();
			try {
				Object singleton = null;
				if (xy.isNull(pt)) {
					Method m = po.getClass().getDeclaredMethod(mn);
					singleton = m.invoke(po);
				} else {

					Method m = po.getClass().getDeclaredMethod(mn, pt.getTypes());
					if (xy.isNull(pv)) {
						singleton = m.invoke(po);
					} else {
						singleton = m.invoke(po, pv.getValues());
					}
				}

				instRegistry.registerBeanInst(name, singleton);
				List<String> aliases = defRegistry.getAlias(name);
				if (xy.nonNull(aliases))
					for (String alias : aliases) {
						instRegistry.registerBeanInst(alias, singleton);
					}

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				e.printStackTrace();
			}

		});
	}

	private void newInstance(String name, BeanDefintionRegistry defRegistry, BeanSingletonRegistry instRegistry,
			Map<String, MethodDef> methodDefs, Class<?> clazz) {
		methodDefs.forEach((k, md) -> {
			String mn = md.getMethodName();
			ParamterTypes pt = md.getParamTypes();
			ParamterValues pv = md.getParamValues();
			try {
				Constructor<?> con = null;
				Object singleton = null;
				if (MethodName.CONSTRUCTOR_WITHOUT_PARAMS.equals(mn)) {
					con = clazz.getDeclaredConstructor();
					con.setAccessible(true);
					singleton = con.newInstance();
				} else if (MethodName.CONSTRUCTOR_WITH_PARAMS.equals(mn)) {
					con = clazz.getDeclaredConstructor(pt.getTypes());
					con.setAccessible(true);
					if (xy.isNull(pv)) {
						singleton = con.newInstance();
					} else {
						singleton = con.newInstance(pv.getValues());
					}
				}

				instRegistry.registerBeanInst(name, singleton);
				List<String> aliases = defRegistry.getAlias(name);
				if (xy.nonNull(aliases))
					for (String alias : aliases) {
						instRegistry.registerBeanInst(alias, singleton);
					}
			} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
					| IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		});
//						

	}

}
