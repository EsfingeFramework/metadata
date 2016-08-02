package org.esfinge.metadata.foo.annotation.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithStaticFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.FinalFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.TransientFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.VolatileFieldOnly;
import org.esfinge.metadata.foo.annotation.visibility.FieldVisibilityForbidden;
import org.esfinge.metadata.foo.annotation.visibility.FieldVisibilityRequired;
import org.esfinge.metadata.foo.annotation.visibility.ValidFieldTypes;

public class Person {
	
	@OneAnnotationWithStaticFieldOnly
	private static String staticValue = "";
	
	
	
	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "public")
	@ValidFieldTypes(listValidTypes = { String.class })
	private String name;
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "private")
	private String cpf;
	
	@InstanceFieldOnly
	@ValidFieldTypes(listValidTypes = { int.class, Integer.class })
	private int age;	
	
	@FinalFieldOnly
	private final String finalValue = "";	
	@TransientFieldOnly
	private transient String transientValue = "";	
	@VolatileFieldOnly
	private volatile String volatileValue = "";
	
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
