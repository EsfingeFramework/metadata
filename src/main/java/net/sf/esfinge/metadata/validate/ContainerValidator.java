package net.sf.esfinge.metadata.validate;

import java.util.List;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.validator.Prohibits;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerValidator {

	@Processors(Prohibits.class)
	List<Object> validateProcessors;

	public List<Object> getValidateProcessors() {
		return validateProcessors;
	}

	public void setValidateProcessors(List<Object> validateProcessors) {
		this.validateProcessors = validateProcessors;
	}
	
	//@MethodProcessors(ToValidateProperty.class)
	//Map<Method,Object> notNullMethodProcessor;
 
	//public Map<Method, Object> getNotNullMethodProcessor() {
	//	return notNullMethodProcessor;
	//}

	//public void setNotNullMethodProcessor(Map<Method, Object> notNullMethodProcessor) {
	//	this.notNullMethodProcessor = notNullMethodProcessor;
	//}
	
	
	
	
}
