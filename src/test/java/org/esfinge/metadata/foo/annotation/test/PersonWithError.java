package org.esfinge.metadata.foo.annotation.test;

import java.util.List;

import org.esfinge.metadata.foo.annotation.OneAnnotationWithStaticFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.FinalFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.InstanceFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.TransientFieldOnly;
import org.esfinge.metadata.foo.annotation.fieldonly.VolatileFieldOnly;
import org.esfinge.metadata.foo.annotation.visibility.FieldVisibilityForbidden;
import org.esfinge.metadata.foo.annotation.visibility.FieldVisibilityRequired;
import org.esfinge.metadata.foo.annotation.visibility.ValidFieldTypes;

public class PersonWithError extends Person{
	

//	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "public")
//	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "private")
//	@VolatileFieldOnly
	
	@OneAnnotationWithStaticFieldOnly
	private String notStaticValue = "";
	

	
	
	
	
	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "protected")
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "default")
	@TransientFieldOnly
	protected String oneProtectedString;
	
	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "default")
	@ValidFieldTypes(listValidTypes = { List.class })
	@TransientFieldOnly
	@FinalFieldOnly
	String oneDefaultString;
	
	@FieldVisibilityForbidden(itCannotHaveThisVisibility = "")
	@VolatileFieldOnly
	String otherDefaultString;
	
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "protected")
	@FinalFieldOnly
	@InstanceFieldOnly
	private static String oneStaticString = "";
	
	@FieldVisibilityRequired(itNeedsToHaveThisVisibility = "")
	@ValidFieldTypes(listValidTypes = { int.class })
	@VolatileFieldOnly
	@InstanceFieldOnly
	private static String otherStaticString = "";
	
	
	
	public PersonWithError(String name, String cpf, int age) {
		super(name, cpf, age);
	}
	
}
