package net.sf.esfinge.container.processor.parameter;

import java.util.List;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ProcessParameters;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.METHODS)
public class MethodContainer {
	
	@ProcessParameters
	private List<ParameterContainer> parameters;

	public List<ParameterContainer> getParameters() {
		return parameters;
	}

	public void setParameters(List<ParameterContainer> parameters) {
		this.parameters = parameters;
	}
	
	
	
}
