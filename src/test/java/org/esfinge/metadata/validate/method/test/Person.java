package org.esfinge.metadata.validate.method.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

public class Person {
	
	@OneAnnotationWithFinalMethodOnly
	private static long staticValue = 892832;	

	@OneAnnotationWithFinalMethodOnly
	private static int otherStaticValue = 0;	
	
	@OneAnnotationWithStaticMethodOnly
	private final String finalValue = "";

	@OneAnnotationWithStaticMethodOnly
	private final double otherFinalValue = 4.2;	
	
	private transient byte transientValue = 2;	

	private transient boolean otherTransientValue = false;	
	
	@OneAnnotationWithMethodVisibilityForbidden
	private volatile String volatileValue = "";

	private volatile float otherVolatileValue = 3.5f;
	
	private static String cpf;
	
	private String name;
	
	private static int age;	
		
	@OneAnnotationWithMethodVisibilityForbidden
	private List<Integer> someList = new LinkedList<Integer>();
	
	private ArrayList<Float> otherList = new ArrayList<Float>();
	
	
	public Person(String name, String cpf, int age) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
	}
	
	@OneAnnotationWithFinalMethodOnly
	public final String getName() {
		return name;
	}

	@OneAnnotationWithFinalMethodOnly
	public final void setName(String name) {
		this.name = name;
	}

	@OneAnnotationWithNoParametersMethodOnly
	@OneAnnotationWithStaticMethodOnly
	public static String getCpf() {
		return cpf;
	}

	@OneAnnotationWithMethodVisibilityForbidden
	@OneAnnotationWithSynchronizedMethodOnly
	public synchronized void setCpf(String cpf) {
		this.cpf = cpf;
	}

	@OneAnnotationWithValidMethodReturn
	@OneAnnotationWithForbiddenMethodReturn
	@OneAnnotationWithStaticMethodOnly
	public static int getAge() {
		return age;
	}

	@OneAnnotationWithMethodVisibilityRequired
	@OneAnnotationWithInstanceMethodOnly
	protected void setAge(int age) {
		this.age = age;
	}

	@OneAnnotationWithNoParametersMethodOnly
	@OneAnnotationWithSynchronizedMethodOnly
	public synchronized List<Integer> getSomeList() {
		return someList;
	}
	
	@OneAnnotationWithMethodVisibilityRequired
	@OneAnnotationWithInstanceMethodOnly
	protected void setSomeList(List<Integer> someList) {
		this.someList = someList;
	}
	
	@OneAnnotationWithValidNumberOfParameters
	@OneAnnotationWithMethodVisibilityForbidden
	@OneAnnotationWithStrictfpMethodOnly
	public strictfp double someCalc(double a, double b){
		return Math.pow(( a * b ) * 4.2, 5);		
	}
	
	@OneAnnotationWithValidNumberOfParameters
	@OneAnnotationWithForbiddenMethodReturn
	@OneAnnotationWithStrictfpMethodOnly
	public strictfp double otherCalc(double a, double b){
		return 4.2 * Math.sqrt(a / b);		
	}
	
	@OneAnnotationWithValidMethodReturn
	public Integer returnSomeInteger(){
		return 3;
	}
	
}
