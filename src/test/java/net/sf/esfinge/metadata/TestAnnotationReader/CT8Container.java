package net.sf.esfinge.metadata.TestAnnotationReader;

import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(vaule = ContainerTarget.CLASS)
public class CT8Container {
		
	@ReflectionReference
	private Class<?> classValue;
	

	public Class<?> getClassValue() {
		return classValue;
	}

	public void setClassValue(Class<?> classValue) {
		this.classValue = classValue;
	}
		

}
