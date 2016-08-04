package org.esfinge.metadata.foo.annotation.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithFinalFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithInstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithStaticFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithTransientFieldOnly;
import org.esfinge.metadata.foo.annotation.OneAnnotationWithVolatileFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.visibility.FieldVisibilityForbidden;
import org.esfinge.metadata.foo.annotation.visibility.FieldVisibilityRequired;
import org.esfinge.metadata.foo.annotation.visibility.ValidFieldTypes;

public class Person {
	
	@OneAnnotationWithStaticFieldOnly
	private static long staticValue = 892832;	
	@OneAnnotationWithStaticFieldOnly
	private static int otherStaticValue = 0;	
	
	@OneAnnotationWithInstanceFieldOnly
	@OneAnnotationWithFinalFieldOnly
	private final String finalValue = "";	
	@OneAnnotationWithFinalFieldOnly
	private final double otherFinalValue = 4.2;	
	
	@OneAnnotationWithTransientFieldOnly
	private transient byte transientValue = 2;	
	@OneAnnotationWithTransientFieldOnly
	private transient boolean otherTransientValue = false;	
	
	@OneAnnotationWithVolatileFieldOnly
	private volatile String volatileValue = "";
	@OneAnnotationWithInstanceFieldOnly
	@OneAnnotationWithVolatileFieldOnly
	private volatile float otherVolatileValue = 3.5f;
	
	
	
	
	
	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "public")
	@ValidFieldTypes(listValidTypes = { String.class })
	private String name;
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "private")
	private String cpf;
	
	@ValidFieldTypes(listValidTypes = { int.class, Integer.class })
	private int age;	
		
	@ValidFieldTypes(listValidTypes = { List.class })	
	private List<Integer> someList = new LinkedList<Integer>();
	
	@ValidFieldTypes(listValidTypes = { List.class })	
	private ArrayList<Float> otherList = new ArrayList<Float>();
	
//	private synchronized String synchronizedValue = "";
			
	public Person(String name, String cpf, int age) {
		this.name = name;
		this.cpf = cpf;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public List<Integer> getSomeList() {
		return someList;
	}
	public void setSomeList(List<Integer> someList) {
		this.someList = someList;
	}	
	
}
