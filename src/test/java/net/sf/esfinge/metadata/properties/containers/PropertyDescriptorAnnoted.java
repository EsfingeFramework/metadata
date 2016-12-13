package net.sf.esfinge.metadata.properties.containers;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.PropertyContainsAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.properties.annotation.PropertyAnnotation;
import net.sf.esfinge.metadata.properties.annotation.PropertyContrainAnnotation;
@ContainerFor(ContainerTarget.ALL)
public class PropertyDescriptorAnnoted {

	@ElementName
	private String name;

	@PropertyContainsAnnotation(PropertyAnnotation.class)
	private boolean annoted;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAnnoted() {
		return annoted;
	}

	public void setAnnoted(boolean annoted) {
		this.annoted = annoted;
	}
	
	
}
