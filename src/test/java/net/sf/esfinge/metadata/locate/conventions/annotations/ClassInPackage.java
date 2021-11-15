package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@ClassIsInPackageConvention(value="net.sf.esfinge.metadata.locate.conventions.ClassWithoutAnnotation",ignoreCase = true)
public @interface ClassInPackage {
}
