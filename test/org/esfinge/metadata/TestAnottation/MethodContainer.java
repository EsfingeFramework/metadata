package org.esfinge.metadata.TestAnottation;

import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;

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
