package net.sf.esfinge.metadata.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.List;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IAnnotationPropertyWriter;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.generator.AtributeConventionValueGenerator;
import net.sf.esfinge.metadata.locate.conventions.annotations.attributes.ValueGenerator;

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
	public static void addAnnotationIfNotInList(Annotation annotation, List<Annotation> annotations){
		for(Annotation a : annotations){
			if(a.annotationType()==annotation.annotationType()){
				return;
			}
		}
		annotations.add(annotation);
	}
	//missing -> when the annotation has attributes that need to get values
	public static Annotation instantiateAnnotation(Class<? extends Annotation> annotClazz, AnnotatedElement element) {

		IClassWriter mock = ClassMock.of("MockName"+System.currentTimeMillis());
		IAnnotationPropertyWriter ianot = mock.annotation(annotClazz);
		for(Method m : annotClazz.getMethods()){
			for(Annotation annot : m.getAnnotations()){
				if(annot.annotationType().isAnnotationPresent(ValueGenerator.class)){
					ValueGenerator generatorAnnotation =  annot.annotationType().getAnnotation(ValueGenerator.class);
					Class<? extends AtributeConventionValueGenerator> generatorClass = generatorAnnotation.value();
					try {
						AtributeConventionValueGenerator generator = generatorClass.getConstructor().newInstance();
						ianot.property(m.getName(),generator.generateValue(annotClazz,element,m,annot));
					}catch (Exception e){
						e.printStackTrace();
					}

				}
			}
//			if(m.isAnnotationPresent(ElementNameAfterPrefix.class)){
//				ElementNameAfterPrefix ele = m.getAnnotation(ElementNameAfterPrefix.class);
//				String prefix = ele.prefix();
//				String nameAfterPrefix = getName(element).substring(prefix.length());
//				ianot.property(m.getName(),nameAfterPrefix);
//			}
		}

		Class<?> mockClass = mock.build();
		
		return mockClass.getAnnotation(annotClazz);
		
	}

}
