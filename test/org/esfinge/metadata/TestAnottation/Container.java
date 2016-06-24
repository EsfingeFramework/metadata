package org.esfinge.metadata.TestAnottation;

import java.util.List;
import java.util.Map;

import org.esfinge.metadata.container.AnnotationProperty;
import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;
import org.esfinge.metadata.container.ProcessFields;
import org.esfinge.metadata.container.ProcessMethods;
import org.esfinge.metadata.container.ReflectionReference;

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
