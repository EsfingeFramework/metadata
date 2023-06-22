package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container;

import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations.DeepTest;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations.IgnoreTest;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.testClasses.ClassWithAnnotations;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.testClasses.ClassWithConvention;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.List;

@IgnoreTest
public class ComponentTest {

    @Test
    public void ProccessWithAnnotationsTest() throws Exception {
        AnnotationReader leitura23 = new AnnotationReader();

        ComparisonDescriptor descr23 = leitura23.readingAnnotationsTo(ClassWithAnnotations.class,ComparisonDescriptor.class);
        //System.out.println(descr.getPropertyDescriptor("num").getProcessor());
    }


    @Test
    public void ProccessWithConventionsTest() throws Exception {
        AnnotationReader leitura1 = new AnnotationReader();

        ComparisonDescriptor descr1 = leitura1.readingAnnotationsTo(ClassWithConvention.class,ComparisonDescriptor.class);

        MetadataLocator ml = LocatorsFactory.createLocatorsChain();
        //System.out.println(ml.findAllMetadata(ClassWithConvention.class.getMethod("getNum")));
        //ml.findMetadata(ClassWithConvention.class.getMethod("getNum"), DeepTest.class);

        List<Annotation> l = ml.findAllMetadata(ClassWithConvention.class.getMethod("getNum"));
        for(Annotation a : l){
            //System.out.println(a.annotationType().getSimpleName());
        }
    }

}
