package net.sf.esfinge.container.processor.clazz.ct02;

import java.util.List;

import net.sf.esfinge.metadata.AnnotationPropertyValidator;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.validator.ToValidateProperty;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
public class ContainerNotNull {

	
	@Processors(ToValidateProperty.class)
	List<AnnotationPropertyValidator> lista;

	public List<AnnotationPropertyValidator> getLista() {
		return lista;
	}

	public void setLista(List<AnnotationPropertyValidator> lista) {
		this.lista = lista;
	}
	
	
}
