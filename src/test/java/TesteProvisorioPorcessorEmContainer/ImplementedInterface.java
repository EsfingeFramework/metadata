package TesteProvisorioPorcessorEmContainer;

import java.lang.reflect.AnnotatedElement;

public class ImplementedInterface implements InterfaceCustom {

	@Override
	public void validContainer(AnnotedContainer conteiner) {
		// TODO Auto-generated method stub

		conteiner.setEnabled(true);
		

	}

	@Override
	public void setClassName(AnnotedContainer conteiner, AnnotatedElement annotedClass) {
		// TODO Auto-generated method stub
		Class setClass = null;
		
		if(annotedClass instanceof Class)
		{
			setClass = (Class) annotedClass;
		}
		
		conteiner.setClassName(setClass.getName());

	}

}
