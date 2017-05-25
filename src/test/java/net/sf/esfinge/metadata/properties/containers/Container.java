package net.sf.esfinge.metadata.properties.containers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.container.AnnotationPropertyLocation;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ElementProperty;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class Container {
	@ElementProperty(property = AnnotationPropertyLocation.ALL)
	private Map<String,PropertyDescriptor> properties;

	@ElementProperty(property = AnnotationPropertyLocation.ALL)
	private Set<PropertyDescriptor> propertiesSet;

	@ElementProperty(property = AnnotationPropertyLocation.ALL)
	private List<PropertyDescriptor> propertiesList;

	
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
	public Set<PropertyDescriptor> getPropertiesSet() {
		return propertiesSet;
	}
	public void setPropertiesSet(Set<PropertyDescriptor> propertiesSet) {
		this.propertiesSet = propertiesSet;
	}
	public List<PropertyDescriptor> getPropertiesList() {
		return propertiesList;
	}
	public void setPropertiesList(List<PropertyDescriptor> propertiesList) {
		this.propertiesList = propertiesList;
	}
	
	
}
