package net.sf.esfinge.metadata.properties.containers;

import java.util.List;

import net.sf.esfinge.metadata.annotation.container.AnnotedMethods;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.container.ContainerTarget;

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
