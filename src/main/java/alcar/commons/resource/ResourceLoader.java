package alcar.commons.resource;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class ResourceLoader {

	/**
	 * 
	 * Load a resource from a given resource path and return it as file.
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as file.
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
	 * Load a resource from given resource path and return it as stream.
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as stream.
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
	 * Load a resource from given resource path and return it as url.
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as url.
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
	 * Load a resource from given resource path and return it as url.
	 * 
	 * @param resourcePath The path of resource.
	 * @return The resource as url.
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
}
