
import static org.junit.Assert.assertNull;

import org.junit.Test;

import net.sf.esfinge.metadata.locate.EnclosingElementLocator;

public class PackageTest {

	@Test
	public void PackageDefaultTest() {
		EnclosingElementLocator enclosingElementLocator = new EnclosingElementLocator();
		assertNull(enclosingElementLocator.findMetadata(PackageTest.class, Transaction.class));
	}

}
