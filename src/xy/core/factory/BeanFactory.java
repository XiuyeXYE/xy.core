package xy.core.factory;

public interface BeanFactory {

	<T> T getBean(Class<T> clazz);

	<T> T getBean(String name);

	<T> T getBean(String name, Class<T> clazz);

	<T> T getBean(Class<T> clazz, Object... params);

	<T> T getBean(String name, Object... params);

	<T> T getBean(String name, Class<T> clazz, Object... params);

	//force new bean
	<T> T getNewBean(Class<T> clazz);

	<T> T getNewBean(String name);

	<T> T getNewBean(String name, Class<T> clazz);

	default <T> T getNewBean(Class<T> clazz, Object... params) {
		return this.getBean(clazz, params);
	}

	default <T> T getNewBean(String name, Object... params) {
		return this.getBean(name, params);
	}

	default <T> T getNewBean(String name, Class<T> clazz, Object... params) {
		return this.getBean(name, clazz, params);
	}

}
