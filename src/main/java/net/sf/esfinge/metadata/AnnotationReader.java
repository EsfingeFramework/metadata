package net.sf.esfinge.metadata;

import java.lang.reflect.AnnotatedElement;
import net.sf.esfinge.metadata.container.MetadataExecute;
import net.sf.esfinge.metadata.container.MetadataRepository;

public class AnnotationReader {

	// To be modified as necessary. Currently only checks if BooleanAnnotation
	// is present on methods.
	// TODO:Checking on classes and parameters
	MetadataRepository metadataRepository;
	Object container;
	MetadataExecute metadataExecute;
	public <E> E readingAnnotationsTo(AnnotatedElement elementWithMetadata, Class<?> outputClass) throws Exception {

		Object container = outputClass.newInstance();
		metadataRepository = new MetadataRepository();
		metadataRepository.findMetadata(outputClass);
		
		metadataExecute = new MetadataExecute(outputClass);
		container = metadataExecute.execMetadata(metadataRepository.getRepositorio(),elementWithMetadata);

		return (E) container;
	}

}
