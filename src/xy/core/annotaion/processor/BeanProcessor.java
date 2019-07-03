package xy.core.annotaion.processor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import xy.core.annotaion.Bean;
import xy.core.bean.BeanDefinition;
import xy.core.bean.BeanDefintionRegistry;
import xy.core.bean.ParamterTypes;
import xy.core.constant.BeanDefinitionScope;
import xy.core.constant.BeanDefinitionStatus;
import xy.core.constant.BeanType;
import xy.core.constant.InstType;
import xy.core.util.xy;

public class BeanProcessor implements MethodProcessor {

	@Override
	public void obtainBeanDefinition(Class<?> clazz, Method method, BeanDefinition bi, BeanDefintionRegistry registry) {

		Bean bAn = method.getAnnotation(Bean.class);
		if (xy.nonNull(bAn)) {
			Class<?> retType = method.getReturnType();

			bi.setBeanId(xy.uuid());
			bi.setClazz(retType);
			bi.setInstType(InstType.PARENT_METHOD);
			bi.setStatus(BeanDefinitionStatus.READY);
			bi.setType(BeanType.B);
			bi.setScope(BeanDefinitionScope.SINGLETON);
			bi.setMethodName(method.getName());
			bi.setParentName(clazz.getSimpleName());
			int pCount = method.getParameterCount();
			if (pCount > 0) {
				Class<?>[] types = method.getParameterTypes();
				ParamterTypes pt = new ParamterTypes(types);
				bi.setParamTypes(pt);
			}

			// class <=> bean definition
			registry.registerBeanDefinition(retType.getName(), bi);

			String[] names = bAn.value();

			// name <=> bean definition
			if (names.length == 1) {
				String name = names[0];
				if (xy.isNull(name) || name.isEmpty()) {
					this.checkExist(xy.name(retType), registry);
					registry.registerBeanDefinition(xy.name(retType), bi);
				}
			}

			for (String name : names) {
				this.checkExist(name, registry);
				registry.registerBeanDefinition(name, bi);
			}
		}
	}

	@Override
	public Object process(BeanDefinition bi, BeanDefintionRegistry registry, Object... params) {

		Object obj = null;

		String mn = bi.getMethodName();

		String pClsName = bi.getParentName();

		BeanDefinition bP = registry.get(pClsName);
//		Class<?>[] pType = this.pTypes(params);
		Class<?> pCls = bP.getClazz();
		try {
			Method method = pCls.getDeclaredMethod(mn, bi.getParamTypes().getTypes());
			method.invoke(obj, params);
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

		return obj;
	}

}
