package net.sf.esfinge.container.processor.parameter;
import java.util.List;

import net.sf.esfinge.metadata.annotation.container.AllMethodsWith;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ProcessMethods;
import net.sf.esfinge.metadata.container.ContainerTarget;


@ContainerFor(ContainerTarget.TYPE)
public class ContainerClazz {
	
	@ProcessMethods
	private List<MethodContainer> methodContainer;
	
	@AllMethodsWith(Annoted.class)
	private List<MethodContainer> methodWithAnn;

	public List<MethodContainer> getMethodContainer() {
		return methodContainer;
	}

	public void setMethodContainer(List<MethodContainer> methodContainer) {
		this.methodContainer = methodContainer;
	}

	public List<MethodContainer> getMethodWithAnn() {
		return methodWithAnn;
	}

	public void setMethodWithAnn(List<MethodContainer> methodWithAnn) {
		this.methodWithAnn = methodWithAnn;
	}
	
	
	
}
