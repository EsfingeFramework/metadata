package org.esfinge.metadata.TestAnnotationReader;

import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.annotation.container.ContainsAnnotation;
import org.esfinge.metadata.annotation.container.ElementName;
import org.esfinge.metadata.container.Propriedades;

@ContainerFor(vaule = Propriedades.METHODS)
public class MethodContainer {

	
	@ContainsAnnotation(Proces.class)
	private boolean toProcess;
	
	@ElementName
	public String metodo;

	public boolean isToProcess() {
		return toProcess;
	}

	public void setToProcess(boolean toProcess) {
		this.toProcess = toProcess;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}
	
	
	
}
