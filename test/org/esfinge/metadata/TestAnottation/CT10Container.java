package org.esfinge.metadata.TestAnottation;

import java.util.Map;

import org.esfinge.metadata.container.AnnotationProperty;
import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;
import org.esfinge.metadata.container.ReflectionReference;

public class CT10Container {
		
	@AnnotationProperty(annotation = Tabela.class, property ="Agua")
	private String nomeTabela;
	
	
	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
}
