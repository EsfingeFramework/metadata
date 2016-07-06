package org.esfinge.metadata.TestAnnotationReader;

import java.util.Map;

import org.esfinge.metadata.annotation.container.AnnotationProperty;
import org.esfinge.metadata.annotation.container.ContainsAnnotation;
import org.esfinge.metadata.annotation.container.ElementName;
import org.esfinge.metadata.annotation.container.ReflectionReference;

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
