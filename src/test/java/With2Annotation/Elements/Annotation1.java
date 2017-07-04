package With2Annotation.Elements;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;

@Retention(RUNTIME)
@SearchInsideAnnotations
public @interface Annotation1 {
	String value();
}
