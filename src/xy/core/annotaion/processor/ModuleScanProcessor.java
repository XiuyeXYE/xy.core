package xy.core.annotaion.processor;

import java.util.List;

import xy.core.annotaion.ModuleScan;
import xy.core.annotaion.handler.AnnotationedClassScanner;
import xy.core.bean.BeanDefinition;
import xy.core.bean.BeanDefintionRegistry;
import xy.core.bean.handler.ClassScanner;
import xy.core.util.xy;

public class ModuleScanProcessor implements TypeProcessor {

	@Override
	public Object process(BeanDefinition bi, BeanDefintionRegistry registry, Object... params) {
		return null;
	}

	@Override
	public void obtainBeanDefinition(Class<?> clazz, BeanDefinition bi, BeanDefintionRegistry registry) {

		ModuleScan msAn = clazz.getAnnotation(ModuleScan.class);
		if (xy.nonNull(msAn)) {
			String[] packages = msAn.value();

			ClassScanner cs = new AnnotationedClassScanner(packages);

			List<String> clsNames = cs.allClassNames();
			ModuleProcessor p = new ModuleProcessor();
			ClassLoader cl = xy.nativeClassLoader().get();
			for (String clsName : clsNames) {
				try {
					p.obtainBeanDefinitionProxy(cl.loadClass(clsName), bi, registry);
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}

		}

	}

}
