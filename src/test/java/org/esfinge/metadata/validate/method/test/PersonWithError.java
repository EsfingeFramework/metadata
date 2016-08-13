package org.esfinge.metadata.validate.method.test;

import java.util.HashSet;
import java.util.Set;

public class PersonWithError extends Person{
	
	private int notStaticValue = 42;	
	
	protected String oneProtectedString;	
	
	float oneDefaultfloat = 4.2f;	

	transient String oneDefaultString;

	public volatile long oneVolatileLong = 2372983;	

	private static String oneStaticString = "";
	
	public static String otherStaticString = "";
	
	Set<Object> oneSet = new HashSet<>();	
	
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}

	
	public int getNotStaticValue() {
		return notStaticValue;
	}

	public void setNotStaticValue(int notStaticValue) {
		this.notStaticValue = notStaticValue;
	}

	public String getOneProtectedString() {
		return oneProtectedString;
	}

	public void setOneProtectedString(String oneProtectedString) {
		this.oneProtectedString = oneProtectedString;
	}

	public float getOneDefaultfloat() {
		return oneDefaultfloat;
	}

	public void setOneDefaultfloat(float oneDefaultfloat) {
		this.oneDefaultfloat = oneDefaultfloat;
	}

	public String getOneDefaultString() {
		return oneDefaultString;
	}

	public void setOneDefaultString(String oneDefaultString) {
		this.oneDefaultString = oneDefaultString;
	}

	public long getOneVolatileLong() {
		return oneVolatileLong;
	}

	public void setOneVolatileLong(long oneVolatileLong) {
		this.oneVolatileLong = oneVolatileLong;
	}

	public static String getOneStaticString() {
		return oneStaticString;
	}

	public static void setOneStaticString(String oneStaticString) {
		PersonWithError.oneStaticString = oneStaticString;
	}

	public static String getOtherStaticString() {
		return otherStaticString;
	}

	public static void setOtherStaticString(String otherStaticString) {
		PersonWithError.otherStaticString = otherStaticString;
	}

	public Set<Object> getOneSet() {
		return oneSet;
	}

	public void setOneSet(Set<Object> oneSet) {
		this.oneSet = oneSet;
	}
	
}
