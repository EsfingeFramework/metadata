package net.sf.esfinge.container.processor.clazz.ct01;

import java.util.List;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ProcessorType;
import net.sf.esfinge.metadata.annotation.container.CustomReader;
import net.sf.esfinge.metadata.container.ContainerTarget;
@ContainerFor(value = ContainerTarget.TYPE)


public class Container{
	
	//1-Procura anotações com ProcessorAnnotation dentro ok
	//2-Pega a classe do value ok
	//2.1-verifica se essa classe é do tipo que está na lista ok
	//3-Instancia a classe que está no value ok 
	//4-chama o método init no objeto criado ok
	//5-adiciona na lista
	@CustomReader(configAnnotation = ProcessorAnnotation.class,type=ProcessorType.READER_ADDS_PROCESSOR)
	List<ProcessorInterface> list;

	public List<ProcessorInterface> getList() {
		return list;
	} 

	public void setList(List<ProcessorInterface> list) {
		this.list = list;
	}
	
}
