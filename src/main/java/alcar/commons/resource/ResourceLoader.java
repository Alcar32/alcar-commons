package alcar.commons.resource;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResourceLoader {

	/**
	 * 
	 * Load a resource from a given resource path and return it as {@link File java.io.File}.
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as {@link File java.io.File}.
	 */
	public static File loadResourceAsFile(String resourcePath){
		if(resourcePath.startsWith("/")){
			return new File(loadResourceAsUri(resourcePath));
		}else{
			System.err.println("A resource path must(!) begin with a \"/\"");
			return null;
		}
	}
	
	/**
	 * 
	 * Load a resource from given resource path and return it as {@link InputStream java.io.InputStream}.
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as {@link InputStream java.io.InputStream}.
	 */
	public static InputStream loadResourceAsStream(String resourcePath) {
		if(resourcePath.startsWith("/")){
			return ResourceLoader.class.getResourceAsStream(resourcePath);
		}else{
			System.err.println("A resource path must(!) begin with a \"/\"");
			return null;
		}
	}
	
	/**
	 * 
	 * Load a resource from given resource path and return it as {@link URL java.net.URL}.
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as {@link URL java.net.URL}.
	 */
	public static URL loadResourceAsURL(String resourcePath) {
		if(resourcePath.startsWith("/")){
			return ResourceLoader.class.getResource(resourcePath);
		}else{
			System.err.println("A resource path must(!) begin with a \"/\"");
			return null;
		}
	}
	
	/**
	 * 
	 * Load a resource from given resource path and return it as {@link URI java.net.URI}.
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as {@link URI java.net.URI}.
	 */
	public static URI loadResourceAsUri(String resourcePath) {
		URI resourceAsURI = null;
		if(resourcePath.startsWith("/")){
			try {
				resourceAsURI = loadResourceAsURL(resourcePath).toURI();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			}
			return resourceAsURI;
		}else{
			System.err.println("A resource path must(!) begin with a \"/\"");
			return resourceAsURI;
		}
	}
	
	/**
	 * 
	 * Load a resource from given resource path and return it as new (java 7) {@link Path java.nio.file.Path}
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as {@link Path java.nio.file.Path}.
	 * 
	 * @see Path
	 * @see Paths
	 */
	public static Path loadResourceAsNioFilePath(String resourcePath) {
		return Paths.get(loadResourceAsUri(resourcePath)); 
	}
}
