package org.esfinge.metadata.TestAnnotationReader;

import java.util.Map;

import org.esfinge.metadata.container.AnnotationProperty;
import org.esfinge.metadata.container.ContainerFor;
import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;
import org.esfinge.metadata.container.Propriedades;
import org.esfinge.metadata.container.ReflectionReference;

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
