package net.sf.esfinge.metadata.container.reading;

import static org.apache.commons.beanutils.PropertyUtils.setProperty;


import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import net.sf.esfinge.metadata.AnnotationFinder;
import net.sf.esfinge.metadata.AnnotationReader;
import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.AnnotationValidationException;
import net.sf.esfinge.metadata.annotation.container.ContainerFor;
import net.sf.esfinge.metadata.container.AnnotationReadingProcessor;
import net.sf.esfinge.metadata.container.ContainerTarget;

public class ProcessParametersReadingProcessor implements AnnotationReadingProcessor{
	// atributo anotado com @ProcessParameters
		private Field fieldAnnoted;

		// armazena os metadados dos parametros em lista
		List<Object> lista;

		// armazena os metadados dos parametros em set
		Set<Object> set;

		// armazena os metadados dos parametros em map
		Map<Object, Object> map;

		// tipo generico do container dos metadados dos parametros
		ParameterizedType fieldGenericType;

	
	@Override
	public void initAnnotation(Annotation an, AnnotatedElement elementWithMetadata)
			throws AnnotationValidationException {
		// TODO Auto-generated method stub
		// o atributo que recebera a colecao dos metadados
				fieldAnnoted = (Field) elementWithMetadata;

				lista = new ArrayList<Object>();
				set = new HashSet<Object>();
				map = new HashMap<>();

				// obtem o tipo do container dos metadados
				fieldGenericType = (ParameterizedType) fieldAnnoted.getGenericType();
		
	}

	@Override
	public void read(AnnotatedElement elementWithMetadata, Object container, ContainerTarget target)
			throws AnnotationReadingException {

		try
		{
			// somente processa dentro de containers de metodos
			if (target == ContainerTarget.METHODS)
			{
				// o elemento sendo processado (metodo)
				Method method = (Method) elementWithMetadata;
				
				// obtem o tipo do container para os metadados de parametros
				for (Type t1 : fieldGenericType.getActualTypeArguments())
				{
					// classe do container para parametros
					Class<?> containerClass = (Class<?>) t1;
					
					// procura a anotacao @ContainerFor
					for (Annotation ann : AnnotationFinder.findAnnotation(containerClass, ContainerFor.class))
					{
						ContainerFor containerFor = (ContainerFor) ann;
						
						// assegura o tipo correto do Container
						if (!containerFor.value().equals(ContainerTarget.PARAMETER))
						{
							throw new Exception("ContainerFor: " + containerFor.value() + " must be of type PARAMETER");
						}
						
						// obtem os parametros do metodo
						for ( Parameter p : method.getParameters() )
						{
							// processa os metadados do parametro
							AnnotationReader metadataReader = new AnnotationReader();
							Object containerParameter = containerClass.newInstance();
							containerParameter = metadataReader.readingAnnotationsTo(p, containerClass);
							
							// adiciona o resultado na colecao
							lista.add(containerParameter);
							set.add(containerParameter);
							map.put(p, containerParameter);
						}
						
						// atribui os metadados processados ao campo anotado com @ProcessParameters,
						// conforme o seu tipo (List, Set ou Map)
						if (fieldAnnoted.getType().equals(List.class))
						{
							setProperty(container, fieldAnnoted.getName(), lista);
						}
						else if (fieldAnnoted.getType().equals(Set.class))
						{
							setProperty(container, fieldAnnoted.getName(), set);
						}
						else if (fieldAnnoted.getType().equals(Map.class))
						{
							setProperty(container, fieldAnnoted.getName(), map);
						}

					}
				}
			}
		}
		catch (Exception e)
		{
			throw new AnnotationReadingException(
					"Cannot read and record the processParameters in the field " + fieldAnnoted.getName(), e);
		}
	}
		

}
