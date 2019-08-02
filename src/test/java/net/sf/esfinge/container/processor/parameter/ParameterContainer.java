package net.sf.esfinge.container.processor.parameter;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.PARAMETER)
public class ParameterContainer {
	
	@ElementName
	private String parameterName;

	public String getParameterName() {
		return parameterName;
	}

	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	
	
	
}
