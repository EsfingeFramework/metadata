package net.sf.esfinge.metadata.annotation.container;

public enum AnnotationPropertyLocation {
	ALL(true,true,true), 
	ATTRIBUTE_ONLY(true,false,false), 
	ATTRIBUTE_GETTER(true,true,false), 
	ATTRIBUTE_SETTER(true,false,true), 
	GETTER_ONLY(false,true,false), 
	SETTER_ONLY(false,false,true), 
	GETTER_SETTER(false,false,true);
	
	//searchField, searchGetter e searchSetter
	private boolean searchField, searchGetter,  searchSetter;
	private AnnotationPropertyLocation(boolean searchField, boolean searchGetter, boolean searchSetter) {
		this.searchField = searchField;
		this.searchGetter = searchGetter;
		this.searchSetter = searchSetter;
	}
	public boolean isSearchField() {
		return searchField;
	}
	public void setSearchField(boolean searchField) {
		this.searchField = searchField;
	}
	public boolean isSearchGetter() {
		return searchGetter;
	}
	public void setSearchGetter(boolean searchGetter) {
		this.searchGetter = searchGetter;
	}
	public boolean isSearchSetter() {
		return searchSetter;
	}
	public void setSearchSetter(boolean searchSetter) {
		this.searchSetter = searchSetter;
	}
	
	
	
	
}
