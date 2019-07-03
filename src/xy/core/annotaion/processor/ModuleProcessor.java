package xy.core.annotaion.processor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import xy.core.annotaion.Module;
import xy.core.bean.BeanDefinition;
import xy.core.bean.BeanDefintionRegistry;
import xy.core.constant.BeanDefinitionScope;
import xy.core.constant.BeanDefinitionStatus;
import xy.core.constant.BeanType;
import xy.core.constant.InstType;
import xy.core.util.xy;

public class ModuleProcessor implements TypeProcessor {

	@Override
	public Object process(BeanDefinition bi, BeanDefintionRegistry registry, Object... params) {
		Object obj = null;

		Class<?> cls = bi.getClazz();

		Class<?>[] pType = this.pTypes(params);

		try {
			Constructor<?> con = cls.getDeclaredConstructor(pType);
			obj = con.newInstance(params);
		} catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e1) {
//			e.printStackTrace();
			try {
				obj = cls.newInstance();

			} catch (InstantiationException | IllegalAccessException e2) {
//				e1.printStackTrace();

				Constructor<?>[] cons = cls.getDeclaredConstructors();
				for (Constructor<?> con : cons) {
					try {
						obj = con.newInstance();
						break;
					} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
							| InvocationTargetException e) {
//						e.printStackTrace();
					}
				}
			}

		}

		return obj;
	}

	@Override
	public void obtainBeanDefinition(Class<?> clazz, BeanDefinition bi, BeanDefintionRegistry registry) {

		Module mAn = clazz.getAnnotation(Module.class);
		if (Objects.nonNull(mAn)) {
			bi.setBeanId(xy.uuid());
			bi.setClazz(clazz);
			bi.setInstType(InstType.NEW);
			bi.setStatus(BeanDefinitionStatus.READY);
			bi.setType(BeanType.M);
			bi.setScope(BeanDefinitionScope.SINGLETON);

//		bi.setMethodName();
//		bi.setParentName(clazz.getSimpleName());
//		Constructor<?> [] cons = clazz.getConstructors();
//		
//		if (cons.length == 0) {
//			throw new RuntimeException("It has no public constructor.");
//		}
//		for (Constructor<?> con : cons) {
//			BeanDefinition bd = new BeanDefinition();
//			bd.setBeanId(xy.uuid());
//			bd.setClazz(clazz);
//			bd.setInstType(InstType.NEW);
//			bd.setStatus(BeanDefinitionStatus.READY);
//			bd.setType(BeanType.M);
//			bd.setScope(BeanDefinitionScope.SINGLETON);
//			bd.setMethodName(MethodName.CONSTRUCTOR_WITH_PARAMS);
//			Class<?>[] types = con.getParameterTypes();
//			ParamterTypes pt = new ParamterTypes(types);
//			bd.setParamTypes(pt);
//		}
//		

			// class <=> bean definition
			registry.registerBeanDefinition(clazz.getName(), bi);

			String name = mAn.value();

			// name <=> bean definition
			if (xy.isNull(name) || name.isEmpty()) {
				this.checkExist(xy.name(clazz), registry);
				registry.registerBeanDefinition(xy.name(clazz), bi);
			} else {
				this.checkExist(name, registry);
				registry.registerBeanDefinition(name, bi);
			}
		}
	}

}
