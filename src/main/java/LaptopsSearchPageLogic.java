import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LaptopsSearchPageLogic {

    By seller = By.xpath("//li[@class='checkbox-filter__item ng-star-inserted']");
    By maxPriceInput = By.xpath("//input[@formcontrolname='max']");
    By okBtn = By.xpath("//input[@formcontrolname='max']/../button");
    By firstPromotionProduct = By.xpath("//span[contains(@class, 'promo-label_type_action')]/..");


    private WebDriver driver;
    private WebDriverWait wait;

    public LaptopsSearchPageLogic(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public LaptopsSearchPageLogic selectSeller() {
        driver.findElement(seller).click();
        return this;
    }

    public LaptopsSearchPageLogic maxPriceInputClear() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((maxPriceInput))).clear();
        return this;
    }

    public LaptopsSearchPageLogic typeMaxPriceToInputPrice(String price) {
        driver.findElement(maxPriceInput).sendKeys(price);
        return this;
    }

    public LaptopsSearchPageLogic okBtnClick() {
        driver.findElement(okBtn).click();
        return this;
    }

    public ProductPageLogic firstPromotionProductClick() {
        WebElement firstPromotionElement = wait.until(ExpectedConditions.elementToBeClickable(firstPromotionProduct));
        firstPromotionElement.click();
        return new ProductPageLogic(driver, wait);
    }
}
