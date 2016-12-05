package Test.containers;

import java.util.List;
import java.util.Set;

import Test.annotations.MethodAnnoted;
import net.sf.esfinge.metadata.TestAnnotationReader.Procesos;
import net.sf.esfinge.metadata.annotation.container.AllMethodsWith;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
public class AllMethodsWithContainer {
	//@AllMethodsWith(MethodAnnoted.class)
	//private Set<MethodContainer> setMethodsWith;
	
	@AllMethodsWith(MethodAnnoted.class)
	private List<MethodContainer> listaMetodsWith;

	//public Set<MethodContainer> getSetMethodsWith() {
	//	return setMethodsWith;
	//}

	//public void setSetMethodsWith(Set<MethodContainer> setMethodsWith) {
	//	this.setMethodsWith = setMethodsWith;
	//}

	public List<MethodContainer> getListaMetodsWith() {
		return listaMetodsWith;
	}

	public void setListaMetodsWith(List<MethodContainer> listaMetodsWith) {
		this.listaMetodsWith = listaMetodsWith;
	}
	
	
	
}
