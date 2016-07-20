package org.esfinge.metadata.TestAnnotationReader;

import org.esfinge.metadata.annotation.container.AnnotationProperty;
import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.container.ContainerTarget;

@ContainerFor(vaule = ContainerTarget.CLASS)
public class CT0Container {
	@AnnotationProperty(annotation = Tabela.class, property ="nome")
	private String nomeTabela;

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
		
}
