package net.sf.esfinge.metadata.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;

public class AnnotatedElementUtils {
	
	public static String getName(AnnotatedElement ae) {
		if(ae instanceof Class)
			return ((Class)ae).getName();
		if(ae instanceof Method)
			return ((Method)ae).getName();
		if(ae instanceof Constructor)
			return ((Constructor)ae).getName();
		if(ae instanceof Field)
			return ((Field)ae).getName();
		if(ae instanceof Package)
			return ((Package)ae).getName();
		if(ae instanceof Parameter)
			return ((Parameter)ae).getName();

		return ae.toString();
	}
	
	//missing -> when the annotation has attributes that need to get values
	public static Annotation instantiateAnnotation(Class<? extends Annotation> annotClazz) {
		IClassWriter mock = ClassMock.of("MockName"+System.currentTimeMillis());
		mock.annotation(annotClazz);
		Class<?> mockClass = mock.build();
		
		return mockClass.getAnnotation(annotClazz);
		
	}

}
