package xy.core.bean;

import java.util.Arrays;
import java.util.List;

import com.xiuye.util.cls.TypeUtil;

public class ParamterTypes {

	private List<Class<?>> types;

	public ParamterTypes() {
		this.types = TypeUtil.createList();
	}

	public ParamterTypes(List<Class<?>> types) {
		this.types = types;
	}

	public ParamterTypes(Class<?>... types) {
		this(Arrays.asList(types));
	}

	public void add(Class<?> type) {
		this.types.add(type);
	}

	public Class<?>[] getTypes() {
		return types.toArray(new Class<?>[this.types.size()]);
	}

	public int size() {
		return this.types.size();
	}
	
	public boolean isEmpty() {
		return this.types.isEmpty();
	}
	
	@Override
	public String toString() {
		return "ParamterTypes [types=" + types + "]";
	}

}
