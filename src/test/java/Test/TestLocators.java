package Test;
import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.annotation.validator.MaxValue;
import net.sf.esfinge.metadata.annotation.validator.NotNull;
import net.sf.esfinge.metadata.locate.AnnotationLocator;
import net.sf.esfinge.metadata.locate.LevelLocator;
import net.sf.esfinge.metadata.locate.MetadataLocationException;
import net.sf.esfinge.metadata.locate.RegularLocator;

public class TestLocators {

	@Test
	public void testExterno() throws MetadataLocationException, NoSuchFieldException, SecurityException {
		Annotada anotada = new Annotada();
		
		List<Annotation> c = AnnotationFinder.findAnnotation(Annotada.class.getDeclaredField("field"),Interna.class);
		

		assertTrue(c.size()>0);
	}
	
	@Test
	public void testInterno() throws MetadataLocationException, NoSuchFieldException, SecurityException {
		Annotada anotada = new Annotada();
		
		List<Annotation> c = AnnotationFinder.findAnnotation(Annotada.class.getDeclaredField("field"),NotNull.class);
		

		assertTrue(c.size()>0);
	}

}
