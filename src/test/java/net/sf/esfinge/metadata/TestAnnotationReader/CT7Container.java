package net.sf.esfinge.metadata.TestAnnotationReader;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
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
