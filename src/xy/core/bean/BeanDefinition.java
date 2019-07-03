package xy.core.bean;

import java.util.List;

import xy.core.constant.BeanDefinitionScope;
import xy.core.constant.BeanDefinitionStatus;

public class BeanDefinition {

	protected Class<?> clazz;
	
	protected String parentName;
	
	protected String methodName;
	
	protected List<String> dependsOn;
	
	// module/bean name or classname or method name
	protected String beanId;

	// module or bean or custom
	protected String type;

	// define ,instantiated
	protected BeanDefinitionStatus status;
	// prototype or singleton
	protected BeanDefinitionScope scope;
	// instantiate : new or factory method
	// new or method name
	protected String instType;

	protected ParamterTypes paramTypes;

	protected ParamterValues paramValues;

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public List<String> getDependsOn() {
		return dependsOn;
	}

	public void setDependsOn(List<String> dependsOn) {
		this.dependsOn = dependsOn;
	}

	public String getBeanId() {
		return beanId;
	}

	public void setBeanId(String beanId) {
		this.beanId = beanId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BeanDefinitionStatus getStatus() {
		return status;
	}

	public void setStatus(BeanDefinitionStatus status) {
		this.status = status;
	}

	public BeanDefinitionScope getScope() {
		return scope;
	}

	public void setScope(BeanDefinitionScope scope) {
		this.scope = scope;
	}

	public String getInstType() {
		return instType;
	}

	public void setInstType(String instType) {
		this.instType = instType;
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
		return "BeanDefinition [clazz=" + clazz + ", parentName=" + parentName + ", methodName=" + methodName
				+ ", dependsOn=" + dependsOn + ", beanId=" + beanId + ", type=" + type + ", status=" + status
				+ ", scope=" + scope + ", instType=" + instType + ", paramTypes=" + paramTypes + ", paramValues="
				+ paramValues + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beanId == null) ? 0 : beanId.hashCode());
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + ((dependsOn == null) ? 0 : dependsOn.hashCode());
		result = prime * result + ((instType == null) ? 0 : instType.hashCode());
		result = prime * result + ((methodName == null) ? 0 : methodName.hashCode());
		result = prime * result + ((paramTypes == null) ? 0 : paramTypes.hashCode());
		result = prime * result + ((paramValues == null) ? 0 : paramValues.hashCode());
		result = prime * result + ((parentName == null) ? 0 : parentName.hashCode());
		result = prime * result + ((scope == null) ? 0 : scope.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanDefinition other = (BeanDefinition) obj;
		if (beanId == null) {
			if (other.beanId != null)
				return false;
		} else if (!beanId.equals(other.beanId))
			return false;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (dependsOn == null) {
			if (other.dependsOn != null)
				return false;
		} else if (!dependsOn.equals(other.dependsOn))
			return false;
		if (instType == null) {
			if (other.instType != null)
				return false;
		} else if (!instType.equals(other.instType))
			return false;
		if (methodName == null) {
			if (other.methodName != null)
				return false;
		} else if (!methodName.equals(other.methodName))
			return false;
		if (paramTypes == null) {
			if (other.paramTypes != null)
				return false;
		} else if (!paramTypes.equals(other.paramTypes))
			return false;
		if (paramValues == null) {
			if (other.paramValues != null)
				return false;
		} else if (!paramValues.equals(other.paramValues))
			return false;
		if (parentName == null) {
			if (other.parentName != null)
				return false;
		} else if (!parentName.equals(other.parentName))
			return false;
		if (scope != other.scope)
			return false;
		if (status != other.status)
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	
	
	
}
