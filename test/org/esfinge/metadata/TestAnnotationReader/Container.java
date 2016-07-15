package org.esfinge.metadata.TestAnnotationReader;

import java.util.List;
import java.util.Map;

import org.esfinge.metadata.annotation.container.AnnotationProperty;
import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.annotation.container.ContainsAnnotation;
import org.esfinge.metadata.annotation.container.ElementName;
import org.esfinge.metadata.annotation.container.ProcessFields;
import org.esfinge.metadata.annotation.container.ProcessMethods;
import org.esfinge.metadata.annotation.container.ReflectionReference;
import org.esfinge.metadata.container.ContainerTarget;
@ContainerFor(vaule = ContainerTarget.CLASS)
public class Container {
	
	@ContainsAnnotation(Entidade.class)
	private boolean entidade;
	
	@ElementName
	private String nomeClasse;
	
	@ReflectionReference
	private Class<?> classValue;
	
	@AnnotationProperty(annotation = Tabela.class, property = "nome")
	private String nomeTabela;
	
	@ProcessMethods
	private List<MethodContainer> listaMetods;
	
	@ProcessFields
	private List<FieldContainer> listaFields;
	
	
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
		return entidade;
	}

	public void setEntidade(boolean entidade) {
		this.entidade = entidade;
	}

	public String getNomeClasse() {
		return nomeClasse;
	}

	public void setNomeClasse(String nomeClasse) {
		this.nomeClasse = nomeClasse;
	}

	public List<MethodContainer> getListaMetods() {
		return listaMetods;
	}

	public void setListaMetods(List<MethodContainer> listaMetods) {
		this.listaMetods = listaMetods;
	}

	public List<FieldContainer> getListaFields() {
		return listaFields;
	}

	public void setListaFields(List<FieldContainer> listaFields) {
		this.listaFields = listaFields;
	}

	
	
}
