package EndToEnd;

/*import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Properties;*/

public class FramworkCodes {
    //codes from dada for framework
   /* @BeforeSuite
    public WebDriver initializeDriver() throws IOException {
        utils = new Utils();
        prop = new Properties();
        FileInputStream inputStream = new FileInputStream("D:\\JavaWorkspace\\SeleniumFramework\\" +
                "src\\main\\java\\resources\\data.properties");
        prop.load(inputStream);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);
        //String urlLink = prop.getProperty("Url");
        //System.out.println(urlLink);

        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","D:\\drivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        *//*else if(browserName.equals("IE")){

        }*//*
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }






    @BeforeMethod(alwaysRun = true)
    public void beforeMethod(Method method) {
        if (null == parentTest) {
            parentTest = extent.createTest(getClass().getSimpleName());
            //parentTest.getModel().setStartTime(Commons.getTime());
        } else if (!parentTest.getModel().getName().equals(getClass().getSimpleName())) {
            parentTest = extent.createTest(getClass().getSimpleName());
            //parentTest.getModel().setStartTime(Commons.getTime());
        }
        Parameter[] parameters = method.getParameters();
        if (null == test || !test.getModel().getName().equals(method.getName())
                || parameters.length > 0) {
            if (prevTestSkipped && null != test) {
                test.skip("TestPage is skipped");
                prevTestSkipped = false;
            }
            test = parentTest.createNode(method.getName());
            //test.getModel().setStartTime(Commons.getTime());
            //info("'" + method.getName() + "' test is started.");
        }



        @AfterMethod(alwaysRun = true)
        public void afterMethod(ITestResult result) {
            if (result.getStatus() == ITestResult.FAILURE) {
                test.log(Status.FAIL, result.getThrowable());
                if (Boolean
                        .valueOf(properties.getProperty(PropertyConstants.TAKE_SCREENSHOT_ON_FAILURE))) {
                    logger.info("Take screen shot");
                    String screenshot = seleniumUtils.takeScreenshot(driver);
                    try {
                        //test.fail("Screenshot").addScreenCaptureFromPath(Commons.getRelativePath(Constants.REPORT_DIR, screenshot));
                        test.addScreenCaptureFromPath(Commons.getRelativePath(Constants.REPORT_DIR, screenshot));
                        logger.info("Screenshot has taken.");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (result.getStatus() == ITestResult.SKIP) {
                test.info("TestPage is Skipped");
                //test.log(Status.DEBUG, result.getThrowable());
                //            //test.log(Status.SKIP, result.getThrowable());
                prevTestSkipped = true;
            }

            if (result.getStatus() == ITestResult.SUCCESS) {
                prevTestSkipped = false;
                test.pass("TestPage execution is passed.");
            }

            test.getModel().setEndTime(Commons.getTime());
            String status = result.getStatus() == ITestResult.SUCCESS ? "PASSED" : "FAILED";
            info("'" + result.getName() + "' execution completed. TestPage Case is " + status + ".");

            parentTest.getModel().setEndTime(Commons.getTime());
            extent.flush();
        }


        @AfterSuite
        public void closeDriver(){
            driver.close();

        }

        public void getScreeshotPath(String testCaseName, WebDriver driver) throws IOException {
            System.out.println("In getScreeshotPath method");
            TakesScreenshot screenshot = (TakesScreenshot) this.driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            //String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
            String destinationFile = "D:\\JavaWorkspace\\SeleniumFramework\\target\\surefire-reports\\"+testCaseName+".png";

            FileUtils.copyFile(source,new File(destinationFile));
        }*/
}
