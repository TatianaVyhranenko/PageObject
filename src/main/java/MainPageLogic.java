import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageLogic {

    By laptopsAndComputers = By.xpath("//ul[@class='menu-categories menu-categories_type_main']/li[1]");

    private WebDriver driver;
    private WebDriverWait wait;

    public MainPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public ComputersAndLaptopsPageLogic laptopsAndComputersClick() {
        driver.findElement(laptopsAndComputers).click();
        return new ComputersAndLaptopsPageLogic(driver, wait);
    }
}
