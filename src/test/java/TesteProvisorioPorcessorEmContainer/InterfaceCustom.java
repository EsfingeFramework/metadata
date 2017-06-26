package TesteProvisorioPorcessorEmContainer;

import java.lang.reflect.AnnotatedElement;

import net.sf.esfinge.metadata.annotation.container.ExecuteProcessor;

public interface InterfaceCustom {

	@ExecuteProcessor
	public void validContainer(AnnotedContainer annot);
	
	@ExecuteProcessor
	public void setClassName(AnnotedContainer conteiner, AnnotatedElement annotedClass);
}
