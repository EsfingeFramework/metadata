package org.esfinge.metadata.container;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class ContainerMetadados {
	
	//TODO: Add more functionalities
	//Avoided filling it up too much (Properties only has boolean, String and Integer)
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
