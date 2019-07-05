package xy.core.global;

import xy.core.registry.BeanDefintionRegistry;
import xy.core.registry.BeanSingletonRegistry;

public class Global {
	public static final BeanDefintionRegistry beansDefRegistry = new BeanDefintionRegistry();
	public static final BeanSingletonRegistry beansInstRegistry = new BeanSingletonRegistry();
}
