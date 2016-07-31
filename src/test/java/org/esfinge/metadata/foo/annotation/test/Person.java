package org.esfinge.metadata.foo.annotation.test;

import org.esfinge.metadata.foo.annotation.fieldonly.FinalFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.StaticFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.TransientFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.VolatileFieldOnly;

public class Person {
	
	private String name;
	private String cpf;
	
	@InstanceFieldOnly
	private int age;
	
	@StaticFieldOnly
	private static String staticValue = "";	
	
	@FinalFieldOnly
	private final String finalValue = "";
	
	@TransientFieldOnly
	private transient String transientValue = "";
	
	@VolatileFieldOnly
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
