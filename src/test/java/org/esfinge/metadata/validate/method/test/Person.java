package org.esfinge.metadata.validate.method.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Person {
	

	private static long staticValue = 892832;	

	private static int otherStaticValue = 0;	
	
	private final String finalValue = "";

	private final double otherFinalValue = 4.2;	
	
	private transient byte transientValue = 2;	

	private transient boolean otherTransientValue = false;	
	
	private volatile String volatileValue = "";

	private volatile float otherVolatileValue = 3.5f;
	
	private String cpf;
	
	private String name;
	
	private int age;	
		
	private List<Integer> someList = new LinkedList<Integer>();
	
	private ArrayList<Float> otherList = new ArrayList<Float>();
	
	
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
