package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;

import java.lang.annotation.Annotation;

public class ClassMockSuffixTest {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {


        final Class<? extends Annotation> annotation =  SuffixConvention.class;

        MetadataLocator ml = null;
        try {
            ml = LocatorsFactory.createLocatorsChain(annotation);
        } catch (AnnotationReadingException e) {
            e.printStackTrace();
        }


//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassEndsWithId");
        mockC1.method("methodEndsWithId").annotation(annotation);
        mockC1.field("FieldEndsWithId").annotation(annotation);
        final Class<?> c1 = mockC1.build();
        System.out.println("result for annotated class "+ml.hasMetadata(c1, annotation));
        System.out.println("result for annotated method "+ml.hasMetadata(c1.getMethod("getId"), annotation));
        System.out.println("result for annotated field "+ml.hasMetadata(c1.getField("id"), annotation));




//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        mockC2.method("methodDontEndsWith");
        mockC2.field("FieldDontEndsWith");
        final Class<?> c2 = mockC2.build();
        System.out.println("result for annotated class "+ml.hasMetadata(c2, annotation));
        System.out.println("result for annotated method "+ml.hasMetadata(c2.getMethod("methodEndsWith"), annotation));
        System.out.println("result for annotated field "+ml.hasMetadata(c2.getField("FieldDontEndsWith"), annotation));




//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("WithoutAnnotationClassEndsWithId");
        mockC3.method("methodEndsWithId");
        mockC3.field("FieldEmdsWithId");
        final Class<?> c3 = mockC3.build();
        System.out.println("result for annotated class "+ml.hasMetadata(c3, annotation));
        System.out.println("result for annotated method "+ml.hasMetadata(c3.getMethod("methodEndsWithId"), annotation));
        System.out.println("result for annotated field "+ml.hasMetadata(c3.getField("FieldEmdsWithId"), annotation));

    }
}
