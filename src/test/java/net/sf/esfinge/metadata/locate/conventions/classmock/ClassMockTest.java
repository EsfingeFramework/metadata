package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.locate.conventions.annotations.FieldTypeConvention;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ClassMockTest {

	public static void main(String[] args) {

		final IClassWriter mock = ClassMock.of("MyEspecialAnnotationClass").asClass();
		mock.annotation(Retention.class).property(RetentionPolicy.RUNTIME);
		mock.field("nome",String.class).annotation(FieldTypeConvention.class)
				.property(RetentionPolicy.RUNTIME);
		mock.method("setNome").returnTypeAsVoid();
		final Class<?> annotation = mock.build();

		
		System.out.println(annotation.getTypeName());
		try {
			System.out.println(annotation.getDeclaredField("nome").getDeclaredAnnotations()[0].toString());
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}
	}

}
