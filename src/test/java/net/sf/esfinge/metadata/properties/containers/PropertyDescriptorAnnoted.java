package net.sf.esfinge.metadata.properties.containers;

import net.sf.esfinge.container.processor.method.ProcessorAnnotation;
import net.sf.esfinge.container.processor.method.ProcessorInterface;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.PropertyContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.PropertyProcessors;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.properties.annotation.PropertyAnnotation;

import java.util.List;

@ContainerFor(ContainerTarget.PROPERTY)
public class PropertyDescriptorAnnoted {

	@ElementName
	private String name;

	@PropertyContainsAnnotation(PropertyAnnotation.class)
	private boolean annoted;

	//@PropertyProcessors(ProcessorAnnotation.class)
	private List<ProcessorInterface> m1;
	
	
		
	public List<ProcessorInterface> getM1() {
		return m1;
	}

	public void setM1(List<ProcessorInterface> m1) {
		this.m1 = m1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isAnnoted() {
		return annoted;
	}

	public void setAnnoted(boolean annoted) {
		this.annoted = annoted;
	}
	
	
}
