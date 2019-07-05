package xy.core.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.xiuye.util.log.LogUtil;

public class Test2 {

	@Target(ElementType.TYPE)
	@Retention(RetentionPolicy.RUNTIME)
	@Inherited
	static @interface W{
		
	}
	
	@W
	static class A{
		
	}
	
	static class B extends A{
		
	}
	
	public static void main(String[] args) {

		//return inherited annotation
		LogUtil.log(B.class.getAnnotation(W.class));
		LogUtil.log(B.class.getDeclaredAnnotation(W.class));
		
	}

}
