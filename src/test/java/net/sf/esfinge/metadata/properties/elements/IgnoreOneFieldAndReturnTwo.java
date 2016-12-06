package net.sf.esfinge.metadata.properties.elements;

import net.sf.esfinge.metadata.properties.annotation.IgnoreInComparison;
import net.sf.esfinge.metadata.properties.annotation.IgnoreInc;

public class IgnoreOneFieldAndReturnTwo {
	private int prop1;
	private int prop2;
	private int prop3;

	
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
	public int getProp3() {
		return prop3;
	}
	public void setProp3(int prop3) {
		this.prop3 = prop3;
	}

	
}
