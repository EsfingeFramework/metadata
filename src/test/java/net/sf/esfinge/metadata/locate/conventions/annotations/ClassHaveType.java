package net.sf.esfinge.metadata.locate.conventions.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;

@Retention(RetentionPolicy.RUNTIME)
@ClassHaveTypeConvention(classType = ArrayList.class,canBeSubtype = true)
public @interface ClassHaveType {
}
