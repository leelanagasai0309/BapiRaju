package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class testBase {
	
	public static WebDriver driver;
	public Properties p;
	public Logger logger;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"browser"})
	void setup(String br) throws IOException {
		
		logger=LogManager.getLogger(this.getClass());//Log4j
		
		switch (br.toLowerCase()) {
		case "chrome":driver = new ChromeDriver();break;
		case "edge":driver = new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();break;
		default:System.out.println("Invalid Browser");return;
		}

		FileReader file = new FileReader("./src//test//resources//config.properties");
	    p=new Properties();
		p.load(file);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(p.getProperty("appURL"));
		
	}
	
	@AfterClass(groups= {"Sanity","Regression","Master"})
	void tearDown() {
		driver.quit();
	}
	
	String randomeString() 
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}
	
	String randomNumber()
	{
		String generatedString=RandomStringUtils.randomNumeric(10);
		return generatedString;
	}
	
	public String randomAlphaNumeric()
	{
		String str=RandomStringUtils.randomAlphabetic(3);
		String num=RandomStringUtils.randomNumeric(3);
		
		return (str+num);
	}
	
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath = (System.getProperty("user.dir"))+"//screenshots//"+ tname + "_" + timeStamp +".png";
		
		File targetFile=new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
		
	}
	
}
