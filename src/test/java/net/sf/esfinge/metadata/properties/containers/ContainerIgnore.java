package net.sf.esfinge.metadata.properties.containers;

import java.util.List;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ElementPropertyWithoutAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerIgnore {
	@ElementPropertyWithoutAnnotation(IgnoreInComparison.class)
	private List<PropertyDescriptorAnnoted> properties;
	
	@ElementName
	private String idProp;

	public List<PropertyDescriptorAnnoted> getProperties() {
		return properties;
	}

	public void setProperties(List<PropertyDescriptorAnnoted> properties) {
		this.properties = properties;
	}

	public String getIdProp() {
		return idProp;
	}

	public void setIdProp(String idProp) {
		this.idProp = idProp;
	}
	
	
}
