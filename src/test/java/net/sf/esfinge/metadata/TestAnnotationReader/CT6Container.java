package net.sf.esfinge.metadata.TestAnnotationReader;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
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
