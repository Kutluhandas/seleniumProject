import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchButton {

    WebDriver driver;

    public SearchButton(WebDriver driver){
        this.driver = driver;
    }

    By searchSpace = By.xpath("//*[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[1]/div[2]/input");
    By searchButton = By.xpath("//*[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[2]/button");
    By secondPage = By.xpath("//*[@id='best-match-right']/div[5]/ul/li[2]/a");

    public WebElement setSearchSpace(){
        return driver.findElement (searchSpace);
    }

    public WebElement setSearchButton(){
        return driver.findElement (searchButton);
    }

    public void setSecondPage(){
        WebElement secondPages = driver.findElement(secondPage);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", secondPages);
    }

}
