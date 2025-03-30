package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MtsByTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "http://mts.by";
    private final String PHONE_NUMBER = "297777777";


@BeforeEach
public void setup() {
    WebDriverManager.chromedriver().setup(); 
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    driver.manage().window().maximize();
    driver.get(BASE_URL);
}

    @AfterEach
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Check the title of the 'Online Top-up without commission' block")
    public void checkBlockTitle() {
        WebElement titleElement = driver.findElement(By.xpath("//h2[contains(text(),'Онлайн-пополнение')]"));
        Assertions.assertEquals("Онлайн-пополнение без комиссии", titleElement.getText(), "Title is incorrect");
    }

    @Test
    @DisplayName("Check the presence of payment system logos")
    public void checkPaymentSystemLogos() {
        List<WebElement> logoElements = driver.findElements(By.xpath("//div[@class='widget__payment-systems']//img")); 
        Assertions.assertTrue(logoElements.size() > 0, "No payment system logos found");

        
        for (WebElement logo : logoElements) {
            Assertions.assertFalse(logo.getAttribute("src").isEmpty(), "Logo source is empty");
        }
    }

    @Test
    @DisplayName("Check the 'More about the service' link functionality")
    public void checkMoreAboutServiceLink() {
        WebElement linkElement = driver.findElement(By.linkText("Подробнее о сервисе")); 
        String originalWindow = driver.getWindowHandle();
        linkElement.click();
        wait.until(ExpectedConditions.numberOfWindowsToBe(2)); 
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

       
        Assertions.assertTrue(driver.getCurrentUrl().contains("oplata.mts.by"), "The URL of new page is wrong"); //Verify URL
        driver.close();
        driver.switchTo().window(originalWindow); 
    }

    @Test
    @DisplayName("Check the 'Continue' button functionality with valid data")
    public void checkContinueButton() {
        // 1. Select "Mobile Services" (Услуги связи)
        WebElement serviceTypeDropdown = driver.findElement(By.xpath("//div[@class='widget__form']//select"));
        serviceTypeDropdown.click();
        WebElement mobileServicesOption = driver.findElement(By.xpath("//div[@class='widget__form']//select/option[text()='Услуги связи']"));
        mobileServicesOption.click();


        // 2. Enter phone number
        WebElement phoneNumberInput = driver.findElement(By.name("accountNumber"));
        phoneNumberInput.sendKeys(PHONE_NUMBER);

        // 3. Click "Continue" button
        WebElement continueButton = driver.findElement(By.xpath("//button[text()='Продолжить']"));
        continueButton.click();

        // 4. Verify that you are redirected to the next page (check URL or element on the next page)

        wait.until(ExpectedConditions.urlContains("pay.mts.by/web/guest/payment/phone"));
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("pay.mts.by/web/guest/payment/phone"), "Redirection to the next page failed. URL: " + currentUrl);

        
         WebElement amountInput = driver.findElement(By.id("amount"));
         Assertions.assertNotNull(amountInput, "Amount input field not found on the next page.");
    }
}
