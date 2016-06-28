package org.esfinge.metadata.TestAnottation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.esfinge.metadata.LeitorMetadados;
import org.esfinge.metadata.locate.MetadataLocator;
import org.junit.Test;

public class TestAnottation {

	//Todos os elementos ok
	@Test
	public void CT01() throws Exception {
		
		LeitorMetadados lm = new LeitorMetadados();		
		CT1Container container = (CT1Container)lm.metadataReader(Dominio.class , CT1Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals("org.esfinge.metadata.TestAnottation.Dominio", container.getNomeClasse());
		assertEquals("dominio",container.getNomeTabela());
	}
	
	//Falta 1 elemento
	//isEntidadeFalse
	@Test
	public void CT02() throws Exception {
		
		LeitorMetadados lm = new LeitorMetadados();		
		CT2Container container = (CT2Container)lm.metadataReader(Dominio.class , CT2Container.class);
		assertTrue(!container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertEquals("org.esfinge.metadata.TestAnottation.Dominio", container.getNomeClasse());
		assertEquals("dominio",container.getNomeTabela());
	}
	
	//Nome da classe is NULL
	@Test
	public void CT03() throws Exception {
		
		LeitorMetadados lm = new LeitorMetadados();		
		CT3Container container = (CT3Container)lm.metadataReader(Dominio.class , CT3Container.class);
		assertTrue(container.isEntidade());
		assertEquals(Dominio.class, container.getClassValue());
		assertNull(container.getNomeClasse());
		assertEquals("dominio",container.getNomeTabela());

	}
	
	//class is null
	@Test
	public void CT04() throws Exception {
		
		LeitorMetadados lm = new LeitorMetadados();		
		CT4Container container = (CT4Container)lm.metadataReader(Dominio.class , CT4Container.class);
		assertTrue(container.isEntidade());
		assertNull(container.getClassValue());
		assertEquals("org.esfinge.metadata.TestAnottation.Dominio", container.getNomeClasse());
		assertEquals("dominio",container.getNomeTabela());

	}
	//class is null
		@Test
		public void CT05() throws Exception {
			
			LeitorMetadados lm = new LeitorMetadados();		
			CT5Container container = (CT5Container)lm.metadataReader(Dominio.class , CT5Container.class);
			assertTrue(container.isEntidade());
			assertEquals(Dominio.class, container.getClassValue());
			assertEquals("org.esfinge.metadata.TestAnottation.Dominio", container.getNomeClasse());
			assertNull(container.getNomeTabela());

		}
		
		
				@Test
				public void CT06() throws Exception {
					
					LeitorMetadados lm = new LeitorMetadados();		
					CT6Container container = (CT6Container)lm.metadataReader(Dominio.class , CT6Container.class);
					assertTrue(container.isEntidade());

				}
				
				@Test
				public void CT07() throws Exception {
					
					LeitorMetadados lm = new LeitorMetadados();		
					CT7Container container = (CT7Container)lm.metadataReader(Dominio.class , CT7Container.class);
					assertEquals("org.esfinge.metadata.TestAnottation.Dominio", container.getNomeClasse());

				}
				@Test
				public void CT08() throws Exception {
					
					LeitorMetadados lm = new LeitorMetadados();		
					CT8Container container = (CT8Container)lm.metadataReader(Dominio.class , CT8Container.class);
					assertEquals(Dominio.class, container.getClassValue());

				}
				@Test
				public void CT09() throws Exception {
					
					LeitorMetadados lm = new LeitorMetadados();		
					CT9Container container = (CT9Container)lm.metadataReader(Dominio.class , CT9Container.class);
					assertEquals("dominio",container.getNomeTabela());
				}
				@Test
				public void CT10() throws Exception {
					
					LeitorMetadados lm = new LeitorMetadados();		
					CT10Container container = (CT10Container)lm.metadataReader(Dominio.class , CT10Container.class);
					assertNull(container.getNomeTabela());
				}
				@Test
				public void CT11() throws Exception {
					
					LeitorMetadados lm = new LeitorMetadados();		
					CT11Container container = (CT11Container)lm.metadataReader(Dominio.class , CT11Container.class);
					assertNull(container.getNomeTabela());
				}
				@Test
				public void CT012() throws Exception {

					
					LeitorMetadados lm = new LeitorMetadados();		
					CT12Container container = (CT12Container)lm.metadataReader(Dominio.class , CT12Container.class);
					assertTrue(container.isEntidade());
					assertEquals(Dominio.class, container.getClassValue());
					assertEquals("org.esfinge.metadata.TestAnottation.Dominio", container.getNomeClasse());
					assertEquals("dominio",container.getNomeTabela());
					
					int sun=0;
					for(MethodContainer m1 : container.getLista()){
						if(m1.isToProcess())
						{
							sun++;
						}
					}
					assertEquals(1, sun);
				}
				
				@Test
				public void CT013() throws Exception {
					
					LeitorMetadados lm = new LeitorMetadados();		
					CT13Container container = (CT13Container)lm.metadataReader(Dominio.class , CT13Container.class);
					assertTrue(container.isEntidade());
					assertEquals(Dominio.class, container.getClassValue());
					assertEquals("org.esfinge.metadata.TestAnottation.Dominio", container.getNomeClasse());
					assertEquals("dominio",container.getNomeTabela());
					
					int sun = 0;
					for(MethodContainer2 m1 : container.getLista()){

						if(m1.isToProcess())
						{
							sun++;
						}
					}
					assertEquals(0, sun);
				
				}
				@Test
				public void CT014() throws Exception {
					
					LeitorMetadados lm = new LeitorMetadados();		
					Container container = (Container)lm.metadataReader(Dominio.class , Container.class);
					assertTrue(container.isEntidade());
					assertEquals(Dominio.class, container.getClassValue());
					assertEquals("org.esfinge.metadata.TestAnottation.Dominio", container.getNomeClasse());
					assertEquals("dominio",container.getNomeTabela());
					
					int sun = 0;
					for(MethodContainer m1 : container.getListaMetods()){
						//System.out.println(m1.isToProcess());
						if(m1.isToProcess())
						{
							sun++;
						}
					}
					assertEquals(1, sun);
					
					int sun2 = 0;
					for(FieldContainer m1 : container.getListaFields()){
												if(m1.isToProcess())
						{
							sun2++;
						}
					}			
					assertEquals(1, sun2);
					
				}
	
}
