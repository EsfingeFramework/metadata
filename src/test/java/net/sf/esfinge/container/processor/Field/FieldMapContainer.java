package net.sf.esfinge.container.processor.Field;

import java.lang.reflect.Field;
import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.FieldProcessors;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;
import net.sf.esfinge.metadata.container.ContainerTarget;
@ContainerFor(ContainerTarget.FIELDS)
public class FieldMapContainer {
	
	@ElementName
	String element;
	
	@FieldProcessors(value = ProcessorAnnotation.class, type= ProcessorType.READER_ADDS_PROCESSOR)
	Map<Field,ProcessorInterface> map;

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public Map<Field, ProcessorInterface> getMap() {
		return map;
	}

	public void setMap(Map<Field, ProcessorInterface> map) {
		this.map = map;
	}

	
	
}
