package net.sf.esfinge.metadata.locate.conventions;

import java.io.File;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.BeforeClass;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;

public class FileReader {

	public static void main(String[] args) throws Exception {
		
		ConventionsLocator.loadConventions("src/main/java/conventions.config");
		
		MetadataLocator l = LocatorsFactory.createLocatorsChain(ForTestingFileConventions.class);
		
		Method m = ForTestingConventions.class.getMethod("prefixMethod");
		
		boolean result = l.hasMetadata(m, ForTestingFileConventions.class);
		
		System.out.println(result);
//		
//		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//		try {
//			DocumentBuilder builder = factory.newDocumentBuilder();
//
//			// Get Document
//			Document doc = builder.parse(new File("src/main/java/conventions.config"));
//
//			// Normalize the xml structure
//			doc.getDocumentElement().normalize();
//
//			// getting the convention first node to retrieve the data
//			NodeList conventionsList = doc.getElementsByTagName("conventions");
//
//			Node conventionsNode = conventionsList.item(0); // <conventions></conventions>
//
//			NodeList annotation = conventionsNode.getChildNodes();
//			int count = 0;
//			for (int i = 0; i < annotation.getLength(); i++) {
//
//				Node annotationNode = annotation.item(i);
//
//				if (annotationNode.getNodeType() == Node.ELEMENT_NODE) {
//					Element annotationElement = (Element) annotationNode;
//
//					// there are two approaches,
//					// one could be getting all attributes and iterate through them to see what are
//					// the properties
//					// NamedNodeMap attributes = annotationElement.getAttributes();
//					// the next is getting the attributes by calling their names, which I have done
//					// in this approach
//					if (count == 0) {
//						count++;
//						String theAnnotation = annotationElement.getAttribute("name");
//						System.out.println("the main annotation is: " + theAnnotation);
//						String isApplytoAll = annotationElement.getAttribute("allConventionsNeedToApply");
//						boolean allConventionsNeedToApply = false;
//						if (isApplytoAll == "true") {
//							allConventionsNeedToApply = true;
//						}
//
//						System.out.println("all Conventions needs to apply value is: " + isApplytoAll);
//						System.out.println();
//					}
//					
//					// then getting the conventions that annotation has
//					NodeList convention = annotationNode.getChildNodes();
//
//					for (int j = 0; j < convention.getLength(); j++) {
//						Node conventionNode = convention.item(j);
//
//						if (conventionNode.getNodeType() == Node.ELEMENT_NODE) {
//							Element conventionElement = (Element) conventionNode;
//							
//							// getting the verifier first
//							String verifier = conventionElement.getAttribute("verifier");
//							System.out.println("///////----------------------------------------------");
//							System.out.println();
//							System.out.println("the Verifier is: "+ verifier);
//							System.out.println();
//							
//							// then getting the parameters of the verifier , which is the convention and its value
//							NodeList parameter = conventionNode.getChildNodes();
//
//							for (int k = 0; k < parameter.getLength(); k++) {
//								Node parameterNode = parameter.item(k);
//
//								if (parameterNode.getNodeType() == Node.ELEMENT_NODE) {
//									Element parameterElement = (Element) parameterNode;
//									
//									// the conventions and its value
//									String theConvention = parameterElement.getAttribute("name");
//									System.out.println("the Convention parameter for the verifier is: "+theConvention);
//									String conventionValue = parameterElement.getAttribute("value");
//									System.out.println("the Convention value is: "+conventionValue);
//									System.out.println();
//								}
//							}
//
//						}
//
//					}
//				}
//			}
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

}
