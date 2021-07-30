package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;

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
