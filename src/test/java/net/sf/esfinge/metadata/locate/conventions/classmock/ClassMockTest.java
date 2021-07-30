package net.sf.esfinge.metadata.locate.conventions.classmock;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import org.omg.CORBA.PRIVATE_MEMBER;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;

public class ClassMockTest {

	public static void main(String[] args) {
		
		final Class<?> annotationClazz = ClassMock.of("MyEspecialAnnotationClass")
                .asAnnotation()
               
                .build();
		
//		final IClassWriter mock = ClassMock.of("MyEspecialAnnotationClass").asAnnotation();
//		mock.annotation(Retention.class)
//										.property(RetentionPolicy.RUNTIME)
//										;
//		final Class<?> annotation = mock.build();
											
		
		//System.out.println(annotation.getTypeName());

	}

}
