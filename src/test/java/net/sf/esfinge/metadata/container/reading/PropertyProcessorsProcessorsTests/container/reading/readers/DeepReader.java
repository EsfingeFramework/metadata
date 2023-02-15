package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.readers;

import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.PropertyDescriptor;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.AnnotationReader;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.Processors.DeepProcessor;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations.DeepTest;

public class DeepReader implements AnnotationReader<DeepTest> {
    @Override
    public void readAnnotation(DeepTest annotation, PropertyDescriptor descriptor) {
       DeepProcessor p = new DeepProcessor();

        descriptor.setProcessor(p);
    }
}
