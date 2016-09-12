package net.sf.esfinge.container.processor.method;

import net.sf.esfinge.metadata.annotation.validator.SearchInsideAnnotations;
import net.sf.esfinge.metadata.annotation.validator.SearchOnEnclosingElements;


public class Dominio {
	
	private String field1;
	
	private int field2;
	
	@Entidade
	public void entidade1(){}
	
	@Entidade
	public void entidade2(){}

}
