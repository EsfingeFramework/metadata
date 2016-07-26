package org.esfinge.metadata.TestAnnotationReader;

import java.util.Map;

import org.esfinge.metadata.annotation.container.AnnotationProperty;
import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.annotation.container.ContainsAnnotation;
import org.esfinge.metadata.annotation.container.ElementName;
import org.esfinge.metadata.annotation.container.ReflectionReference;
import org.esfinge.metadata.container.ContainerTarget;

@ContainerFor(vaule = ContainerTarget.CLASS)
public class CT7Container {
		
	@ElementName
	private String nomeClasse;
	
	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}
	
	

}
