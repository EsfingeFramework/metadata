package org.esfinge.metadata.foo.annotation.test;

import org.esfinge.metadata.foo.annotation.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.StaticFieldOnly;

public class Person {
	
	private String name;
	private String cpf;
	
	@InstanceFieldOnly
	private int age;
	
	
	@StaticFieldOnly
	private static String staticValue = "";	
	
	
	@StaticFieldOnly
	private final String finalValue = "";
	
	@StaticFieldOnly
	private transient String transientValue = "";
	
	@StaticFieldOnly
	private volatile String volatileValue = "";
	
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
	
}
