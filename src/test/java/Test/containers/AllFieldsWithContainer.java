package Test.containers;

import java.util.List;

import Test.annotations.FieldAnnoted;
import net.sf.esfinge.metadata.annotation.container.AllFieldsWith;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(value = ContainerTarget.TYPE)
public class AllFieldsWithContainer {
	
	@AllFieldsWith(FieldAnnoted.class)
	private List<FieldContainer> listaFieldsWith;


	public List<FieldContainer> getListaFieldsWith() {
		return listaFieldsWith;
	}

	public void setListaFieldsWith(List<FieldContainer> listaFieldsWith) {
		this.listaFieldsWith = listaFieldsWith;
	}
	
	
	
}
