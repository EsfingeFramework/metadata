package net.sf.esfinge.metadata.locate.locators.FindAllMetadata;


import net.sf.esfinge.metadata.annotation.finder.SearchOnAbstractions;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SearchOnAbstractions
@Retention(RetentionPolicy.RUNTIME)
public @interface ToTestInheritance {
}
