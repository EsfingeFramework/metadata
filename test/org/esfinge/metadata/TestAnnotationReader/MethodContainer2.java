package org.esfinge.metadata.TestAnnotationReader;

import org.esfinge.metadata.container.ContainerFor;
import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;
import org.esfinge.metadata.container.Propriedades;
@ContainerFor(vaule = Propriedades.METHODS)
public class MethodContainer2 {

	
	@ContainsAnnotation(Fake.class)
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
