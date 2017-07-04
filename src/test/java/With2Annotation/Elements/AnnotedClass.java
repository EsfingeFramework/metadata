package With2Annotation.Elements;

import net.sf.esfinge.metadata.annotation.finder.SearchInsideAnnotations;

public class AnnotedClass {
	
	@AnnotationWithAnnotations
	private int field1;
	
	private int field2;

	public int getField1() {
		return field1;
	}

	public void setField1(int field1) {
		this.field1 = field1;
	}

	public int getField2() {
		return field2;
	}

	public void setField2(int field2) {
		this.field2 = field2;
	}
	
	

}
