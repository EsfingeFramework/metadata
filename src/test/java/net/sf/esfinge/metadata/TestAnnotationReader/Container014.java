package net.sf.esfinge.metadata.TestAnnotationReader;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.annotation.container.AllFieldsWith;
import net.sf.esfinge.metadata.annotation.container.AllMethodsWith;
import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ProcessFields;
import net.sf.esfinge.metadata.annotation.container.ProcessMethods;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
public class Container014 {
	
	@ContainsAnnotation(Entidade.class)
	private boolean entidade;
	
	@ElementName
	private String nomeClasse;
	
	@ReflectionReference
	private Class<?> classValue;
	
	@AnnotationProperty(annotation = Tabela.class, property = "nome")
	private String nomeTabela;
	
	@ProcessMethods
	private List<MethodContainer> listaMethods;
		
	@ProcessMethods
	private Set<MethodContainer> setMethods;
	
	@ProcessFields
	private List<FieldContainer> listaFields;
	
	@AllMethodsWith(Procesos.class)
	private Set<MethodContainer> setMethodsWith;
	
	@AllMethodsWith(Procesos.class)
	private List<MethodContainer> listaMetodsWith;
	
	@AllFieldsWith(FieldLista.class)
	private Set<FieldContainer> setFieldWith;
	
	@AllFieldsWith(FieldLista.class)
	private List<FieldContainer> listaFieldWith;
	
	
	
	public Set<FieldContainer> getSetFieldWith() {
		return setFieldWith;
	}

	public void setSetFieldWith(Set<FieldContainer> setFieldWith) {
		this.setFieldWith = setFieldWith;
	}

	public List<FieldContainer> getListaFieldWith() {
		return listaFieldWith;
	}

	public void setListaFieldWith(List<FieldContainer> listaFieldWith) {
		this.listaFieldWith = listaFieldWith;
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

	public List<FieldContainer> getListaFields() {
		return listaFields;
	}

	public void setListaFields(List<FieldContainer> listaFields) {
		this.listaFields = listaFields;
	}

	public List<MethodContainer> getListaMethods() {
		return listaMethods;
	}

	public void setListaMethods(List<MethodContainer> listaMethods) {
		this.listaMethods = listaMethods;
	}

	public Set<MethodContainer> getSetMethods() {
		return setMethods;
	}

	public void setSetMethods(Set<MethodContainer> setMethods) {
		this.setMethods = setMethods;
	}
}
