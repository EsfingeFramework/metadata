package net.sf.esfinge.metadata;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import net.sf.esfinge.metadata.annotation.finder.Locator;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.RegularLocator;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

public class AnnotationFinder {
	

	public static  List<Annotation> findAllAnnotations(AnnotatedElement element) throws NoSuchMethodException, SecurityException, AnnotationReadingException {
		List<Annotation> list = new ArrayList<Annotation>();
		list.addAll(findAll(element));
		return list;
	}

	private static List<Annotation> findAll(AnnotatedElement element) throws AnnotationReadingException {

		List<Annotation> list = new ArrayList<Annotation>();
		Annotation[] annotations = element.getDeclaredAnnotations();
		for(Annotation annotation : annotations){
			MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotation.annotationType());
			List<Annotation> an = ml.findAllMetadata(element);
			for(Annotation a : an)
				AnnotatedElementUtils.addAnnotationIfNotInList(a, list);

		}
		return list;

//		if(!(element.equals(Object.class)))
//		{
//			for(Annotation annotations: element.getDeclaredAnnotations())
//			{
//				list.add(annotations);
//			}
//
//			if(element instanceof Method)
//			{
//				Method method = (Method) element;
//				Class<?> clazz= method.getDeclaringClass();
//					list.addAll(findAll(clazz,originalElement));
//			}
//			else if(element instanceof Field)
//			{
//				Field fieldWithElement  = (Field) element;
//				Class<?> clazz= fieldWithElement.getDeclaringClass();
//					list.addAll(findAll(clazz,originalElement));;
//
//			}
//			else if(element instanceof Class)
//			{
//				Class<?> clazz = (Class)element;
//				Class<?> superclassWithMetadata = clazz.getSuperclass();
//
//				if(superclassWithMetadata!=null){
//
//					for(Class<?> interfacesWithAnnotation: clazz.getInterfaces())
//					{
//						if(originalElement instanceof Method)
//						{
//							Method original = (Method) originalElement;
//							list.addAll(findAll(interfacesWithAnnotation.getDeclaredMethod(original.getName()),originalElement));
//						}
//						else
//						{
//							list.addAll(findAll(interfacesWithAnnotation,originalElement));
//						}
//					}
//					if(!(superclassWithMetadata.equals(Object.class))){
//						list.addAll(findAll(superclassWithMetadata,originalElement));
//					}
//				}
//
//
//			}
//
//		}


	}





	public static List<Annotation> findAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass) throws AnnotationReadingException {

		Map<Integer, MetadataLocator> locators = getAplicableLocatorChain(annotationClass);
		MetadataLocator ml = LocatorsFactory.createLocatorsChain(annotationClass);
		List<Annotation> annotations = new ArrayList<Annotation>();

		Annotation an = ml.findMetadata(element,annotationClass);
		if(an!=null)
			annotations.add(an);
		return annotations;
	}

	public static boolean existAnnotation(AnnotatedElement element, Class<? extends Annotation> annotationClass) throws AnnotationReadingException {
		try {

			return !findAnnotation(element, annotationClass).isEmpty();
		}catch(AnnotationReadingException are){

			return false;
		}
	}
	
	
	private static Map<Integer, MetadataLocator> getAplicableLocatorChain(Class<? extends Annotation> annotationClass){
		Map<Integer, MetadataLocator> locators = new LinkedHashMap<Integer, MetadataLocator>();
			for(Annotation annotation:annotationClass.getAnnotations()){

				if(annotation.annotationType().isAnnotationPresent(Locator.class)){
					Locator chain = annotation.annotationType().getAnnotation(Locator.class);
					try {
						locators.put(chain.chainPriority(), chain.value().newInstance());
					} catch (InstantiationException | IllegalAccessException e) {
						e.printStackTrace();
					}
				}
			}
		locators.put(0, new RegularLocator());
		return locators;
	}
}
