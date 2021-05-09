import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Product {

    WebDriver driver;

    public Product(WebDriver driver){
        this.driver = driver;
    }

    /* Bu benim rastgele seçtiğim bir ürün */
    By imegeButton = By.xpath("//*[@id='item-info-block-532779150']/p/img");

    public void image(){
        WebElement imageBttn = driver.findElement(imegeButton);
        imageBttn.click();
    }

    By addToBasket = By.xpath("//*[@id='add-to-basket']");

    public void addToBasket(){
        WebElement addToBskt = driver.findElement(addToBasket);
        JavascriptExecutor jsBskt = (JavascriptExecutor) driver;
        jsBskt.executeScript("arguments[0].click();", addToBskt);
    }

    By atBasket = By.xpath("//*[@id='cart-price-container']/div[3]/p");
    By myBasket = By.xpath("//*[@id='header_wrapper']/div[4]/div[3]/div/div/div/div[2]/div[4]/div[1]/a");

    public void setMyBasket(){
        WebElement myBskt = driver.findElement(myBasket);
        myBskt.click();
    }

    public String getPriceAtBasket(){
        WebElement basket = driver.findElement(atBasket);
        return basket.getText();
    }

    By number = By.xpath("//*[@class='amount']");
    By second = By.xpath("//*[@class='amount']/option[2]");

    public void setNumber(){
        WebElement nmbr = driver.findElement(number);
        nmbr.click();
    }

    public void setSecond(){
        WebElement scnd = driver.findElement(second);
        scnd.click();
    }

    By numberControl = By.xpath("//*[@id='submit-cart']/div/div[2]/div[3]/div/div[1]/div/div[5]/div[1]/div/ul/li[1]/div[1]");

    public String getNumberControl(){
        WebElement cntrl = driver.findElement(numberControl);
        return cntrl.getText();
    }

    By deleteButton = By.xpath("//*[@class='gg-icon gg-icon-bin-medium']");

    public void setDeleteButton(){
        WebElement deleteBttn = driver.findElement(deleteButton);
        deleteBttn.click();
    }

    By basketControl = By.xpath("//*[@id='cart-items-container']/h1");

    public String getBasketControl(){
        WebElement basketCntrl = driver.findElement(basketControl);
        return basketCntrl.getText();
    }

}
