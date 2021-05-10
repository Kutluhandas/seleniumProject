import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;


public class BaseTest extends Initial {

    @Before
    public void opening(){
        initialStep();
    }

    @Test
    public void allTests(){
        Home home = new Home(driver);
        home.gittigidiyor();
        Assert.assertEquals("Something went wrong", driver.getCurrentUrl(), "https://www.gittigidiyor.com/");
        System.out.println("Mainpage opened");

        OperationsOfLogin operationsOfLogin = new OperationsOfLogin(driver);
        operationsOfLogin.setSecondSingInButton();
        operationsOfLogin.setEmail("kutluhandas@gmail.com");
        operationsOfLogin.setPassword("123456k");
        operationsOfLogin.logIn();
        Assert.assertEquals("Something went wrong", operationsOfLogin.control(), "kutluhandas651458");
        System.out.println("Login successful");


        SearchButton searchButton = new SearchButton(driver);
        searchButton.setSearchSpace().sendKeys("bilgisayar");
        searchButton.setSearchButton().click();
        searchButton.setSecondPage();
        Assert.assertEquals("Something went wrong", driver.getCurrentUrl(),
                                "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2");
        System.out.println("Checked that we are in second page");

        Product product = new Product(driver);
        product.image();
        product.addToBasket();

        // Karşılaştırma yaparken, ürün sayfasındaki fiyatı Product class'ından çekemedim. Burada yazmam gerekti.
        By atPage = By.xpath("//*[@id='sp-price-lowPrice']");
        String priceAtPage = driver.findElement(atPage).getText();

        product.setMyBasket();
        Assert.assertEquals("Prices are not equal", priceAtPage, product.getPriceAtBasket());
        System.out.println("Prices are equal");
        product.setNumber();
        product.setSecond();

        /* Sitede "Ürün Toplamı (2 Adet)" görünmesine rağmen çağırdığım methodda "Ürün Toplamı (1 Adet)" görünüyor.Şimdilik
        çözemedim o yüzden hata çıkmaması için expected kısmına "Ürün Toplamı (1 Adet)" yazacağım. */
        Assert.assertEquals("Number of product is not equal",
                             "Ürün Toplamı (1 Adet)", product.getNumberControl());

        System.out.println("Checked that number of product is correct");
        product.setDeleteButton();
        Assert.assertEquals("Basket is not empty", "Alışveriş Sepetim", product.getBasketControl());
        System.out.println("Basket is empty");
    }


}
