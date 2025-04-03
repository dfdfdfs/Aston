package org.example;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class MtsByTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "http://mts.by";
    private final String PHONE_NUMBER = "297777777"; // Используем String для номера телефона
    private MtsPage mtsPage; // Объявляем объект PageObject

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        mtsPage = new MtsPage(driver, wait); // Инициализируем PageObject
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
        Assertions.assertEquals("Онлайн-пополнение без комиссии", mtsPage.getBlockTitleText(), "Title is incorrect");
    }

    @Test
    @DisplayName("Check the presence of payment system logos")
    public void checkPaymentSystemLogos() {
        List<WebElement> logoElements = mtsPage.getPaymentSystemLogos();
        Assertions.assertTrue(logoElements.size() > 0, "No payment system logos found");
        for (WebElement logo : logoElements) {
            Assertions.assertFalse(logo.getAttribute("src").isEmpty(), "Logo source is empty");
        }
    }

    @Test
    @DisplayName("Check the 'More about the service' link functionality")
    public void checkMoreAboutServiceLink() {
        String originalWindow = driver.getWindowHandle();
        mtsPage.clickMoreAboutServiceLink();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Assertions.assertTrue(driver.getCurrentUrl().contains("mts.by"), "The URL of new page is wrong");
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Test
    @DisplayName("Check empty fields labels")
    public void checkEmptyFieldsLabels() {
        Assertions.assertEquals("Номер телефона", mtsPage.getEmptyServicesPhoneLabel(), "Services Phone label is incorrect");
        Assertions.assertEquals("Лицевой счёт", mtsPage.getEmptyHomeInternetAccountLabel(), "Home Internet account label is incorrect");
        Assertions.assertEquals("Номер договора", mtsPage.getEmptyInstallmentAgreementLabel(), "Installment agreement label is incorrect");
        Assertions.assertEquals("Номер телефона", mtsPage.getEmptyDebtPhoneLabel(), "Debt Phone label is incorrect");
    }

    @Test
    @DisplayName("Check the 'Continue' button functionality with valid data")
    public void checkContinueButton() {
        // 1. Select "Mobile Services" (Услуги связи)
        mtsPage.selectMobileServices();

        // 2. Enter phone number
        mtsPage.enterPhoneNumber(PHONE_NUMBER);

        // 3. Click "Continue" button
        mtsPage.clickContinueButton();

        // 4. Verify that you are redirected to the next page (check URL or element on the next page)
        wait.until(ExpectedConditions.urlContains("pay.mts.by/web/guest/payment/phone"));
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertTrue(currentUrl.contains("pay.mts.by/web/guest/payment/phone"), "Redirection to the next page failed. URL: " + currentUrl);

        // Verify elements on the confirmation page
        Assertions.assertNotNull(mtsPage.getAmountInput(), "Amount input field not found on the next page.");
        Assertions.assertTrue(mtsPage.getConfirmationAmountButtonText().contains("Продолжить"), "Button text doesn't contain 'Продолжить'");
        Assertions.assertTrue(mtsPage.getConfirmationAmountButtonText().contains(PHONE_NUMBER), "Phone number not found on the button");
        Assertions.assertNotNull(mtsPage.getCardNumberInput(), "Card Number Input Field not found");
        Assertions.assertNotNull(mtsPage.getCardExpirationDateInput(), "Card Expiration Date Input Field not found");
        Assertions.assertNotNull(mtsPage.getCardCVVInput(), "Card CVV Input Field not found");
        Assertions.assertTrue(mtsPage.getPaymentSystemLogosConfirmation().size() > 0, "Payment system logos are not displayed");
        Assertions.assertEquals("Номер карты", mtsPage.getEmptyCardNumberLabel(), "Card Number label is incorrect");
        Assertions.assertEquals("Срок действия", mtsPage.getEmptyCardExpiryLabel(), "Expiry date label is incorrect");
        Assertions.assertEquals("CVV/CVC", mtsPage.getEmptyCardCVVLabel(), "CVV/CVC label is incorrect");
    }
}