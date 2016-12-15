package net.sf.esfinge.metadata.validate;

import net.sf.esfinge.metadata.AnnotationReader;

public class MetadataValidatorB {
	
	public static void validateMetadataOn(Class<?> clazz) throws Exception{
		{
			ContainerValidator containerValidator = new ContainerValidator();
			AnnotationReader reader = new AnnotationReader();
			
			containerValidator = reader.readingAnnotationsTo(clazz, containerValidator.getClass());
			
		}
	}

}
