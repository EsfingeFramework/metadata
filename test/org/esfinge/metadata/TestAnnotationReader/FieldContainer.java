package org.esfinge.metadata.TestAnnotationReader;

import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.annotation.container.ContainsAnnotation;
import org.esfinge.metadata.annotation.container.ElementName;
import org.esfinge.metadata.container.Propriedades;
@ContainerFor(vaule = Propriedades.FIELDS)
public class FieldContainer {

	
	@ContainsAnnotation(FieldLista.class)
	private boolean toProcess;
	
	@ElementName
	public String field;

	public boolean isToProcess() {
		return toProcess;
	}

	public void setToProcess(boolean toProcess) {
		this.toProcess = toProcess;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "FieldContainer [toProcess=" + toProcess + ", field=" + field + "]";
	}
	
	
		
}
