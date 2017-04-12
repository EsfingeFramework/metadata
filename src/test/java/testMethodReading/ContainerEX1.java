package testMethodReading;

import java.util.List;
import net.sf.esfinge.metadata.TestAnnotationReader.Procesos;
import net.sf.esfinge.metadata.annotation.container.AnnotedMethods;
import net.sf.esfinge.metadata.annotation.container.AnnotedMethodsWithoutAnnotation;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.ContainerTarget;


@ContainerFor(ContainerTarget.TYPE)
public class ContainerEX1{
	
	@AnnotedMethodsWithoutAnnotation(Procesos.class)
	private List<MethodContainer> methodContainerWinouthAnnotation;
	
	@AnnotedMethods
	private List<MethodContainer> methodContainerProcess;

	
	public List<MethodContainer> getMethodContainerProcess() {
		return methodContainerProcess;
	}

	public void setMethodContainerProcess(List< MethodContainer> methodContainerProcess) {
		this.methodContainerProcess = methodContainerProcess;
	}

	public List<MethodContainer> getMethodContainerWinouthAnnotation() {
		return methodContainerWinouthAnnotation;
	}

	public void setMethodContainerWinouthAnnotation(List<MethodContainer> methodContainerWinouthAnnotation) {
		this.methodContainerWinouthAnnotation = methodContainerWinouthAnnotation;
	}

	
}
