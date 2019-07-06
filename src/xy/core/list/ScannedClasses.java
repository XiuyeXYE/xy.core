package xy.core.list;

import java.util.Iterator;
import java.util.List;

import xy.core.util.xy;

public class ScannedClasses implements Iterable<Class<?>> {

	private List<Class<?>> scList;

	public ScannedClasses() {
		this.scList = xy.list();
	}

	public void add(Class<?> clazz) {
		if (!this.scList.contains(clazz))
			this.scList.add(clazz);
	}

	public List<Class<?>> list() {
		return this.scList;
	}

	public boolean scanned(Class<?> clazz) {
		return this.scList.contains(clazz);
	}

	@Override
	public Iterator<Class<?>> iterator() {
		return this.scList.iterator();
	}

}
