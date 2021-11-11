package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.RegularExpressionConvention;

import java.lang.annotation.Annotation;
import java.util.List;

public class ClassMockRegularExpressionTest {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {


        final Class<? extends Annotation> annotation =  RegularExpressionConvention.class;

        MetadataLocator ml = null;
        try {
            ml = LocatorsFactory.createLocatorsChain(annotation);
        } catch (AnnotationReadingException e) {
            e.printStackTrace();
        }


//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("IdClassWithAnnotation");
        mockC1.method("getId").annotation(annotation);
        mockC1.field("id").annotation(annotation);
        final Class<?> c1 = mockC1.build();
        System.out.println("result for annotated class "+ml.hasMetadata(c1, annotation));
        System.out.println("result for annotated method "+ml.hasMetadata(c1.getMethod("getId"), annotation));
        System.out.println("result for annotated field "+ml.hasMetadata(c1.getField("id"), annotation));




//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        mockC2.method("getId");
        mockC2.field("id");
        final Class<?> c2 = mockC2.build();
        System.out.println("result for annotated class "+ml.hasMetadata(c2, annotation));
        System.out.println("result for annotated method "+ml.hasMetadata(c2.getMethod("getId"), annotation));
        System.out.println("result for annotated field "+ml.hasMetadata(c2.getField("id"), annotation));




//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("IdClassWithoutAnnotation");
        mockC3.method("getId");
        mockC3.field("id");
        final Class<?> c3 = mockC3.build();
        System.out.println("result for annotated class "+ml.hasMetadata(c3, annotation));
        System.out.println("result for annotated method "+ml.hasMetadata(c3.getMethod("getId"), annotation));
        System.out.println("result for annotated field "+ml.hasMetadata(c3.getField("id"), annotation));
    }
}
