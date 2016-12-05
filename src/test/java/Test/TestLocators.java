package Test;
import static org.junit.Assert.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;

import org.junit.Test;

import Test.annotations.FieldAnnoted;
import Test.annotations.Interna;
import Test.annotations.MethodAnnoted;
import Test.annotations.Variavel;
import Test.containers.AllFieldsWithContainer;
import Test.containers.AllMethodsWithContainer;
import Test.containers.AnnotationPropertyContainer;
import Test.containers.ContainsAnnotationContainer;
import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
<<<<<<< HEAD
import net.sf.esfinge.metadata.TestAnnotationReader.Tabela;
=======
>>>>>>> 3851060b60541594d0fd56c768712197f8adce1e
import net.sf.esfinge.metadata.annotation.validator.MaxValue;
import net.sf.esfinge.metadata.annotation.validator.NotNull;
import net.sf.esfinge.metadata.locate.AnnotationLocator;
import net.sf.esfinge.metadata.locate.LevelLocator;
import net.sf.esfinge.metadata.locate.MetadataLocationException;
import net.sf.esfinge.metadata.locate.RegularLocator;

public class TestLocators {

	@Test
<<<<<<< HEAD
	public void testContainsAnnotation() throws Exception {
=======
	public void testExterno() throws Exception {
>>>>>>> 3851060b60541594d0fd56c768712197f8adce1e
		Annotada anotada = new Annotada();
		
		List<Annotation> c = AnnotationFinder.findAnnotation(anotada.getClass(),Interna.class);
		
		ContainsAnnotationContainer container  = new ContainsAnnotationContainer();
<<<<<<< HEAD
		
		container = new AnnotationReader().readingAnnotationsTo(anotada.getClass(), container.getClass());

		assertTrue(c.size()>0);
		assertTrue(container.isEntidadePresent());
	}
	
	@Test
	public void testExterno() throws Exception {
		Annotada anotada = new Annotada();
		
		List<Annotation> c = AnnotationFinder.findAnnotation(anotada.getClass(),Variavel.class);
		
		AnnotationPropertyContainer container  = new AnnotationPropertyContainer();
		
		container = new AnnotationReader().readingAnnotationsTo(anotada.getClass(), container.getClass());
		
		assertTrue(!c.isEmpty());
		assertEquals("dominio",container.getNomeTabela());
	}

	@Test
	public void testAllMethodsWith() throws Exception {
		Annotada anotada = new Annotada();
		
		List<Annotation> annoted= AnnotationFinder.findAnnotation(anotada.getClass().getMethod("methodAnnoted"),MethodAnnoted.class);
		List<Annotation> notAnnoted = AnnotationFinder.findAnnotation(anotada.getClass().getMethod("methodNotAnnoted"),MethodAnnoted.class);

		AllMethodsWithContainer container  = new AllMethodsWithContainer();
		
		container = new AnnotationReader().readingAnnotationsTo(anotada.getClass(), container.getClass());

		assertTrue(annoted.size()==1);
		assertTrue(notAnnoted.size()==0);
		assertFalse(container.getListaMetodsWith().isEmpty());
		assertTrue(container.getListaMetodsWith().size()==1);
	}
	
	@Test
	public void testAllFieldsWith() throws Exception {
		Annotada anotada = new Annotada();
		
		List<Annotation> annoted= AnnotationFinder.findAnnotation(anotada.getClass().getDeclaredField("fieldAnnoted"),FieldAnnoted.class);
		List<Annotation> notAnnoted = AnnotationFinder.findAnnotation(anotada.getClass().getDeclaredField("fieldNotAnnoted"),FieldAnnoted.class);

		AllFieldsWithContainer container  = new AllFieldsWithContainer();
		
		container = new AnnotationReader().readingAnnotationsTo(anotada.getClass(), container.getClass());

		assertTrue(annoted.size()==1);
		assertTrue(notAnnoted.size()==0);
		assertFalse(container.getListaFieldsWith().isEmpty());
		assertTrue(container.getListaFieldsWith().size()==1);
	}


=======
		
		container = new AnnotationReader().readingAnnotationsTo(anotada.getClass(), container.getClass());

		assertTrue(c.size()>0);
		assertTrue(container.isEntidadePresent());
	}
	
>>>>>>> 3851060b60541594d0fd56c768712197f8adce1e

}
