package networkTest;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class networkTest1 {
    protected static WebDriver driver;
    protected final static String CHROME_PATH = "drivers/chromedriver.exe";
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver",CHROME_PATH);
        driver = new ChromeDriver();

        driver.get("https://www.network.com.tr/");
        driver.manage().window().maximize();

        WebElement acceptCookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        acceptCookies.click();

        WebElement searchElement = driver.findElement(By.id("search"));
        searchElement.click();
        /*string*/
        searchElement.sendKeys("ceket", Keys.ENTER);

        String URL = driver.getCurrentUrl();

        WebElement seeMore = driver.findElement(new By.ByCssSelector(".button.-secondary.-sm.relative"));
        /* Scroll Down */
        seeMore.sendKeys(Keys.CONTROL, Keys.END, Keys.ENTER);

        String changedURL = "https://www.network.com.tr/search?searchKey=ceket&page=2";
        if(URL.equals(changedURL)) {
            System.out.println("Same URL!");
        }else{
            System.out.println("URL Changed!");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/div[@data-page='2']")));


        Actions actions = new Actions(driver);
        WebElement hoverOver = driver.findElement(By.xpath("//div/div[@data-product-id='133583']"));
        actions.moveToElement(hoverOver).perform();

        WebElement chooseSize = driver.findElement(By.xpath("//*[@id='product-133583']/div/div[1]/div/div/div/div[4]/label"));
        chooseSize.click();
    }
}


