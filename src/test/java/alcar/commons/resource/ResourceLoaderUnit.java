package alcar.commons.resource;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class ResourceLoaderUnit {

	public ResourceLoaderUnit() {
		
	}
	
	@Test
	public void loadResourceAsFileUnit() {
		File file = ResourceLoader.loadResourceAsFile("/test/test.txt");
		assertTrue(file.exists());
		assertTrue(file.isFile());
	}

	@Test
	public void loadResourceAsNioPathUnit() throws IOException {
		Path nioPath = ResourceLoader.loadResourceAsNioFilePath("/test/test.txt");
		assertTrue(Files.exists(nioPath));
	}
}
