package net.sf.esfinge.metadata.TestAnnotationReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import net.sf.esfinge.metadata.AnnotationReader;

public class TestAnnotationReader {

	// Todos os elementos ok
	@Test
	public void CT00() throws Exception {
		AnnotationReader lm = new AnnotationReader();
		CT0Container container = (CT0Container) lm.readingAnnotationsTo(Dominio.class, CT0Container.class);
		assertEquals("dominio", container.getNomeTabela());
	}

	
	@Test
	public void CT01() throws Exception {
		AnnotationReader lm = new AnnotationReader();
		CT1Container container = (CT1Container) lm.readingAnnotationsTo(Dominio.class, CT1Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());
	}

	// Falta 1 elemento
	// isEntidadeFalse
	@Test
	public void CT02() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT2Container container = (CT2Container) lm.readingAnnotationsTo(Dominio.class, CT2Container.class);
		assertTrue(!container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());
	}

	// Nome da classe is NULL
	@Test
	public void CT03() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT3Container container = (CT3Container) lm.readingAnnotationsTo(Dominio.class, CT3Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertNull(container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());

	}

	// class is null
	@Test
	public void CT04() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT4Container container = (CT4Container) lm.readingAnnotationsTo(Dominio.class, CT4Container.class);
		assertTrue(container.isEntidade());
		assertNull(container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());

	}

	// class is null
	@Test
	public void CT05() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT5Container container = (CT5Container) lm.readingAnnotationsTo(Dominio.class, CT5Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertNull(container.getNomeTabela());

	}

	@Test
	public void CT06() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT6Container container = (CT6Container) lm.readingAnnotationsTo(Dominio.class, CT6Container.class);
		assertTrue(container.isEntidade());

	}

	@Test
	public void CT07() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT7Container container = (CT7Container) lm.readingAnnotationsTo(Dominio.class, CT7Container.class);
		assertEquals(Dominio.class.getName(), container.getNomeClasse());

	}

	@Test
	public void CT08() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT8Container container = (CT8Container) lm.readingAnnotationsTo(Dominio.class, CT8Container.class);
		assertEquals(Dominio.class, container.getClassValue());

	}

	@Test
	public void CT09() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT9Container container = (CT9Container) lm.readingAnnotationsTo(Dominio.class, CT9Container.class);
		assertEquals("dominio", container.getNomeTabela());
	}

	@Test
	public void CT10() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT10Container container = (CT10Container) lm.readingAnnotationsTo(Dominio.class, CT10Container.class);
		assertNull("Table Name is Null", container.getNomeTabela());
	}

	@Test
	public void CT012() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT12Container container = (CT12Container) lm.readingAnnotationsTo(Dominio.class, CT12Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());

		int sun = 0;
		for (MethodContainer m1 : container.getLista()) {
			if (m1.isToProcess()) {
				sun++;
			}
		}
		assertEquals(1, sun);
	}

	@Test
	public void CT013() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		CT13Container container = (CT13Container) lm.readingAnnotationsTo(Dominio.class, CT13Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());

		int sun = 0;
		for (MethodContainer2 m1 : container.getLista()) {

			if (m1.isToProcess()) {
				sun++;
			}
		}
		assertEquals(0, sun);

	}

	@Test
	public void CT014() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		Container014 container = (Container014) lm.readingAnnotationsTo(Dominio.class, Container014.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals(Dominio.class.getName(), container.getNomeClasse());
		assertEquals("dominio", container.getNomeTabela());
		assertNotNull(container.getListaMetodsWith());
		assertNotNull(container.getSetMethodsWith());
		
		int sun = 0;
		for (MethodContainer m1 : container.getListaMethods()) {
			if (m1.isToProcess()) {
				sun++;
			}
		}
		assertEquals(1, sun);
		assertEquals(2, container.getListaMethods().size());
		assertEquals(1, container.getListaMetodsWith().size());
		assertEquals(1, container.getSetMethodsWith().size());

		int sun2 = 0;
		for (FieldContainer m1 : container.getListaFields()) {
			if (m1.isToProcess()) {
				sun2++;
			}
		}
		assertEquals(1, sun2);
	}
	
	@Test
	public void CT015() throws Exception {

		AnnotationReader lm = new AnnotationReader();
		Container container = (Container) lm.readingAnnotationsTo(Dominio.class, Container.class);
			
	}


}
