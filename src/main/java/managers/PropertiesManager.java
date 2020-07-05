package managers;

import java.io.IOException;

import configurations.ConfigurationProperties;

public class PropertiesManager {
	
	private ConfigurationProperties configurationProperties;
	
	
	public ConfigurationProperties getConfigurationProperties() throws IOException {
		
		if(configurationProperties==null) {
			configurationProperties=new ConfigurationProperties();
		}
		
		return configurationProperties;
		
	}

}
