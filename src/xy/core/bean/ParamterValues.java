package xy.core.bean;

import java.util.Arrays;
import java.util.List;

import com.xiuye.util.cls.TypeUtil;

public class ParamterValues {

	private List<Object> values;

	public ParamterValues() {
		this.values = TypeUtil.createList();
	}

	public ParamterValues(List<Object> values) {
		this.values = values;
	}

	public ParamterValues(Object... values) {
		this(Arrays.asList(values));
	}

	public Object[] getValues() {
		return values.toArray(new Object[values.size()]);
	}

	public void add(Object value) {
		this.values.add(value);
	}

	public int size() {
		return this.values.size();
	}

	@Override
	public String toString() {
		return "ParamterValues [values=" + values + "]";
	}

}
