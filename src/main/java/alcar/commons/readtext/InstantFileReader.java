package alcar.commons.readtext;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class InstantFileReader {

	private File file;
	
	private Charset charset;
	
	public InstantFileReader(File file, Charset charset) {
		this.file = file;
		this.charset = charset;
	}
	
	public String readText() throws FileNotFoundException {
		
		BufferedReader bread = null;
		String text = null;
		try {
			bread = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
			
		}finally {
			try {
				bread.close();
			}catch(IOException ioe){
				ioe.printStackTrace();
			}
		}
		return text;
	}

}
