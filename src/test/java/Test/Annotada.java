package Test;

<<<<<<< HEAD
import Test.annotations.AnnotationPropertyEncapsuled;
import Test.annotations.Entidade;
import Test.annotations.InTheField;
import Test.annotations.InTheMethod;
import net.sf.esfinge.metadata.TestAnnotationReader.Tabela;

@Entidade
@AnnotationPropertyEncapsuled
public class Annotada {
	@InTheField
	int fieldAnnoted;
	
	int fieldNotAnnoted;
=======
import net.sf.esfinge.metadata.TestAnnotationReader.Tabela;

@Entidade
@Tabela(nome="dominio")
public class Annotada {
	int field;
>>>>>>> 3851060b60541594d0fd56c768712197f8adce1e
	
	@InTheMethod
	public void methodAnnoted(){}
	
	public void methodNotAnnoted(){}
	
}
