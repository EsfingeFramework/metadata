package net.sf.esfinge.metadata.locate.locators;


import net.sf.esfinge.metadata.annotation.finder.SearchOnEnclosingElements;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@SearchOnEnclosingElements
@Retention(RetentionPolicy.RUNTIME)
public @interface ToTestEnclosing {
}
