package org.esfinge.metadata.foo.annotation.test;

import static org.junit.Assert.*;

import org.esfinge.metadata.foo.annotation.ValidateStaticFieldOnly;
import org.junit.Test;

public class TestStaticFieldOnly {
	
	@Test
	public void test() {
		Person p = new Person("Jason", "32198732143", 15);
		
		boolean validated = ValidateStaticFieldOnly.validateStaticFieldOnly(p);
			
		assertTrue(validated);
	}

}
