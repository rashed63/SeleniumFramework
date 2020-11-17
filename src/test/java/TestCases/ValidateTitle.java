package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.BaseProject;
import java.io.IOException;
//@Listeners(TestCases.Listeners.class)


public class ValidateTitle extends BaseProject {
    public WebDriver driver;


    public static Logger logger = LogManager.getLogger(ValidateTitle.class.getName());
    @BeforeTest
    public void intialize2() throws IOException {
        driver = initializeDriver();

        driver.get(prop.getProperty("Url"));
    }
    @Test
    public void basePageNavigation() throws InterruptedException,IOException {
        LandingPage landingPage = new LandingPage(driver);




       // Assert.assertEquals(driver.getTitle(),"whatevethefuck");


        Assert.assertEquals(landingPage.getTitle().getText(),"FEATURED COURSESW");
        logger.info("Title matched");


    }
    @AfterTest
    public void closeDriver(){
        driver.close();
    }

}
