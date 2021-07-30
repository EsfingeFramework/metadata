package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@PrefixConvention("get")
public @interface MyColumnName {
	//the default value for this is the name of the method without the get
	//@ElementPropertyName
	String value();
}
