package net.sf.esfinge.metadata.annotation.container;


import net.sf.esfinge.metadata.annotation.container.AnnotationReadingConfig;
import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.annotation.validator.ValidFieldType;
import net.sf.esfinge.metadata.container.reading.ProcessParametersReadingProcessor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.List;
import java.util.Map;
import java.util.Set;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@AnnotationReadingConfig(ProcessParametersReadingProcessor.class)
@ValidFieldType({List.class, Set.class, Map.class})
@SearchOnEnclosingElements
public @interface ProcessParameters {

}
