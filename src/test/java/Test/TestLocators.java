package Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.annotation.Annotation;
import java.util.List;

import org.junit.Test;

import Test.annotations.FieldAnnoted;
import Test.annotations.Interna;
import Test.annotations.MethodAnnoted;
import Test.annotations.Variavel;
import Test.containers.AllFieldsWithContainer;
import Test.containers.AllMethodsWithContainer;
import Test.containers.AnnotationPropertyContainer;
import Test.containers.Container;
import Test.containers.ContainsAnnotationContainer;
import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;

public class TestLocators {

	@Test
	public void testContainsAnnotation() throws Exception {
		Annotada anotada = new Annotada();
		
		List<Annotation> c = AnnotationFinder.findAnnotation(anotada.getClass(),Interna.class);
		
		ContainsAnnotationContainer container  = new ContainsAnnotationContainer();
		
		container = new AnnotationReader().readingAnnotationsTo(anotada.getClass(), container.getClass());

		assertTrue(c.size()>0);
		assertTrue(container.isEntidadePresent());
	}
	
	//@Test
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

//	@Test
	public void testContainer() throws Exception {
		Annotada2 anotada = new Annotada2();
		
		List<Annotation> c = AnnotationFinder.findAnnotation(anotada.getClass(),Interna.class);
		List<Annotation> d = AnnotationFinder.findAnnotation(anotada.getClass(),Variavel.class);
		
		Container container  = new Container();
		
		container = new AnnotationReader().readingAnnotationsTo(anotada.getClass(), container.getClass());

		
		assertTrue(c.size()==1);
		assertTrue(container.isEntidadePresent());
		assertEquals("dominio",container.getNomeTabela());
		

	}

}
