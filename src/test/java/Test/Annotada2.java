package Test;

import Test.annotations.AnnotationPropertyEncapsuled;
import Test.annotations.Entidade;
import Test.annotations.InTheField;
import Test.annotations.InTheMethod;
import net.sf.esfinge.metadata.TestAnnotationReader.Tabela;

@Entidade
@AnnotationPropertyEncapsuled
public class Annotada2 {
	@InTheField
	int fieldAnnoted;
	
	int fieldNotAnnoted;
	
	@InTheMethod
	public void methodAnnoted(){}
	
	public void methodNotAnnoted(){}
	
}
