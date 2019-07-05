package xy.core.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import com.xiuye.util.log.LogUtil;

public class Test2 {

	@Target({ ElementType.TYPE, ElementType.METHOD })
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	static @interface W {

	}

	@W
	static class A {
		@W
		protected void f() {
			
		}
	}

	static class B extends A {
		@Override
		public void f() {
			super.f();
		}
		private void g() {}
	}

	public static void main(String[] args) throws NoSuchMethodException, SecurityException {

		// return inherited annotation
		LogUtil.log(B.class.getAnnotation(W.class));
		LogUtil.log(B.class.getDeclaredAnnotation(W.class));
		Method m = B.class.getDeclaredMethod("f");
//		Method g1 = B.class.getMethod("g");
		Method g = B.class.getDeclaredMethod("g");
		LogUtil.log(m.getAnnotation(W.class));
		LogUtil.log(m.getDeclaredAnnotation(W.class));
		W w = B.class.getAnnotation(W.class);
		LogUtil.log(w.annotationType());

		LogUtil.log(B.class.isAnnotationPresent(W.class));
		
	}

}
