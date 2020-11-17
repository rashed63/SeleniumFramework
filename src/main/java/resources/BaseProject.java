package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseProject {
    public WebDriver driver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {

        prop = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\JavaWorkspace\\SeleniumFramework\\" +
                "src\\main\\java\\resources\\data.properties");
        prop.load(inputStream);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);
        //String urlLink = prop.getProperty("Url");
        //System.out.println(urlLink);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "D:\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        /*else if(browserName.equals("IE")){

        }*/
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
    public String getScreeshotPath(String testCaseName, WebDriver driver) throws IOException {
        System.out.println("In getScreeshotPath method");
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File source = screenshot.getScreenshotAs(OutputType.FILE);
        //String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
        String destinationFile = "D:\\JavaWorkspace\\SeleniumFramework\\target\\surefire-reports\\"+testCaseName+".png";

        FileUtils.copyFile(source,new File(destinationFile));
        return destinationFile;
    }

}
