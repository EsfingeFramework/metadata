package org.esfinge.metadata.validate.method.test;

import java.util.HashSet;
import java.util.Set;

import org.esfinge.metadata.annotation.container.method.OneAnnotationWithFinalMethodOnly;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithForbiddenMethodReturn;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithInstanceMethodOnly;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithMethodVisibilityForbidden;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithMethodVisibilityRequired;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithNoParametersMethodOnly;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithStaticMethodOnly;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithStrictfpMethodOnly;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithSynchronizedMethodOnly;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithValidMethodReturn;
import org.esfinge.metadata.annotation.container.method.OneAnnotationWithValidNumberOfParameters;

public class PersonWithError extends Person{
	
	private int notStaticValue = 42;	
	
	protected String oneProtectedString;	
	
	float oneDefaultfloat = 4.2f;	

	transient static String oneDefaultString;

	public volatile long oneVolatileLong = 2372983;	

	private static String oneStaticString = "";
	
	public static String otherStaticString = "";
	
	Set<Object> oneSet = new HashSet<>();	
	
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}

	@OneAnnotationWithFinalMethodOnly
	public int getNotStaticValue() {
		return notStaticValue;
	}
	
	@OneAnnotationWithFinalMethodOnly
	public void setNotStaticValue(int notStaticValue) {
		this.notStaticValue = notStaticValue;
	}

	@OneAnnotationWithMethodVisibilityRequired
	public String getOneProtectedString() {
		return oneProtectedString;
	}
	
	@OneAnnotationWithNoParametersMethodOnly
	@OneAnnotationWithStaticMethodOnly
	public void setOneProtectedString(String oneProtectedString) {
		this.oneProtectedString = oneProtectedString;
	}

	@OneAnnotationWithForbiddenMethodReturn
	public float getOneDefaultfloat() {
		return oneDefaultfloat;
	}

	@OneAnnotationWithStaticMethodOnly
	public strictfp void setOneDefaultfloat(float oneDefaultfloat) {
		this.oneDefaultfloat = oneDefaultfloat;
	}

	@OneAnnotationWithSynchronizedMethodOnly
	public static String getOneDefaultString() {
		return oneDefaultString;
	}

	@OneAnnotationWithForbiddenMethodReturn
	public void setOneDefaultString(String oneDefaultString) {
		this.oneDefaultString = oneDefaultString;
	}
	
	@OneAnnotationWithValidMethodReturn
	@OneAnnotationWithSynchronizedMethodOnly
	private long getOneVolatileLong() {
		return oneVolatileLong;
	}

	@OneAnnotationWithNoParametersMethodOnly
	@OneAnnotationWithMethodVisibilityForbidden
	private strictfp void setOneVolatileLong(long oneVolatileLong) {
		this.oneVolatileLong = oneVolatileLong;
	}

	@OneAnnotationWithValidNumberOfParameters
	@OneAnnotationWithInstanceMethodOnly
	public static String getOneStaticString() {
		return oneStaticString;
	}

	@OneAnnotationWithValidNumberOfParameters
	@OneAnnotationWithInstanceMethodOnly
	public static void setOneStaticString(String oneStaticString) {
		PersonWithError.oneStaticString = oneStaticString;
	}

	@OneAnnotationWithMethodVisibilityRequired
	public static String getOtherStaticString() {
		return otherStaticString;
	}

	@OneAnnotationWithValidMethodReturn
	@OneAnnotationWithStrictfpMethodOnly
	public static void setOtherStaticString(String otherStaticString) {
		PersonWithError.otherStaticString = otherStaticString;
	}

	@OneAnnotationWithMethodVisibilityForbidden
	private Set<Object> getOneSet() {
		return oneSet;
	}

	@OneAnnotationWithStrictfpMethodOnly
	public void setOneSet(Set<Object> oneSet) {
		this.oneSet = oneSet;
	}
	
}
