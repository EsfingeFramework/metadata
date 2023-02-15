package net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.annotation.container.ElementName;
import net.sf.esfinge.metadata.annotation.container.ElementPropertyWithoutAnnotation;
import net.sf.esfinge.metadata.container.ContainerTarget;
import net.sf.esfinge.metadata.container.reading.PropertyProcessorsProcessorsTests.container.reading.annotations.IgnoreTest;

@ContainerFor(ContainerTarget.TYPE)
public class ComparisonDescriptor {



    //private Map<String,PropertyDescriptor> properties;
    @ElementPropertyWithoutAnnotation(IgnoreTest.class)
    private Map<String,PropertyDescriptor> properties = new HashMap<String, PropertyDescriptor>();

    @ElementName
    private String idProp;

	/*public void addPropertyDescriptor(PropertyDescriptor descProp){
		properties.put(descProp.getName(), descProp);
	}
	public void removePropertyDescriptor(String prop){
		properties.remove(prop);
	}
	public PropertyDescriptor getPropertyDescriptor(String prop){
		return properties.get(prop);
	}
	public Set<String> getProperties(){
		return properties.keySet();
	}*/



    public void addPropertyDescriptor(PropertyDescriptor descProp){
        properties.put(descProp.getName(), descProp);
    }
    public void removePropertyDescriptor(String prop){
        properties.remove(prop);
    }
    public PropertyDescriptor getPropertyDescriptor(String prop){
        return properties.get(prop);
    }
    public Set<String> getSetProperties(){
        return properties.keySet();
    }
    public String getIdProp() {
        return idProp;
    }
    public void setIdProp(String idProp) {
        this.idProp = idProp;
    }
    ///OLDDDDDDDDDDDDDDDDDDDDDDDDDDDDD


    public void setProperties(Map<String, PropertyDescriptor> propertiesNew) {
        this.properties = propertiesNew;
    }



}
