package net.sf.esfinge.metadata.validate;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.MethodProcessors;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.validator.NotNull;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.annotation.validator.ToValidateProperty;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerValidator {

	@Processors(ToValidateProperty.class)
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
