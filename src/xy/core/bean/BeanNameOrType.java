package xy.core.bean;

import java.util.List;

public class BeanNameOrType {

	//实例名字或者别名 可以很多 byname
	private List<String> names;
	//对应clazz ，方便根据clazz找到 name进行注入 bytype
	private Class<?> clazz;
	public List<String> getNames() {
		return names;
	}
	public void setNames(List<String> names) {
		this.names = names;
	}
	public Class<?> getClazz() {
		return clazz;
	}
	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}
	@Override
	public String toString() {
		return "BeanNameOrType [names=" + names + ", clazz=" + clazz + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clazz == null) ? 0 : clazz.hashCode());
		result = prime * result + ((names == null) ? 0 : names.hashCode());
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
		BeanNameOrType other = (BeanNameOrType) obj;
		if (clazz == null) {
			if (other.clazz != null)
				return false;
		} else if (!clazz.equals(other.clazz))
			return false;
		if (names == null) {
			if (other.names != null)
				return false;
		} else if (!names.equals(other.names))
			return false;
		return true;
	}
	
	
	
}
