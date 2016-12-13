package net.sf.esfinge.metadata.properties.containers;

import java.util.List;
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
	private Map<String,PropertyDescriptorAnnoted> properties;

	@ElementProperty
	private Set<PropertyDescriptorAnnoted> propertiesSet;

	@ElementProperty
	private List<PropertyDescriptorAnnoted> propertiesList;

	
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
	public Set<PropertyDescriptorAnnoted> getPropertiesSet() {
		return propertiesSet;
	}
	public void setPropertiesSet(Set<PropertyDescriptorAnnoted> propertiesSet) {
		this.propertiesSet = propertiesSet;
	}
	public List<PropertyDescriptorAnnoted> getPropertiesList() {
		return propertiesList;
	}
	public void setPropertiesList(List<PropertyDescriptorAnnoted> propertiesList) {
		this.propertiesList = propertiesList;
	}
	
	
}
