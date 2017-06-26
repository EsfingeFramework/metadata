package net.sf.esfinge.metadata;

import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.container.MetadataRepository;

public class AnnotationReader {
	
	public <E> E readingAnnotationsTo(AnnotatedElement elementWithMetadata, Class<?> outputClass) throws Exception {
		MetadataRepository metadataRepository = MetadataRepository.initializeRepository();
		Object container  = metadataRepository.getContainer(outputClass, elementWithMetadata);
		return (E) container;
	}

}
