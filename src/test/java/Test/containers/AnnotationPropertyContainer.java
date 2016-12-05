package Test.containers;

import Test.annotations.Variavel;
import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
public class AnnotationPropertyContainer {

	@AnnotationProperty(annotation = Variavel.class, property ="nome")
	private String nomeTabela;

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}
	

}
