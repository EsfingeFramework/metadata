package net.sf.esfinge.metadata.locate.conventions.mapping;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;

@ContainerFor(ContainerTarget.TYPE)

public class ContainerClass {

	@ContainsAnnotation(Secure.class)
	private boolean secure;

	public boolean isSecure() {
		return secure;
	}

	public void setSecure(boolean secure) {
		this.secure = secure;
	}
	
}
