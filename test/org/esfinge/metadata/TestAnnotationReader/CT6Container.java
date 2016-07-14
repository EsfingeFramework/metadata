package org.esfinge.metadata.TestAnnotationReader;

import java.util.Map;

import org.esfinge.metadata.annotation.container.AnnotationProperty;
import org.esfinge.metadata.annotation.container.ContainerFor;
import org.esfinge.metadata.annotation.container.ContainsAnnotation;
import org.esfinge.metadata.annotation.container.ElementName;
import org.esfinge.metadata.annotation.container.ReflectionReference;
import org.esfinge.metadata.container.Propriedades;

@ContainerFor(vaule = Propriedades.CLASS)
public class CT6Container {
	
	@ContainsAnnotation(Entidade.class)
	private boolean isEntidade;
	
	public boolean isEntidade() {
		return isEntidade;
	}
	
	public void setisEntidade(boolean isEntidade) {
		this.isEntidade = isEntidade;
	}
		
	

}
