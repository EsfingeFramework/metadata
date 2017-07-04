package With2Annotation;

import With2Annotation.Elements.Annotation1;
import With2Annotation.Elements.Annotation2;
import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ReflectionReference;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.FIELDS)
public class ContainerField {
	
	@AnnotationProperty(annotation=Annotation1.class, property = "value")
	String a;
	
	@AnnotationProperty(annotation=Annotation2.class, property = "value")
	String b;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	
}
