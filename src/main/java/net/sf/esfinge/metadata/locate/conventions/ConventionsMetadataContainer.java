package net.sf.esfinge.metadata.locate.conventions;

import java.util.ArrayList;
import java.util.List;

public class ConventionsMetadataContainer {
	
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
}
