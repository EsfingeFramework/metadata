
import static org.junit.Assert.assertNull;

import net.sf.esfinge.metadata.AnnotationReadingException;
import net.sf.esfinge.metadata.factory.LocatorsFactory;
import net.sf.esfinge.metadata.locate.MetadataLocator;
import org.junit.Test;

import net.sf.esfinge.metadata.locate.EnclosingElementLocator;

public class PackageTest {

	@Test
	public void PackageDefaultTest() throws AnnotationReadingException {
		MetadataLocator ml = LocatorsFactory.createLocatorsChain(Transaction.class);
		//EnclosingElementLocator enclosingElementLocator = new EnclosingElementLocator();

		assertNull(ml.findMetadata(PackageTest.class, Transaction.class));
	}

}
