package net.sf.esfinge.metadata.properties.containers;

import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.container.AnnotedMethods;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ElementProperty;
import net.sf.esfinge.metadata.annotation.container.ElementPropertyWithoutAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerAnnotedMethod {
	@AnnotedMethods
	private List<PropertyDescriptor> propertiesList;

	
	@ElementName
	private String idProp;

	public String getIdProp() {
		return idProp;
	}
	public void setIdProp(String idProp) {
		this.idProp = idProp;
	}


	public List<PropertyDescriptor> getPropertiesList() {
		return propertiesList;
	}
	public void setPropertiesList(List<PropertyDescriptor> propertiesList) {
		this.propertiesList = propertiesList;
	}
	
	
}
