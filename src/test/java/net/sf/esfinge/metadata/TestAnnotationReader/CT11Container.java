package net.sf.esfinge.metadata.TestAnnotationReader;

import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;

public class CT11Container {
		
	@AnnotationProperty(annotation = Fake.class, property ="nome")
	private String nomeTabela;
	
	
	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
}
