package net.sf.esfinge.metadata.locate.conventions.classmock;
import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;

import java.lang.annotation.Annotation;

public class ClassMockPrefixTest {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, AnnotationReadingException {
        final Class<? extends Annotation> annotation = PrefixConvention.class;

        MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation);

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation");
        mockC1.annotation(annotation);
        final Class<?> c1 = mockC1.build();


        System.out.println(ml.hasMetadata(c1, annotation));


        //Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");

        final Class<?> c2 = mockC2.build();


        System.out.println(ml.hasMetadata(c2, annotation));


        //Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("PrefixClassWithoutAnnotation");

        final Class<?> c3 = mockC3.build();


        System.out.println(ml.hasMetadata(c3, annotation));
    }
}
