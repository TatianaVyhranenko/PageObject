import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class AutomationTest {

//    Перейти на https://rozetka.com.ua/
//    В сайд меню перейти в раздел Ноутбуки и компьютеры
//    Перейти в категорию Ноутбуки
//    Примерить фильтр "Продавец" Rozetka
//    Примерить фильтр "Цена" установть цену до - 100000
//    Перейти на продуктовую первого товара с плашкой "Акция"
//    Проверить что на продуктовой странице отображается плашка "Акция"

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void beforeTest() {
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://rozetka.com.ua/");
    }

    @Test

//    1. Перейти на https://rozetka.com.ua/
//    2. В сайд меню перейти в раздел Ноутбуки и компьютеры
//    3. Перейти в категорию Ноутбуки
//    4. Примерить фильтр "Продавец" Rozetka
//    5. Примерить фильтр "Цена" установть цену до - 100000
//    6. Перейти на продуктовую первого товара с плашкой "Акция"
//    7. Проверить что на продуктовой странице отображается плашка "Акция"

    public void testRozetka() throws InterruptedException {
        ProductPageLogic productPageLogic = new MainPageLogic(driver, wait)
                .laptopsAndComputersClick()
                .laptopsClick()
                .selectSeller()
                .maxPriceInputClear()
                .typeMaxPriceToInputPrice("10000")
                .okBtnClick()
                .firstPromotionProductClick();

        WebElement label = productPageLogic.FoundProductLabel();
        Assert.assertTrue(label.isDisplayed());
    }

    @AfterMethod
    public void afterTest() {
        driver.quit();
    }


}
