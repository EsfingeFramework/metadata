package net.sf.esfinge.metadata.properties.elements;

import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInc;
import net.sf.esfinge.metadata.properties.annotation.PropertyContrainAnnotation;

public class PropertyInMethod {
	int prop1;

	int prop2;
	
	public int getProp1() {
		return prop1;
	}
	public void setProp1(int prop1) {
		this.prop1 = prop1;
	}
	
	@PropertyContrainAnnotation
	public int getProp2() {
		return prop1;
	}
	public void setProp2(int prop1) {
		this.prop1 = prop1;
	}


}
