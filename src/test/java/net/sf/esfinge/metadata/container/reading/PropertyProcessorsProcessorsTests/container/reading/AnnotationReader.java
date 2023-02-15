package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading;

import java.lang.annotation.Annotation;


import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.PropertyDescriptor;


public interface AnnotationReader<A extends Annotation> {

    @ExecuteProcessor
    public void readAnnotation(A annotation,
                               PropertyDescriptor descriptor);

}
