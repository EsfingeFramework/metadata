package net.sf.esfinge.metadata.validate.field.test;

public class PersonWithErrorInstanceFieldOnly extends Person{

	@OneAnnotationWithInstanceFieldOnly
	private static String oneStaticString = "";
	
	@OneAnnotationWithInstanceFieldOnly
	public static String otherStaticString = "";
	
	public PersonWithErrorInstanceFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
