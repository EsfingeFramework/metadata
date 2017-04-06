package TesteProvisorioPorcessorEmContainer;

import java.awt.Container;

public class ImplementedInterface implements InterfaceCustom {

	@Override
	public void validContainer(AnnotedContainer conteiner) {
		// TODO Auto-generated method stub


		conteiner.setEnabled(true);
		

	}

	@Override
	public void setClassName(AnnotedContainer conteiner, Class annotedClass) {
		// TODO Auto-generated method stub
		conteiner.setClassName(annotedClass.getName());

	}

}
