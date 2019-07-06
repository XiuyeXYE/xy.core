package xy.core.util;

import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import com.xiuye.util.cls.TypeUtil;

import xy.core.bean.BeanDefinition;

public class xy {

	public static interface AnnotationNonNull<T> {
		void call(T t);
	}

	public static <T> void ifAnnotationNonNull(T t, AnnotationNonNull<T> callback) {
		if (nonNull(t)) {
			callback.call(t);
		}
	}

	public static <T> void ifNonNull(T t, Consumer<T> cons) {
		if (nonNull(t))
			cons.accept(t);
	}
	
	public static <R,T> R ifNonNull(T t,Function<T,R> func) {
		if(nonNull(t))
			return func.apply(t);
		return null;
	}

	public static Optional<ClassLoader> classLoader(String... paths) {
		try {
			return Optional.of(TypeUtil.createClassLoader(paths));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public static Optional<ClassLoader> nativeClassLoader() {
		try {
			return Optional.of(TypeUtil.createClassLoader());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return Optional.empty();
	}

	public static <T> List<T> list() {
		return TypeUtil.createList();
	}

	public static <T> Set<T> set() {
		return TypeUtil.createSet();
	}

	public static <K, V> Map<K, V> map() {
		return TypeUtil.createMap();
	}

	public static <T> boolean isNull(T obj) {
		return Objects.isNull(obj);
	}

	public static <T> boolean nonNull(T obj) {
		return Objects.nonNull(obj);
	}

	public static String uuid() {
		return UUID.randomUUID().toString().replace("-", "");
	}

	public static String moduleBeanDefaultId(Class<?> clazz) {
		String name = clazz.getSimpleName();
		char f = name.charAt(0);
		name = name.substring(1);
		name = Character.toUpperCase(f) + name;
		return name;
	}

	public static BeanDefinition createBeanDefinition() {
		return new BeanDefinition();
	}

	public static String name(Class<?> clazz) {
		String name = clazz.getSimpleName();
		return Character.toLowerCase(name.charAt(0)) + name.substring(1);
	}

	public static <T> T throwRuntimeException(String msg) {
		throw new RuntimeException(msg);
	}

	public static<T> T ifNull(T obj, Supplier<T> func) {
		if(isNull(obj)) {
			return func.get();
		}
		return obj;
	}
}
