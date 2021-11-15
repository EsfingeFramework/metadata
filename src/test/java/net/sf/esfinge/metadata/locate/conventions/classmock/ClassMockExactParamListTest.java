package net.sf.esfinge.metadata.locate.conventions.classmock;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.classmock.api.IMethodWriter;
import net.sf.esfinge.classmock.imp.MethodImp;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.MethodExactParamListConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.MethodHasParamList;


import java.lang.annotation.Annotation;

public class ClassMockExactParamListTest {
    public static void main(String[] args) throws NoSuchMethodException {

        final Class<? extends Annotation> annotation =  MethodHasParamList.class;



//Locator

        MetadataLocator ml = null;
        try {
            ml = LocatorsFactory.createLocatorsChain(annotation);
        } catch (AnnotationReadingException e) {
            e.printStackTrace();
        }


//Creating the class with annotation

        final IClassWriter mockC1 = ClassMock.of("ClassWithAnnotation");
        mockC1.method("setId").annotation(annotation);
        final Class<?> c1 = mockC1.build();
        System.out.println("result for c1 "+ml.hasMetadata(c1.getMethod("setId"), annotation));




//Creating the class without prefix and without annotation

        final IClassWriter mockC2 = ClassMock.of("ClassWithoutAnnotation");
        final Class<?> c2 = mockC2.build();
        System.out.println("result for c2 "+ml.hasMetadata(c2, annotation));



//Creating the class with prefix and without annotation

        final IClassWriter mockC3 = ClassMock.of("MethodHasParameterOfTypeWithoutAnnotation");
        mockC3.method("setId").parameter("id",Integer.class);

        final Class<?> c3 = mockC3.build();
        System.out.println("result for c3 "+ml.hasMetadata(c3.getMethod("setId",Integer.class), annotation));
    }
}
