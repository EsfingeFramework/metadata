package net.sf.esfinge.metadata.locate.conventions;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.esfinge.metadata.annotation.container.AnnotationProperty;
import net.sf.esfinge.metadata.annotation.container.PropertyContainsAnnotation;
import net.sf.esfinge.metadata.annotation.container.PropertyProcessors;
import net.sf.esfinge.metadata.locate.RegularLocator;
import org.apache.commons.beanutils.BeanUtils;

import org.reflections.Reflections;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.sf.esfinge.metadata.locate.MetadataLocationException;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.AllConventionsNeedToApply;
import net.sf.esfinge.metadata.locate.conventions.annotations.Verifier;
import net.sf.esfinge.metadata.utils.AnnotatedElementUtils;

public class ConventionsLocator extends MetadataLocator {


	private static Map<Class<?>, ConventionsMetadataContainer> conventionsDefinitions = new HashMap<>();

	public static void loadConventions(String filename) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new File(filename));
			doc.getDocumentElement().normalize();
			NodeList conventionsList = doc.getElementsByTagName("conventions");
			Node conventionsNode = conventionsList.item(0);
			NodeList annotation = conventionsNode.getChildNodes();
			int count = 0;
			for (int i = 0; i < annotation.getLength(); i++){
				Node annotationNode = annotation.item(i);
				if (annotationNode.getNodeType() == Node.ELEMENT_NODE){
					Element annotationElement = (Element) annotationNode;
					if (count == 0){
						count++;
						String theAnnotation = annotationElement.getAttribute("name");
						Class<?> annotationClass = Class.forName(theAnnotation);
						ConventionsMetadataContainer container = new ConventionsMetadataContainer();
						String isApplytoAll = annotationElement.getAttribute("allConventionsNeedToApply");
						boolean allConventionsNeedToApply = false;
						if (isApplytoAll == "true"){
							allConventionsNeedToApply = true;
						}
						container.setAllConventionsNeedToApply(allConventionsNeedToApply);
						NodeList convention = annotationNode.getChildNodes();

						for (int j = 0; j < convention.getLength(); j++){
							Node conventionNode = convention.item(j);
							if (conventionNode.getNodeType() == Node.ELEMENT_NODE){
								Element conventionElement = (Element) conventionNode;
								String verifier = conventionElement.getAttribute("verifier");
								Class<?> verifierClass = Class.forName(verifier);
								ConventionVerifier verifierInstance = (ConventionVerifier) verifierClass.getConstructor().newInstance();
								NodeList parameter = conventionNode.getChildNodes();
								Map<String, String> parameters = new HashMap<String, String>();

								for (int k = 0; k < parameter.getLength(); k++){
									Node parameterNode = parameter.item(k);
									if (parameterNode.getNodeType() == Node.ELEMENT_NODE) {
										Element parameterElement = (Element) parameterNode;
										String theConvention = parameterElement.getAttribute("name");
										String conventionValue = parameterElement.getAttribute("value");
										parameters.put(theConvention, conventionValue);

									}
								}

								verifierInstance.init(parameters);
								container.addVerifier(verifierInstance);

							}

						}
						conventionsDefinitions.put(annotationClass, container);

					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override

	public List<Annotation> findAllMetadata(AnnotatedElement element) throws MetadataLocationException {
		List<Annotation> annotations = new ArrayList<>();
		annotations = nextLocator.findAllMetadata(element);
		String packageRoot = AnnotatedElementUtils.getClassName(element).split("\\.")[0];
		List<Annotation> convAnnotations = new ArrayList<>(annotations);
		Set<Class<?>> conventions =
				new Reflections("net.sf.esfinge.metadata.locate.conventions.annotations").getTypesAnnotatedWith(Verifier.class, true);
		ConventionsMetadataContainer cmc = new ConventionsMetadataContainer();
		Set<Class<?>> appConventions = new Reflections(packageRoot).getTypesAnnotatedWith(Verifier.class,true);
		conventions.addAll(appConventions);
		for (Class<?> c : conventions) {
			//System.out.println(c);
			Class<? extends Annotation> annot = c.asSubclass(Annotation.class);
			Set<Class<?>> annotatedWithConventions = new Reflections(packageRoot).getTypesAnnotatedWith(annot, true);
			//System.out.println(annotatedWithConventions.size());
			for(Class<?> ac : annotatedWithConventions){
				Class<? extends Annotation> annotatedac = ac.asSubclass(Annotation.class);
				//System.out.println(ac.getSimpleName()+" "+c.getSimpleName());
				if(hasMetadata(element,annotatedac) && isConventionsPresent(element,annotatedac)){
					Annotation an =findMetadata(element,annotatedac);
					convAnnotations.add(an);
				}
			}

		}

		return convAnnotations;
	}

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		if (!nextLocator.hasMetadata(element, annotationClass) && isConventionsPresent(element, annotationClass)) {
			//System.out.println("element class = "+element.getClass());
			Annotation an = AnnotatedElementUtils.instantiateAnnotation(annotationClass,element);
			return an;
		}

		return nextLocator.findMetadata(element, annotationClass);
	}



	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		boolean nextFoundMetadata = getNextLocator().hasMetadata(element, annotationClass);
		if (!nextFoundMetadata) {

			return isConventionsPresent(element, annotationClass);
		}

		return nextFoundMetadata;
	}

	private boolean isConventionsPresent(AnnotatedElement element, Class<? extends Annotation> annotationClass) {

		ConventionsMetadataContainer cmc = getConventions(annotationClass);
		boolean result = cmc.isAllConventionsNeedToApply();

		for (ConventionVerifier convVer : cmc.getVerifiers()) {
			boolean hasConv = convVer.isConventionPresent(element);
			if (cmc.isAllConventionsNeedToApply())
				result = result && hasConv;
			else
				result = result || hasConv;
		}
		return result;
	}

	private ConventionsMetadataContainer getConventions(Class<? extends Annotation> annotationClass) {
		//System.out.println(annotationClass.getSimpleName());
		if (conventionsDefinitions.containsKey(annotationClass)) {

			return conventionsDefinitions.get(annotationClass);
		} else {
			ConventionsMetadataContainer cmc = new ConventionsMetadataContainer();
			cmc.setAllConventionsNeedToApply(annotationClass.isAnnotationPresent(AllConventionsNeedToApply.class));

			for (Annotation annot : annotationClass.getAnnotations()) {
				try {

					if (annot.annotationType().isAnnotationPresent(Verifier.class)) {

						Verifier v = annot.annotationType().getAnnotation(Verifier.class);
						Class<? extends ConventionVerifier> convClazz = v.value();

						ConventionVerifier convVer = convClazz.getConstructor().newInstance();
						convVer.init(annot);
						cmc.getVerifiers().add(convVer);
					}
				} catch (Exception e) {
					throw new MetadataLocationException(e);
				}
			}
			conventionsDefinitions.put(annotationClass, cmc);

			return cmc;
		}
	}

}
