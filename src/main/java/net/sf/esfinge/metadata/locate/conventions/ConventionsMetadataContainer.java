package net.sf.esfinge.metadata.locate.conventions;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.PropertyContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.PropertyProcessors;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.locate.conventions.annotations.Verifier;

import java.util.ArrayList;
import java.util.List;

@ContainerFor(ContainerTarget.ALL)
public class ConventionsMetadataContainer {


	@PropertyContainsAnnotation(Verifier.class)
	private List<ConventionVerifier> verifiers = new ArrayList<ConventionVerifier>();
	private boolean allConventionsNeedToApply = false;
	
	public List<ConventionVerifier> getVerifiers() {
		return verifiers;
	}
	public boolean isAllConventionsNeedToApply() {
		return allConventionsNeedToApply;
	}
	public void setAllConventionsNeedToApply(boolean allConventionsNeedToApply) {
		this.allConventionsNeedToApply = allConventionsNeedToApply;
	}
	public void addVerifier(ConventionVerifier verifier) {
		verifiers.add(verifier);
	}
}
