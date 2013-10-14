package alcar.commons.resource;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;

public class ResourceLoaderUnit {

	public ResourceLoaderUnit() {
		
	}
	
	@Test
	public void loadResourceAsFile() {
		File file = ResourceLoader.loadResourceAsFile("/test/test.txt");
		assertTrue(file.exists());
		assertTrue(file.isFile());
	}
}
