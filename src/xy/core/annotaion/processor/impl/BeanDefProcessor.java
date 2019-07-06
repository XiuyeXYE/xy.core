package xy.core.annotaion.processor.impl;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;

import xy.core.annotaion.Bean;
import xy.core.annotaion.processor.AbstractDefinitionProcessor;
import xy.core.bean.BeanDefinition;
import xy.core.bean.MethodDef;
import xy.core.bean.ParamterTypes;
import xy.core.constant.BeanDefinitionScope;
import xy.core.constant.BeanDefinitionStatus;
import xy.core.constant.BeanType;
import xy.core.constant.InstType;
import xy.core.registry.BeanDefintionRegistry;
import xy.core.util.xy;

public class BeanDefProcessor extends AbstractDefinitionProcessor {

	@Override
	public void process(Class<?> clazz, BeanDefintionRegistry registry) {

		Method[] ms = clazz.getDeclaredMethods();
		for (Method m : ms) {
			xy.ifAnnotationNonNull(m.getAnnotation(Bean.class), b -> {

				Class<?> retType = m.getReturnType();

				BeanDefinition bd = new BeanDefinition();
//				bd.setBeanId(xy.uuid());
				bd.setParentName(xy.name(clazz));
				bd.setClazz(retType);
				bd.setInstType(InstType.PARENT_METHOD);
				bd.setStatus(BeanDefinitionStatus.READY);
				bd.setType(BeanType.B);
				bd.setScope(BeanDefinitionScope.SINGLETON);
				bd.setDependsOn(Arrays.asList(bd.getParentName()));
				Map<String, MethodDef> mds = xy.map();

				MethodDef md = new MethodDef();
				int pCount = m.getParameterCount();
				md.setMethodName(m.getName());
				if (pCount > 0) {
					Class<?>[] types = m.getParameterTypes();
					ParamterTypes pt = new ParamterTypes(types);
					md.setParamTypes(pt);
				}
				mds.put(md.mId(), md);

				bd.setMethod(mds);

				String[] aliases = b.value();

				String name = aliases[0];
				if (name.isEmpty())
					name = xy.name(retType);
				bd.setBeanId(name);
				registry.registerBeanDefinition(name, bd);

				for (String alias : aliases) {
					if (!name.equals(alias) && !alias.isEmpty())
						registry.registerAlias(name, alias);
				}

				this.processScope(clazz, bd);

			});
		}
	}

}
