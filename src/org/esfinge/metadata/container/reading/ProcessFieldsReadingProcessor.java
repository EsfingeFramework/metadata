package org.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.esfinge.metadata.AnnotationReadingException;
import org.esfinge.metadata.LeitorMetadados;
import org.esfinge.metadata.container.AnnotationProperty;
import org.esfinge.metadata.container.AnnotationReadingProcessor;
import org.esfinge.metadata.container.ContainsAnnotation;
import org.esfinge.metadata.container.ElementName;
import org.esfinge.metadata.container.ProcessFields;
import org.esfinge.metadata.container.ProcessMethods;

import com.sun.xml.internal.ws.api.databinding.MetadataReader;

public class ProcessFieldsReadingProcessor implements AnnotationReadingProcessor {
	
	private Field fieldAnnoted;
	List<Object> lista;
	ParameterizedType fieldGenericType;

	@Override
	public void initAnnotation(Annotation an, Field field) {
		
		fieldAnnoted = field;
		lista = new ArrayList<Object>();
		fieldGenericType =(ParameterizedType)field.getGenericType();
		
	}
	
	
	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container) throws AnnotationReadingException {
		// TODO Auto-generated method stub
		try {
			if (elementWithMetadata.getClass().equals(Class.class)) {
				Class<?> clazz = (Class<?>) elementWithMetadata;
				for (Type t1 : fieldGenericType.getActualTypeArguments()){
					Class <?> outputClass =(Class<?>)t1;
					for(Field f1: clazz.getDeclaredFields())
					{
						LeitorMetadados metadataReader = new LeitorMetadados();
						Object containerField = outputClass.newInstance();
						containerField = metadataReader.metadataReader(f1, outputClass);
						lista.add(containerField);
					}
					setProperty(container,fieldAnnoted.getName(),lista);
				}					
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

}
