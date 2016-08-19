package net.sf.esfinge.metadata.TestAnnotationReader;

import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;

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
