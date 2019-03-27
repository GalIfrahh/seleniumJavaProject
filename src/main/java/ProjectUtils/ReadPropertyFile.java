package ProjectUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {

	public InputStream input = null;
	
	public Properties readPropFile(Properties prop, String propertiesFilePath) {
	
			try {

				input = new FileInputStream(propertiesFilePath);

				// load a properties file
				prop.load(input);

		    } catch (IOException ex) {
		      
		    	ex.printStackTrace();
		    
		    }
		    	
			return prop;
		        }
		    

	
	public void killInput() {
		
	        if (input != null) {
	        	
	            try {
	            	
	                input.close();
	                
	            } catch (IOException e) {
	            	
	                e.printStackTrace();
	            }
	        }
	    }
		
	}
