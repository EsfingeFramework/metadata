package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.Containers;

import java.util.List;

import net.sf.esfinge.metadata.annotation.container.AnnotationPropertyLocation;
import net.sf.esfinge.metadata.annotation.container.PropertyProcessorsNew;

public class ContainerProcessor {
	
	@PropertyProcessorsNew(AnnotationPropertyLocation.ATTRIBUTE_ONLY)
	List<PropertyContainer> propertyContainerAtribute;

	public List<PropertyContainer> getPropertyContainer() {
		return propertyContainerAtribute;
	}

	public void setPropertyContainer(List<PropertyContainer> propertyContainerAtribute) {
		this.propertyContainerAtribute = propertyContainerAtribute;
	}

	
}
