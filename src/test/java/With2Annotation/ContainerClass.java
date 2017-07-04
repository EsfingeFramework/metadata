package With2Annotation;

import java.util.List;

import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ProcessFields;
import net.sf.esfinge.metadata.container.ContainerTarget;

@ContainerFor(ContainerTarget.TYPE)
public class ContainerClass {
	
	@ProcessFields
	List<ContainerField> fieldList;

	public List<ContainerField> getFieldList() {
		return fieldList;
	}

	public void setFieldList(List<ContainerField> fieldList) {
		this.fieldList = fieldList;
	}
	
	
	
}
