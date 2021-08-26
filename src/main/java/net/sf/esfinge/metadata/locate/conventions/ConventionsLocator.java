package net.sf.esfinge.metadata.locate.conventions;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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

	// the parameter can be inputstring etc...
	public static void loadConventions(String filename) {
		// get the conventions from the file
		// store them in a static variable

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();

			// Get Document
			Document doc = builder.parse(new File("src/main/java/conventions.config"));

			// Normalize the xml structure
			doc.getDocumentElement().normalize();

			// getting the convention first node to retrieve the data
			NodeList conventionsList = doc.getElementsByTagName("conventions");

			Node conventionsNode = conventionsList.item(0); // <conventions></conventions>

			NodeList annotation = conventionsNode.getChildNodes();
			int count = 0;
			for (int i = 0; i < annotation.getLength(); i++) {

				Node annotationNode = annotation.item(i);

				if (annotationNode.getNodeType() == Node.ELEMENT_NODE) {
					Element annotationElement = (Element) annotationNode;

					// there are two approaches,
					// one could be getting all attributes and iterate through them to see what are
					// the properties
					// NamedNodeMap attributes = annotationElement.getAttributes();
					// the next is getting the attributes by calling their names, which I have done
					// in this approach
					if (count == 0) {
						count++;
						String theAnnotation = annotationElement.getAttribute("name");
						System.out.println("the main annotation is: " + theAnnotation);
						String isApplytoAll = annotationElement.getAttribute("allConventionsNeedToApply");
						boolean allConventionsNeedToApply = false;
						if (isApplytoAll == "true") {
							allConventionsNeedToApply = true;
						}

						System.out.println("all Conventions needs to apply value is: " + isApplytoAll);
						System.out.println();
					}

					// then getting the conventions that annotation has
					NodeList convention = annotationNode.getChildNodes();

					for (int j = 0; j < convention.getLength(); j++) {
						Node conventionNode = convention.item(j);

						if (conventionNode.getNodeType() == Node.ELEMENT_NODE) {
							Element conventionElement = (Element) conventionNode;

							// getting the verifier first
							String verifier = conventionElement.getAttribute("verifier");
							System.out.println("///////----------------------------------------------");
							System.out.println();
							System.out.println("the Verifier is: " + verifier);
							System.out.println();

							// then getting the parameters of the verifier , which is the convention and its
							// value
							NodeList parameter = conventionNode.getChildNodes();

							for (int k = 0; k < parameter.getLength(); k++) {
								Node parameterNode = parameter.item(k);

								if (parameterNode.getNodeType() == Node.ELEMENT_NODE) {
									Element parameterElement = (Element) parameterNode;

									// the conventions and its value
									String theConvention = parameterElement.getAttribute("name");
									System.out
											.println("the Convention parameter for the verifier is: " + theConvention);
									String conventionValue = parameterElement.getAttribute("value");
									System.out.println("the Convention value is: " + conventionValue);
									System.out.println();
								}
							}

						}

					}
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		if (!nextLocator.hasMetadata(element, annotationClass) && isConventionsPresent(element, annotationClass)) {
			Annotation an = AnnotatedElementUtils.instantiateAnnotation(annotationClass);
			return an;
		}

		return nextLocator.findMetadata(element, annotationClass);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		if (!nextLocator.hasMetadata(element, annotationClass)) {
			return isConventionsPresent(element, annotationClass);
		}

		return nextLocator.hasMetadata(element, annotationClass);
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
