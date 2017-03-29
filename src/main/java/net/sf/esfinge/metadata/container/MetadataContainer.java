package net.sf.esfinge.metadata.container;

import java.lang.reflect.Field;
import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.FieldProcessors;
import net.sf.esfinge.metadata.annotation.container.ProcessFields;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;

@ContainerFor(ContainerTarget.TYPE)
public class MetadataContainer {
	
	@ElementName
	private String containerName;
	
	@ReflectionReference
	private Class containerClass;
	
	@FieldProcessors(AnnotationReadingConfig.class)
	Map<Field, AnnotationReadingProcessor> objectToExecute;

	public String getContainerName() {
		return containerName;
	}

	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}

	public Map<Field, AnnotationReadingProcessor> getObjectToExecute() {
		return objectToExecute;
	}

	public void setObjectToExecute(Map<Field, AnnotationReadingProcessor> objectToExecute) {
		this.objectToExecute = objectToExecute;
	}

	public Class getContainerClass() {
		return containerClass;
	}

	public void setContainerClass(Class containerClass) {
		this.containerClass = containerClass;
	}

	@Override
	public String toString() {
		return "MetadataContainer [containerName=" + containerName + ", containerClass=" + containerClass
				+ ", objectToExecute=" + objectToExecute + "]";
	}
	
	
	
}
