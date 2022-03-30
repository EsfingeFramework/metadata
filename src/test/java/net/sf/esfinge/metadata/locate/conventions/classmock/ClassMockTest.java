package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ClassMockTest {

	public static void main(String[] args) {

//Creating the annotation

		final IClassWriter mockAnot = ClassMock.of("AnnotationPrefix").asAnnotation();
		mockAnot.annotation(Retention.class).property(RetentionPolicy.RUNTIME);
		mockAnot.annotation(PrefixConvention.class).property("Prefix");
		final Class<? extends Annotation> annotation = (Class<? extends Annotation>)mockAnot.build();



//Locator

		MetadataLocator ml = null;
		try {
			ml = LocatorsFactory.createLocatorsChain(annotation);
		} catch (AnnotationReadingException e) {
			e.printStackTrace();
		}


//Creating the class with annotation

		final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation");

		mockC1.annotation(annotation);

		final Class<?> c1 = mockC1.build();


		//System.out.println(ml.hasMetadata(c1, annotation));



//Creating the class without prefix and without annotation

		final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");

		final Class<?> c2 = mockC2.build();


		//System.out.println(ml.hasMetadata(c2, annotation));



//Creating the class with prefix and without annotation

		final IClassWriter mockC3 = ClassMock.of("PrefixClassWithoutAnnotation");

		final Class<?> c3 = mockC3.build();


		//System.out.println(ml.hasMetadata(c3, annotation));
	}

}
