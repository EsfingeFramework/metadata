package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations;

import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.DelegateReader;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.readers.DeepReader;
import net.sf.esfinge.metadata.locate.conventions.annotations.MethodReturnTypeConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@DelegateReader(DeepReader.class)
@MethodReturnTypeConvention(returnType = int.class)
public @interface DeepTest {
}
