package net.sf.esfinge.metadata;

import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.container.MetadataRepository;
import net.sf.esfinge.metadata.validate.MetadataValidator;

public class AnnotationReader {
	
	public <E> E readingAnnotationsTo(AnnotatedElement elementWithMetadata, Class<?> outputClass) throws Exception {
		MetadataRepository.destroy();
		if(elementWithMetadata instanceof Class)
		{
			MetadataValidator.validateMetadataOn((Class)elementWithMetadata);
		}
		MetadataRepository metadataRepository = MetadataRepository.initializeRepository();
		Object container  = metadataRepository.getContainer(outputClass, elementWithMetadata);
		return (E) container;
	}

}
