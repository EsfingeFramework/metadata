package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import net.sf.esfinge.metadata.locate.MetadataLocationException;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.PrefixConvention;
import net.sf.esfinge.metadata.locate.conventions.annotations.SuffixConvention;

public class ConventionsLocator extends MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {
		return nextLocator.findMetadata(element, annotationClass);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass) {
		
		if (!nextLocator.hasMetadata(element, annotationClass)) {
			
			Annotation annotations[] = annotationClass.getAnnotations();
			for(Annotation annot: annotations) { 
				
				if(annot instanceof PrefixConvention){
					  String prefix = ((PrefixConvention) annot).value();
					  
					  if(getElementName(element).startsWith(prefix)) {
						  return true;
					  }
					  
				} else if(annot instanceof SuffixConvention) {
					
					String suffix = ((SuffixConvention) annot).value();
					String firstLetStr = suffix.substring(0, 1);
					String remLetStr = suffix.substring(1);
					firstLetStr = firstLetStr.toUpperCase();
					suffix = firstLetStr + remLetStr;
					
					if(getElementName(element).endsWith(suffix)) {
						  return true;
					  }
				}
			}
			
		}
		
		return nextLocator.hasMetadata(element, annotationClass);
		//if false
		//see if the annotation has a prefix annotation
		//get the prefix value if available
		//if the element has the prefix, return true
		
	}

	private String getElementName(AnnotatedElement element) {
		//TODO: suport other kinds of element
		//All Known Subinterfaces:
		//AnnotatedArrayType, AnnotatedParameterizedType, AnnotatedType, AnnotatedTypeVariable, AnnotatedWildcardType, GenericDeclaration, TypeVariable<D>
		//All Known Implementing Classes:
		//AccessibleObject, Class, Constructor, Executable, Field, Method, Package, Parameter
		return ((Method) element).getName();
	}

}
