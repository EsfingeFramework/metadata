package net.sf.esfinge.metadata;

import java.lang.annotation.Annotation;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;

import net.sf.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.MetadataExecute;
import net.sf.esfinge.metadata.container.MetadataRepository;

public class AnnotationReader {

	// To be modified as necessary. Currently only checks if BooleanAnnotation
	// is present on methods.
	// TODO:Checking on classes and parameters

	public <E> E readingAnnotationsTo(AnnotatedElement elementWithMetadata, Class<?> outputClass) throws Exception {

		Object container = outputClass.newInstance();
		MetadataRepository metadataRepository = new MetadataRepository();
		metadataRepository.findMetadata(outputClass);
		
		MetadataExecute metadataExecute = new MetadataExecute(outputClass);
		container = metadataExecute.execMetadata(metadataRepository.getRepositorio(),elementWithMetadata);

		return (E) container;
	}

}
