package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;


////i[@class='fa fa-lock fa-lg']//following::span
//a[href*='sign_in']
    By signIn=By.cssSelector("a[href*='sign_in']");
    By title = By.xpath("//div[@class='container']//div[@class='text-center']");
    By navigation = By.cssSelector("nav.navbar-collapse.collapse");


    public LandingPage(WebDriver driver) {
        this.driver= driver;
    }

    public WebElement getLogin(){
        return driver.findElement(signIn);
    }
    public WebElement getTitle(){
        return driver.findElement(title);
    }
    public WebElement getNavigation(){
        return driver.findElement(navigation);
    }

}
