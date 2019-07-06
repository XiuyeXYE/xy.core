package xy.core.registry;

import xy.core.global.Global;
import xy.core.map.BeanSingletonMap;
import xy.core.util.xy;

public class BeanSingletonRegistry {

	private BeanSingletonMap bsMap = new BeanSingletonMap();

//	private BeanDefintionRegistry defRegistry = Global.beansDefRegistry;

	public void registerBeanInst(String name, Object obj) {
		if (xy.nonNull(this.bsMap.get(name))) {
			xy.throwRuntimeException("name=>bean instance: " + name + " is already existed!");
		}
		this.bsMap.put(name, obj);
	}

	public Object get(String name) {
		return this.bsMap.get(name);
	}

	@Override
	public String toString() {
		return "BeanSingletonRegistry [bsMap=" + bsMap + "]";
	}

	
	
}
