package xy.core.map;

import java.util.List;
import java.util.Map;

import xy.core.util.xy;

public class AliasMap {

	// name => aliases
	private Map<String, List<String>> name_aliases;
	// alias => name
	private Map<String, String> alias_name;

	public AliasMap() {
		this.name_aliases = xy.map();
		this.alias_name = xy.map();
	}

	public List<String> getAliases(String name){
		return this.name_aliases.get(name);
	}
	
	public String getName(String alias) {
		return this.alias_name.get(alias);
	}
	
	public void put(String name, String alias) {

		if (xy.nonNull(this.alias_name.putIfAbsent(alias, name))) {
			throw new RuntimeException("Bean alias name is override!");
		}
		List<String> aliases = this.name_aliases.get(name);
		if (xy.isNull(aliases)) {
			aliases = xy.list();
			this.name_aliases.put(name, aliases);
		}
		aliases.add(alias);
	}

	@Override
	public String toString() {
		return "AliasMap [name_aliases=" + name_aliases + ", alias_name=" + alias_name + "]";
	}

}
