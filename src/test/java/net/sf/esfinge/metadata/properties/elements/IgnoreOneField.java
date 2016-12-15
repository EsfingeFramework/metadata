package net.sf.esfinge.metadata.properties.elements;

import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;

public class IgnoreOneField {
	int prop1;
	int prop2;
	
	@IgnoreInComparison
	public int getProp1() {
		return prop1;
	}
	public void setProp1(int prop1) {
		this.prop1 = prop1;
	}
	public int getProp2() {
		return prop2;
	}
	public void setProp2(int prop2) {
		this.prop2 = prop2;
	}

}
