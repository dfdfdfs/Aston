package org.example;

import io.qameta.allure.*;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.List;

@ExtendWith(AllureJunit5.class)
@Epic("MTS.BY Tests")
@Feature("Payment Functionality")
public class MtsByTests {

    private WebDriver driver;
    private WebDriverWait wait;
    private final String BASE_URL = "https://www.mts.by/";
    private final String PHONE_NUMBER = "297777777"; // Используем String для номера телефона
    private MtsPage mtsPage; // Объявляем объект PageObject

    @BeforeEach
    @Step("Setup driver and navigate to MTS.BY")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(BASE_URL);
        mtsPage = new MtsPage(driver, wait); // Инициализируем PageObject
    }

    @AfterEach
    @Step("Teardown driver")
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Check the title of the 'Online Top-up without commission' block")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the title of the online top-up block is correct.")
    public void checkBlockTitle() {
        Allure.step("Assert that the block title is correct");
        Assertions.assertEquals("Онлайн-пополнение без комиссии", mtsPage.getBlockTitleText(), "Title is incorrect");
    }

    @Test
    @DisplayName("Check the presence of payment system logos")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that payment system logos are present on the page.")
    public void checkPaymentSystemLogos() {
        Allure.step("Get payment system logos");
        List<WebElement> logoElements = mtsPage.getPaymentSystemLogos();
        Allure.step("Assert that logos are present");
        Assertions.assertTrue(logoElements.size() > 0, "No payment system logos found");
        for (WebElement logo : logoElements) {
            Allure.step("Assert that each logo source is not empty");
            Assertions.assertFalse(logo.getAttribute("src").isEmpty(), "Logo source is empty");
        }
    }

    @Test
    @DisplayName("Check the 'More about the service' link functionality")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify that the 'More about the service' link opens a new tab with correct URL.")
    public void checkMoreAboutServiceLink() {
        String originalWindow = driver.getWindowHandle();
        Allure.step("Click on 'More about the service' link");
        mtsPage.clickMoreAboutServiceLink();

        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Allure.step("Assert that the URL of the new page is correct");
        Assertions.assertTrue(driver.getCurrentUrl().contains("mts.by"), "The URL of new page is wrong");
        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Test
    @DisplayName("Check empty fields labels")
    @Severity(SeverityLevel.NORMAL)
    @Description("Verify the labels for empty fields in the payment form.")
    public void checkEmptyFieldsLabels() {
        Allure.step("Assert that the labels for empty fields are correct");
        Assertions.assertEquals("Номер телефона", mtsPage.getEmptyServicesPhoneLabel(), "Services Phone label is incorrect");
        Assertions.assertEquals("Лицевой счёт", mtsPage.getEmptyHomeInternetAccountLabel(), "Home Internet account label is incorrect");
        Assertions.assertEquals("Номер договора", mtsPage.getEmptyInstallmentAgreementLabel(), "Installment agreement label is incorrect");
        Assertions.assertEquals("Номер телефона", mtsPage.getEmptyDebtPhoneLabel(), "Debt Phone label is incorrect");
    }

    @Test
    @DisplayName("Check the 'Continue' button functionality with valid data")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the 'Continue' button redirects to the next page with valid data entered.")
    public void checkContinueButton() {
        // 1. Select "Mobile Services" (Услуги связи)
        Allure.step("Select 'Mobile Services'");
        mtsPage.selectMobileServices();

        // 2. Enter phone number
        Allure.step("Enter phone number: " + PHONE_NUMBER);
        mtsPage.enterPhoneNumber(PHONE_NUMBER);

        // 3. Click "Continue" button
        Allure.step("Click 'Continue' button");
        mtsPage.clickContinueButton();

        // 4. Verify that you are redirected to the next page (check URL or element on the next page)
        wait.until(ExpectedConditions.urlContains("pay.mts.by/web/guest/payment/phone"));
        String currentUrl = driver.getCurrentUrl();
        Allure.step("Assert that redirection to the next page was successful");
        Assertions.assertTrue(currentUrl.contains("pay.mts.by/web/guest/payment/phone"), "Redirection to the next page failed. URL: " + currentUrl);

        // Verify elements on the confirmation page
        Allure.step("Verify elements on the confirmation page");
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
        takeScreenshot();
    }

    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] takeScreenshot() {
        try {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        } catch (WebDriverException e) {
            System.err.println("Exception while taking screenshot: " + e.getMessage());
            return null;
        }
    }
}