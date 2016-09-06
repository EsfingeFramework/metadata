package net.sf.esfinge.containerProcessosrsTest;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.MethodProcessors;
import net.sf.esfinge.metadata.annotation.container.Processors;
import net.sf.esfinge.metadata.container.ContainerTarget;
@ContainerFor(value = ContainerTarget.CLASS)

public class Container{
	
	@Processors(Algo.class)
	List<Class<?>> list;
	
	@MethodProcessors(Algo.class)
	Map<Method,Class<?>> prossesMethods;

	public List<Class<?>> getList() {
		return list;
	}

	public void setList(List<Class<?>> list) {
		this.list = list;
	}

	public Map<Method, Class<?>> getProssesMethods() {
		return prossesMethods;
	}

	public void setProssesMethods(Map<Method, Class<?>> prossesMethods) {
		this.prossesMethods = prossesMethods;
	}
	
	
	
}
