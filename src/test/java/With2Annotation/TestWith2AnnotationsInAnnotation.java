package With2Annotation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import With2Annotation.Elements.Annotation1;
import With2Annotation.Elements.Annotation2;
import With2Annotation.Elements.AnnotedClass;
import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;

public class TestWith2AnnotationsInAnnotation {

	@Test
	public void test() throws Exception {
		AnnotationReader ar= new AnnotationReader();
		
		boolean x = AnnotationFinder.existAnnotation(AnnotedClass.class.getDeclaredField("field1"), Annotation1.class);
		boolean y = AnnotationFinder.existAnnotation(AnnotedClass.class.getDeclaredField("field1"), Annotation2.class);
		
		assertTrue(x);
		assertTrue(y);
		
		
	}
	

}
