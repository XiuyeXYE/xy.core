package xy.core.test;

import com.xiuye.util.log.LogUtil;

public class Test1 {

	
	public Test1(int a,int b){
		
	}
	
	public Test1(){
		
	}
	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException {

		LogUtil.log(Test1.class.getName());
		LogUtil.log(Test1.class.getSimpleName());
		LogUtil.log(Test1.class.getTypeName());
		LogUtil.log(Test1.class.getCanonicalName());
		LogUtil.log(Test1.class.getConstructors());
		
		LogUtil.log(Test1.class.getDeclaredMethods());
		LogUtil.log(Test1.class.getConstructor(int.class,int.class));
		
		LogUtil.log(Test1.class.getConstructor(new Class[] {}));
		LogUtil.log(Test1.class.newInstance());
		LogUtil.log(new Class[] {}.length);
		LogUtil.log(Test1.class.cast(new Test1()));
		
	}

}
