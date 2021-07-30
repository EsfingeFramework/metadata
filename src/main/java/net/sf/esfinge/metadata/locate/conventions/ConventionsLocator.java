package net.sf.esfinge.metadata.locate.conventions;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

import net.sf.esfinge.classmock.ClassMock;
import net.sf.esfinge.classmock.api.IClassWriter;
import net.sf.esfinge.metadata.locate.MetadataLocationException;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import net.sf.esfinge.metadata.locate.conventions.annotations.Verifier;

public class ConventionsLocator extends MetadataLocator {

	@Override
	public Annotation findMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		if (hasMetadata(element, annotationClass)) {

			for (Annotation annot : annotationClass.getAnnotations()) {

				try {
					// see if there is an annotation with @Verifier
					if (annot.annotationType().isAnnotationPresent(Verifier.class)) {
						// create the processor with the class configured using reflection
						Verifier v = annot.annotationType().getAnnotation(Verifier.class);
						Class<? extends ConventionVerifier> convClazz = v.value();
						ConventionVerifier convVer = convClazz.getConstructor().newInstance();

						// initialize with the annotation
						convVer.init(annot);

						// execute if Convention is Present
						boolean hasConv = convVer.isConventionPresent(element);
						if (hasConv) {

							IClassWriter mock = ClassMock.of("SingleClassName");
							mock.annotation(annot.getClass()).property("value", ((Verifier) annot).value());
							Class<?> yourClass = mock.build();

							return yourClass.getAnnotation(annot.getClass());
						}

					}
				} catch (Exception e) {
					throw new MetadataLocationException(e);
				}

			}
		}

		return nextLocator.findMetadata(element, annotationClass);
	}

	@Override
	public boolean hasMetadata(AnnotatedElement element, Class<? extends Annotation> annotationClass)
			throws MetadataLocationException {

		if (!nextLocator.hasMetadata(element, annotationClass)) {

			for (Annotation annot : annotationClass.getAnnotations()) {

				try {
					// see if there is an annotation with @Verifier
					if (annot.annotationType().isAnnotationPresent(Verifier.class)) {
						// create the processor with the class configured using reflection
						Verifier v = annot.annotationType().getAnnotation(Verifier.class);
						Class<? extends ConventionVerifier> convClazz = v.value();
						System.out.println(convClazz);
						ConventionVerifier convVer = convClazz.getConstructor().newInstance();

						// initialize with the annotation
						convVer.init(annot);

						// execute if Convention is Present
						boolean hasConv = convVer.isConventionPresent(element);
						if (hasConv)
							return true;
					}
				} catch (Exception e) {
					throw new MetadataLocationException(e);
				}

				// bonus: create a new convention using the new structure
				// RegularExpression
			}

		}

		return nextLocator.hasMetadata(element, annotationClass);
		// if false
		// see if the annotation has a prefix annotation
		// get the prefix value if available
		// if the element has the prefix, return true

	}

	private String getElementName(AnnotatedElement element) {
		// TODO: suport other kinds of element
		// All Known Subinterfaces:
		// AnnotatedArrayType, AnnotatedParameterizedType, AnnotatedType,
		// AnnotatedTypeVariable, AnnotatedWildcardType, GenericDeclaration,
		// TypeVariable<D>
		// All Known Implementing Classes:
		// AccessibleObject, Class, Constructor, Executable, Field, Method, Package,
		// Parameter
		return ((Method) element).getName();
	}

}
