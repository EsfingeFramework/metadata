package net.sf.esfinge.metadata.properties.containers;

import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ElementProperty;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerDescriptorWithContainAnnotation {
	@ElementProperty
	private Map<String,PropertyDescriptorAnnoted> properties;
	
	
	
	@ElementName
	private String idProp;
	
	public void addPropertyDescriptor(PropertyDescriptorAnnoted descProp){
		properties.put(descProp.getName(), descProp);
	}
	public void removePropertyDescriptor(String prop){
		properties.remove(prop);
	}
	public PropertyDescriptorAnnoted getPropertyDescriptor(String prop){
		return properties.get(prop);
	}
	public Set<String> getSetProperties(){
		return properties.keySet();
	}
	public String getIdProp() {
		return idProp;
	}
	public void setIdProp(String idProp) {
		this.idProp = idProp;
	}

	public void setProperties(Map<String, PropertyDescriptorAnnoted> propertiesNew) {
		this.properties = propertiesNew;
	}
	public Map<String, PropertyDescriptorAnnoted> getProperties() {
		return properties;
	}	
}
