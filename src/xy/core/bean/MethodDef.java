package xy.core.bean;

public class MethodDef {

	private String methodName;
	private ParamterTypes paramTypes;
	private ParamterValues paramValues;

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public ParamterTypes getParamTypes() {
		return paramTypes;
	}

	public void setParamTypes(ParamterTypes paramTypes) {
		this.paramTypes = paramTypes;
	}

	public ParamterValues getParamValues() {
		return paramValues;
	}

	public void setParamValues(ParamterValues paramValues) {
		this.paramValues = paramValues;
	}

	@Override
	public String toString() {
		return "MethodDef [methodName=" + methodName + ", paramTypes=" + paramTypes + ", paramValues=" + paramValues
				+ "]";
	}

}
