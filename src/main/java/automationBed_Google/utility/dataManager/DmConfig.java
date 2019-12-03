package automationBed_Google.utility.dataManager;

import java.io.File;
import java.io.FileReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import automationBed_Google.utility.webDriverManager.WdmConfig;

public class DmConfig {

	private static DmConfig instance;
	private Config conf;

	protected DmConfig() {
		conf = ConfigFactory.load(WdmConfig.class.getClassLoader(), System
				.getProperty("dm.properties", "datamanager.properties"));
	}

	public static synchronized DmConfig getInstance() {
		if (instance == null) {
			instance = new DmConfig();
		}
		return instance;
	}	
	public static String getString(String key) {
		return DmConfig.getInstance().conf.getString(key);
	}
	
	public static int getInt(String key) {
		return DmConfig.getInstance().conf.getInt(key);
	}

	public static boolean getBoolean(String key) {
		return DmConfig.getInstance().conf.getBoolean(key);
	}
}
