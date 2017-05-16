package net.sf.esfinge.metadata.container;

import java.lang.reflect.Field;
import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ProcessorPerField;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;

@ContainerFor(ContainerTarget.FIELDS)
public class FieldMetadataContainer {
	@ElementName
	private String fieldName;

	@ProcessorPerField(configAnnotation=AnnotationReadingConfig.class, type=ProcessorType.READER_IS_PROCESSOR)
	private Map<Field, AnnotationReadingProcessor> processors;

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}


	
	
	public Map<Field, AnnotationReadingProcessor> getProcessors() {
		return processors;
	}

	public void setProcessors(Map<Field, AnnotationReadingProcessor> processors) {
		this.processors = processors;
	}

	@Override
	public String toString() {
		return "FieldMetadataContainer [fieldName=" + fieldName + ", objectToExecute=" + processors + "]";
	}
	
	
	
	

}
