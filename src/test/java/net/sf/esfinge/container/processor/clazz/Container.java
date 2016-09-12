package net.sf.esfinge.container.processor.clazz;

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
	
	//1-Procura anotações com ProcessorAnnotation dentro ok
	//2-Pega a classe do value ok
	//2.1-verifica se essa classe é do tipo que está na lista ok
	//3-Instancia a classe que está no value ok 
	//4-chama o método init no objeto criado
	//5-adiciona na lista
	@Processors(ProcessorAnnotation.class)
	List<ProcessorInterface> list;

	public List<ProcessorInterface> getList() {
		return list;
	}

	public void setList(List<ProcessorInterface> list) {
		this.list = list;
	}
	
}
