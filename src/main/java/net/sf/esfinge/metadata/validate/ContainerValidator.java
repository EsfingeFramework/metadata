package net.sf.esfinge.metadata.validate;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.MethodProcessors;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.annotation.validator.NotNull;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerValidator {

	@Processors(SearchOnEnclosingElements.class)
	List<Object> notNullProcessors;
	
	@MethodProcessors(NotNull.class)
	Map<Method,Object> notNullMethodProcessor;

	public List<Object> getNotNullProcessors() {
		return notNullProcessors;
	}

	public void setNotNullProcessors(List<Object> notNullProcessors) {
		this.notNullProcessors = notNullProcessors;
	}

	public Map<Method, Object> getNotNullMethodProcessor() {
		return notNullMethodProcessor;
	}

	public void setNotNullMethodProcessor(Map<Method, Object> notNullMethodProcessor) {
		this.notNullMethodProcessor = notNullMethodProcessor;
	}
	
	
	
	
}
