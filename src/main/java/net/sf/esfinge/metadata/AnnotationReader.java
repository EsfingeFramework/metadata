package net.sf.esfinge.metadata;

import java.lang.reflect.AnnotatedElement;
import net.sf.esfinge.metadata.container.MetadataExecute;
import net.sf.esfinge.metadata.container.MetadataRepository;

public class AnnotationReader {

	MetadataRepository metadataRepository;
	Object container;
	MetadataExecute metadataExecute;
	public <E> E readingAnnotationsTo(AnnotatedElement elementWithMetadata, Class<?> outputClass) throws Exception {

		Object container = outputClass.newInstance();
		metadataRepository = MetadataRepository.initializeRepository();
		container = metadataRepository.getContainer(outputClass, elementWithMetadata);
				
		//metadataExecute = new MetadataExecute(outputClass);
		//container = metadataExecute.execMetadata(metadataRepository.getRepositorio(),elementWithMetadata);
		return (E) container;
	}

}
