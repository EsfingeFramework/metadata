package Test;

import Test.annotations.AnnotationPropertyEncapsuled;
import Test.annotations.Entidade;
import Test.annotations.InTheField;
import Test.annotations.InTheMethod;

@Entidade
@AnnotationPropertyEncapsuled
public class Annotada {
	@InTheField
	int fieldAnnoted;
	
	int fieldNotAnnoted;
	
	@InTheMethod
	public void methodAnnoted(){}
	
	public void methodNotAnnoted(){}
	
}
