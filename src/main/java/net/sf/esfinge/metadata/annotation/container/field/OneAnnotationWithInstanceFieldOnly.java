package net.sf.esfinge.metadata.annotation.container.field;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import net.sf.esfinge.metadata.annotation.validator.field.InstanceFieldOnly;

@InstanceFieldOnly
@Retention(RetentionPolicy.RUNTIME)
public @interface OneAnnotationWithInstanceFieldOnly {
}
