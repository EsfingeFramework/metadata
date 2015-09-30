package org.esfinge.metadata.container;

import java.lang.reflect.Method;

public class Properties {
	
	//To be modified as necessary. Only has getters and setters for method name, method object and a boolean variable.
	
	private Method _method;
	private String _name;
	private boolean _hasAnnotation;
	
	public Properties(Method m){
		_method = m;
		_name = m.getName();
	}
	
	public Method getMethod()
	{
		return _method;
	}
	
	public String getName()
	{
		return _name;
	}
	
	public boolean getHasAnnotation()
	{
		return _hasAnnotation;
	}
	
	public void setMethod(Method m){
		_method = m;
	}
	
	public void setName(String name){
		_name = name;
	}
	
	public void setHasAnnotation(boolean b){
		_hasAnnotation = b;
	}
}
