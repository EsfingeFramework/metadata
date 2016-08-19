package net.sf.esfinge.metadata.container;

import java.lang.reflect.Method;

public class Properties {
	
	//To be modified as necessary. Only has getters and setters for method name, method object and attributes.
	
	private Class<?> _class;
	private Method _method;
	private String _name;
	private boolean _hasAnnotation;
	private int _value;
	private String _stringValue;
	
	public Properties(Method m){
		_class = m.getClass();
		_method = m;
		_name = m.getName();
	}
	
	public Properties(Class<?> clazz)
	{
		_class = clazz;
		_method = null;
		_name = clazz.getName();
	}
	
	public Method getMethod()
	{
		return _method;
	}
	
	public Class<?> get_Class() {
		return _class;
	}

	public void set_Class(Class<?> _class) {
		this._class = _class;
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

	public int getValue() {
		return _value;
	}

	public void setValue(int value) {
		_value = value;
	}

	public String getStringValue() {
		return _stringValue;
	}

	public void setStringValue(String stringValue) {
		_stringValue = stringValue;
	}
}
