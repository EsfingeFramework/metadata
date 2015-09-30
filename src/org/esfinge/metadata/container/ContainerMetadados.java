package org.esfinge.metadata.container;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ContainerMetadados {
	
	//TODO: Debug test and add more functionalities
	//Avoided filling it up too much (Properties only has boolean, no String or Integer, etc)
	//Because I don't yet know what will be necessary
	
	private Map<String, Properties> props = new HashMap<>();
	
	public Set<String> getPropriedades(){
		return props.keySet();
	}
	
	public Properties getValue(String propKey){
		return props.get(propKey);
	}

	public void addPropriedade(Properties inputProp){
		props.put(inputProp.getName(), inputProp);
	}
	
	
}
