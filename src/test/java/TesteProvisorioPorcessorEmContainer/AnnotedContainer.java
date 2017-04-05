package TesteProvisorioPorcessorEmContainer;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.CustomReader;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
@CustomReader(configAnnotation=ProcessAnnotation.class,type=ProcessorType.READER_ADD_PROCESSOR,readerConfig="value")
public class AnnotedContainer {
	
	private boolean enabled;
	
	private String className;
	
	

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
}
