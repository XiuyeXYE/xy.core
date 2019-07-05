package xy.core.bean;

import java.util.List;

import xy.core.constant.BeanDefinitionScope;
import xy.core.constant.BeanDefinitionStatus;


public class BeanDefinition {

	protected Class<?> clazz;
	
	protected String parentName;
	
	protected List<MethodDef> method;
	
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
	public List<MethodDef> getMethod() {
		return method;
	}
	public void setMethod(List<MethodDef> method) {
		this.method = method;
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
	@Override
	public String toString() {
		return "BeanDefinition [clazz=" + clazz + ", parentName=" + parentName + ", method=" + method + ", dependsOn="
				+ dependsOn + ", beanId=" + beanId + ", type=" + type + ", status=" + status + ", scope=" + scope
				+ ", instType=" + instType + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beanId == null) ? 0 : beanId.hashCode());
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + ((dependsOn == null) ? 0 : dependsOn.hashCode());
		result = prime * result + ((instType == null) ? 0 : instType.hashCode());
		result = prime * result + ((method == null) ? 0 : method.hashCode());
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
		if (method == null) {
			if (other.method != null)
				return false;
		} else if (!method.equals(other.method))
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
