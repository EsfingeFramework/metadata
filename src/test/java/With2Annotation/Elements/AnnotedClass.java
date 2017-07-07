package With2Annotation.Elements;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;

public class AnnotedClass {
	
	@AnnotationWithAnnotations
	private int field1;
	
	public int getField1() {
		return field1;
	}

	public void setField1(int field1) {
		this.field1 = field1;
	}

	
	

}
