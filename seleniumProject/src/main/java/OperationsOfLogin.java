import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class OperationsOfLogin {

    private String email ;
    private String password ;
    WebDriver driver ;

    public OperationsOfLogin(WebDriver driver){
        this.driver = driver;
    }

    By singInButton = By.xpath("//*[@id='main-header']/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]");
    By secondSingInButton = By.cssSelector("a[data-cy='header-login-button']");

    public void setSecondSingInButton(){
        Actions action = new Actions(driver);
        WebElement singIn = driver.findElement(singInButton);
        action.moveToElement(singIn).perform();
        driver.manage().timeouts().implicitlyWait(900, TimeUnit.MILLISECONDS);
        WebElement secondsingIn = driver.findElement(secondSingInButton);
        secondsingIn.click();
    }

    By emailAdress = By.id("L-UserNameField");
    By passwordOnSite = By.id("L-PasswordField");
    By lastSingInButton = By.id("gg-login-enter");

    public void setEmail(String email){
        this.email = email;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void logIn(){
        driver.findElement(emailAdress).sendKeys(email);
        driver.findElement(passwordOnSite).sendKeys(password);
        WebElement logIn = driver.findElement(lastSingInButton);
        logIn.click();
    }

    By username = By.xpath("//*[@id='main-header']/div[3]/div/div/div[1]/div[3]/div/div[1]/div/div[2]/span");

    public String control() {
        WebElement userNameControl = driver.findElement(username);
        return userNameControl.getText();
    }

}
