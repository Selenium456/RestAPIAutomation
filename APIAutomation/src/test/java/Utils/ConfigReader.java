package Utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
	
	
	public Properties prop = null;
	
	public void LoadConfigFile() throws IOException {
		
		prop = new Properties();
		
		String PropFileName = "Config.properties";
		
		InputStream ips = getClass().getClassLoader().getResourceAsStream(PropFileName);
		
		if(ips!=null) {
			prop.load(ips);
		}
		else {
			throw new FileNotFoundException("Poperty file "+PropFileName+" not found in classpath");
		}
		
		
	}
	
	public String getURI() {
		
		return prop.getProperty("URI");
	}
	
	public  String getReportConfigPath(){
		String reportConfigPath = prop.getProperty("reportConfigPath");
		if(reportConfigPath!= null) return reportConfigPath;
		else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
	}
	
	public String getJsonPath() {
		
		String JsonPath = prop.getProperty("Jsonpath");
		if(JsonPath!= null) return JsonPath;
		else throw new RuntimeException("JsonPath not specified in the Configuration.properties file for the Key:JsonPath");	
		
	}
	
	
	
	

}
