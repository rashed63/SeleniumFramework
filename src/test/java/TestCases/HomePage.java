package TestCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.BaseProject;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePage extends BaseProject  {
    public WebDriver driver;
    public static Logger logger = LogManager.getLogger(HomePage.class.getName());
   /* @BeforeTest
    public void intialize3() throws IOException, InterruptedException {

        //driver.get(prop.getProperty("Url"));(doesnt work here if u use multiple data by using data provider
        //if i put getProperty in this method loginPage will only run for one time with the pass and userId
        //coz inside the basePageNavigation it doesnt have the get property for the second time
        Thread.sleep(3000);
    }*/
    @Test(dataProvider ="getData")
    public void basePageNavigation(String userName, String password, String text) throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("Url"));
        LandingPage landingPage = new LandingPage(driver);

        landingPage.getLogin().click();
        LoginPage lp = new LoginPage(driver);
        logger.info("LoginPage Initiated");
        lp.getEmail().sendKeys(userName);
        lp.getPassword().sendKeys(password);
        lp.submitLogin().click();
        logger.info("Clicked on to login Button");
        System.out.println(text);
        driver.close();

        }
        @DataProvider
        public Object[][] getData(){
        Object [][] data = new Object [2][3];
        data[0][0]="nonrestricteduser@gmail.com";
        data[0][1]="45678";
        data[0][2]="nonrestricteduser";
        data[1][0]="restricteduser@gmail.com";
        data[1][1]="123456";
        data[1][2]="restricteduser";
        return data;

        }
        /*@AfterTest
        public void closeDriver(){
        driver.close();
        }*/

    }

