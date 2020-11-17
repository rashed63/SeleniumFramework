package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebDriver driver;





    By email = By.xpath("//input[@type='email']");
    By password = By.cssSelector("input[type='password']");
    By logIn = By.cssSelector("input[type='submit']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getEmail(){
        return driver.findElement(email);
    }
    public WebElement getPassword(){
        return driver.findElement(password);
    }
    public WebElement submitLogin(){
        return driver.findElement(logIn);
    }
}
