package org.esfinge.metadata.TestAnottation;

import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;

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
