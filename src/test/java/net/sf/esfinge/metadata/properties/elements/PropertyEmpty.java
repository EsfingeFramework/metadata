package net.sf.esfinge.metadata.properties.elements;

import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;

public class PropertyEmpty {
	int prop1;

	
	@IgnoreInComparison
	public int getProp1() {
		return prop1;
	}
	public void setProp1(int prop1) {
		this.prop1 = prop1;
	}


}
