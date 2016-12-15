package Test.containers;

import Test.annotations.Entidade;
import Test.annotations.Variavel;
import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
public class Container {
	@ContainsAnnotation(Entidade.class)
	private boolean entidadePresent;

	
	@AnnotationProperty(annotation = Variavel.class, property ="nome")
	private String nomeTabela;

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public boolean isEntidadePresent() {
		return entidadePresent;
	}

	public void setEntidadePresent(boolean entidadePresent) {
		this.entidadePresent = entidadePresent;
	}
	
	

}
