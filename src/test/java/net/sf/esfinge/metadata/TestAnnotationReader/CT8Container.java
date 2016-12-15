package net.sf.esfinge.metadata.TestAnnotationReader;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
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
