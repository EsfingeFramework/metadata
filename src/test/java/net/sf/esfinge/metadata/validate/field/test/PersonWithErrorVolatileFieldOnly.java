package net.sf.esfinge.metadata.validate.field.test;

public class PersonWithErrorVolatileFieldOnly extends Person{
	
	@OneAnnotationWithVolatileFieldOnly
	transient String oneDefaultString;

	@OneAnnotationWithVolatileFieldOnly
	private static String oneStaticString = "";	
	
	public PersonWithErrorVolatileFieldOnly(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
