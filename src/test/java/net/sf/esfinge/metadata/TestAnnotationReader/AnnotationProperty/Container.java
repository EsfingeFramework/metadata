package net.sf.esfinge.metadata.TestAnnotationReader.AnnotationProperty;

import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.CLASS)
public class Container {
	@AnnotationProperty(annotation = Propriedade.class, property ="nome")
	private Class<?> nomeTabela;

	public Class<?> getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(Class<?> nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
		
}
