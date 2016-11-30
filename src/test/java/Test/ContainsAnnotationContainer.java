package Test;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
public class ContainsAnnotationContainer {
	@ContainsAnnotation(Entidade.class)
	private boolean entidadePresent;

	public boolean isEntidadePresent() {
		return entidadePresent;
	}

	public void setEntidadePresent(boolean entidadePresent) {
		this.entidadePresent = entidadePresent;
	}

	
}
