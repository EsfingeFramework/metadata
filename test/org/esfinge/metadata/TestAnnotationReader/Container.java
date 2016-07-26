package org.esfinge.metadata.TestAnnotationReader;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.esfinge.metadata.annotation.container.AllFieldsWith;
import org.esfinge.metadata.annotation.container.AllMethodsWith;
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
	
	@AllMethodsWith(Proces.class)
	private Set<MethodContainer> setMethodsWith;
	
	@AllMethodsWith(Proces.class)
	private List<MethodContainer> listaMetodsWith;
	
	//@AllFieldsWith(FieldLista.class)
	//private Set<FieldContainer> setFieldsWith;
	
	@AllFieldsWith(FieldLista.class)
	private List<FieldContainer> listaFieldsWith;

	
	
	//public Set<FieldContainer> getSetFieldsWith() {
	//	return setFieldsWith;
	//}

	//public void setSetFieldsWith(Set<FieldContainer> setFieldsWith) {
	//	this.setFieldsWith = setFieldsWith;
	//}

	public List<FieldContainer> getListaFieldsWith() {
		return listaFieldsWith;
	}

	public void setListaFieldsWith(List<FieldContainer> listaFieldsWith) {
		this.listaFieldsWith = listaFieldsWith;
	}

	public Set<MethodContainer> getSetMethodsWith() {
		return setMethodsWith;
	}

	public void setSetMethodsWith(Set<MethodContainer> setMethodsWith) {
		this.setMethodsWith = setMethodsWith;
	}

	public List<MethodContainer> getListaMetodsWith() {
		return listaMetodsWith;
	}

	public void setListaMetodsWith(List<MethodContainer> listaMetodsWith) {
		this.listaMetodsWith = listaMetodsWith;
	}

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
