package Runner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import Utils.ConfigReader;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature", glue = { "Steps" }, plugin = {"html:target/cucumber-html-reports.html",
		"json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml" }, monochrome = true)

public class TestRunner {

	public static ConfigReader configreader;

	@BeforeClass
	public static void loadConfigProperties() throws IOException {
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		configreader = new ConfigReader();
		configreader.LoadConfigFile();
		//String reportpath = new File(configreader.getReportConfigPath()).getName();
		//System.out.println("The report path is " + reportpath);
		//ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        //extentProperties.setReportPath("target/cucumber-reports/"+"ApiReport_"+timeStamp.replace(":","_").replace(".","_")+".html");
	}

	@AfterClass
	public static void writeExtentReport() {
		
		/*
		 * Reporter.loadXMLConfig(new File(configreader.getReportConfigPath())); //
		 * Reporter.assignAuthor("Kiran Ayyagari"); Reporter.setSystemInfo("User Name",
		 * System.getProperty("user.name")); Reporter.setSystemInfo("Time Zone",
		 * System.getProperty("user.timezone")); Reporter.setSystemInfo("Machine",
		 * "Windows 10" + "64 Bit"); Reporter.setSystemInfo("API Library",
		 * "RestAssured");
		 */
		 
	}

}
