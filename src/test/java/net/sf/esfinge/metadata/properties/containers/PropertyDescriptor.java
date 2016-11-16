package net.sf.esfinge.metadata.properties.containers;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.container.ContainerTarget;
@ContainerFor(ContainerTarget.ALL)
public class PropertyDescriptor {

	@ElementName
	private String name;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
