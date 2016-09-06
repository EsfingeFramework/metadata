package net.sf.esfinge.metadata.TestAnnotationReader;

import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(vaule = ContainerTarget.CLASS)
public class CT3Container {
	@ContainsAnnotation(Entidade.class)
	private boolean isEntidade;
	
	private String nomeClasse;
	
	@ReflectionReference
	private Class<?> classValue;
	
	@AnnotationProperty(annotation = Tabela.class, property ="nome")
	private String nomeTabela;
	
	
	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public Class<?> getClassValue() {
		return classValue;
	}

	public void setClassValue(Class<?> classValue) {
		this.classValue = classValue;
	}

	public boolean isEntidade() {
		return isEntidade;
	}
	
	public void setisEntidade(boolean isEntidade) {
		this.isEntidade = isEntidade;
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

}
