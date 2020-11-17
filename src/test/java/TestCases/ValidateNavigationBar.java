package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.BaseProject;

import java.io.IOException;


public class ValidateNavigationBar extends BaseProject {
    public WebDriver driver;

    public static Logger logger = LogManager.getLogger(ValidateNavigationBar.class.getName());
    @BeforeTest
    public void basePageNavigation() throws IOException {
        driver= initializeDriver();

        driver.get(prop.getProperty("Url"));
        logger.info("Url Linked accessed properly");
        //driver.get("http://qaclickacademy.com");
        //By using data.properties through base projects public properties we can avoid direct webpage name
        //writing

        //driver.get(properties.getProperty("url"));
    }
    @Test
    public void displayNavigation() {

        //Assert.assertEquals(driver.getTitle(),"whatevethefuck");
        //Thread.sleep(3000);
        LandingPage landingPage = new LandingPage(driver);
        //Assert.assertEquals(landingPage.getTitle().getText(),"Featured Courses");
        Assert.assertTrue(landingPage.getNavigation().isDisplayed());
        logger.info("landing page displayed");

    }
    @AfterTest
    public void closeDriver(){
        driver.close();
    }
}
