package net.sf.esfinge.metadata.validate;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.MethodProcessors;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.validator.MaxValue;
import net.sf.esfinge.metadata.annotation.validator.Prohibits;
import net.sf.esfinge.metadata.annotation.validator.ToValidateProperty;
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
