package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

	protected  Properties properties;
	protected static int testCount = TestConfigs.SMOKE_TEST_COUNT; 

	static {
		Driver.getInstance().setDriver(new ChromeDriver());
		}	
	
	
	public TestBase() {
		try {
		if(System.getenv("env") != null && System.getenv("env").equals(TestConfigs.PROD_ENV_NAME)) {	
	
			properties = new Properties();
			String pPath = "src/test/resources/configs/calculatorProdMetadata.properties";
			File pFile = new File(pPath);
			FileInputStream pFis = new FileInputStream(pFile);
			properties.load(pFis);
		
		}
		else  {
			
			properties = new Properties();
			String stPath = "src/test/resources/configs/calculatorStagingMetadata.properties";
			File sFile = new File(stPath);
			FileInputStream sFis = new FileInputStream(sFile);
			properties.load(sFis);
			
		}
		
		testCount = System.getenv("testCount") != null ? Integer.valueOf(System.getenv("testCount")): TestConfigs.SMOKE_TEST_COUNT;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
