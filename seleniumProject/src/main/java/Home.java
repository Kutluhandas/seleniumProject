import org.openqa.selenium.WebDriver;

public class Home {

    WebDriver driver ;

    public Home(WebDriver driver){
        this.driver = driver;
    }

    public void gittigidiyor(){
        driver.get("https://www.gittigidiyor.com/");
    }

}
