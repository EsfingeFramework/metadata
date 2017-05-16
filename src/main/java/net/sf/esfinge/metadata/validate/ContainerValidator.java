package net.sf.esfinge.metadata.validate;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.validator.MaxValue;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerValidator {

    @ContainsAnnotation(MaxValue.class)
    private boolean maxValue;

	public boolean isMaxValue() {
		return maxValue;
	}

	public void setMaxValue(boolean maxValue) {
		this.maxValue = maxValue;
	}
    
    
    
}
