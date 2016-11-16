package net.sf.esfinge.metadata.properties.containers;

import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ElementProperty;
import net.sf.esfinge.metadata.annotation.container.ElementPropertyWithoutAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;

@ContainerFor(ContainerTarget.TYPE)
public class Container {
	@ElementProperty
	private Map<String,PropertyDescriptor> properties;
	
	@ElementName
	private String idProp;
	
	public void addPropertyDescriptor(PropertyDescriptor descProp){
		properties.put(descProp.getName(), descProp);
	}
	public void removePropertyDescriptor(String prop){
		properties.remove(prop);
	}
	public PropertyDescriptor getPropertyDescriptor(String prop){
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

	public void setProperties(Map<String, PropertyDescriptor> propertiesNew) {
		this.properties = propertiesNew;
	}
	public Map<String, PropertyDescriptor> getProperties() {
		return properties;
	}
	
}
