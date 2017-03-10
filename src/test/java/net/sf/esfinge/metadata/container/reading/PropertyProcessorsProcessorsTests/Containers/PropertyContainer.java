package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.Containers;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.container.ContainerTarget;


@ContainerFor(ContainerTarget.ALL)
public class PropertyContainer {
	
	
	@ElementName
	private String propertyName;

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	
	
	
}
