package alcar.commons.systemproperties;


public class SysProperties {

	/**
	 * this ONLY exist if a application assembler (appassembler) is used!!!
	 */
	public static final String APP_HOME = "app.home"; 
	public static final String USER_NAME = "user.name";
	public static final String USER_HOME = "user.home";
	public static final String USER_DIR = "user.dir";
	public static final String PATH_SEPARATOR = "path.separator";
	public static final String OS_VERSION = "os.version";
	public static final String OS_NAME = "os.name";
	public static final String OS_ARCH = "os.arch";
	public static final String LINE_SEPARATOR = "line.separator";
	public static final String JAVA_VERSION = "java.version";
	public static final String JAVA_VENDOR_URL = "java.vendor.url";
	public static final String JAVA_VENDOR = "java.vendor";
	public static final String JAVA_HOME = "java.home";
	public static final String FILE_SEPARATOR =  "file.separator";
	public static final String JAVA_CLASSPATH =  "java.class.path";
	

	
	public static void main(String[] args) {
		String arg = args[0];
		if(System.getProperties().keySet().contains(arg)){
			System.out.println(arg + " = " + System.getProperty(arg));
		}
	}
}
