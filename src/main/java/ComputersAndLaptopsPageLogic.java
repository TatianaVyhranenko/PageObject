import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ComputersAndLaptopsPageLogic {

    By laptops = By.xpath("//div[@class='tile-cats']");

    private WebDriver driver;
    private WebDriverWait wait;

    public ComputersAndLaptopsPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LaptopsSearchPageLogic laptopsClick() {
        driver.findElement(laptops).click();
        return new LaptopsSearchPageLogic(driver, wait);
    }
}
