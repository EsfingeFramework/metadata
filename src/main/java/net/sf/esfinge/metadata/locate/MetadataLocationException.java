package net.sf.esfinge.metadata.locate;

public class MetadataLocationException extends RuntimeException {
	
	//adicionar na excessao qual o metadado e sua localizacao
	public MetadataLocationException(String message) {
		super(message);
	}

}
