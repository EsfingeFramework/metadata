package net.sf.esfinge.containerProcessosrsTest;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.container.ContainerTarget;
@ContainerFor(ContainerTarget.FIELDS)
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
