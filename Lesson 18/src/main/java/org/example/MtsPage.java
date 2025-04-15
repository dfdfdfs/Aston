package org.example;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MtsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    //Locators
    private By blockTitle = By.xpath("//h2[contains(text(),'Онлайн-пополнение')]");
    private By paymentSystemLogos = By.xpath("//div[@class='widget_payment-systems']/img");
    private By moreAboutServiceLink = By.linkText("Подробнее о сервисе");
    private By serviceTypeDropdown = By.xpath("//div[@class='widget__form']/select");
    private By mobileServicesOption = By.xpath("//div[@class='widget__form']/select/option[text()='Услуги связи']");
    private By homeInternetOption = By.xpath("//div[@class='widget__form']/select/option[text()='Домашний интернет']");
    private By installmentOption = By.xpath("//div[@class='widget__form']/select/option[text()='Рассрочка']");
    private By debtOption = By.xpath("//div[@class='widget__form']/select/option[text()='Задолженность']");
    private By phoneNumberInput = By.name("accountNumber");
    private By homeInternetAccountInput = By.name("accountNumber");
    private By installmentAgreementInput = By.name("accountNumber");
    private By debtPhoneNumberInput = By.name("accountNumber");
    private By continueButton = By.xpath("//button[text()='Продолжить']");
    private By amountInput = By.id("amount");
    private By cardNumberInput = By.id("pan");
    private By cardExpirationDateInput = By.id("expiry");
    private By cardCVVInput = By.id("cvv");
    private By confirmationAmountButton = By.xpath("//button[@class='button button_primary button_large']");

    //Labels for Empty Fields
    private By emptyServicesPhoneLabel = By.xpath("//div[@class='widget__form']//label[text()='Номер телефона']");
    private By emptyHomeInternetAccountLabel = By.xpath("//div[@class='widget__form']//label[text()='Лицевой счёт']");
    private By emptyInstallmentAgreementLabel = By.xpath("//div[@class='widget__form']//label[text()='Номер договора']");
    private By emptyDebtPhoneLabel = By.xpath("//div[@class='widget__form']//label[text()='Номер телефона']");
    private By emptyCardNumberLabel = By.xpath("//label[@for='pan']");
    private By emptyCardExpiryLabel = By.xpath("//label[@for='expiry']");
    private By emptyCardCVVLabel = By.xpath("//label[@for='cvv']");
    private By paymentSystemLogosConfirmation = By.xpath("//div[@class='payment-form__methods']/div/img");

    public MtsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    //Getters for elements
    public WebElement getBlockTitle() {
        return driver.findElement(blockTitle);
    }

    public String getBlockTitleText() {
        return getBlockTitle().getText();
    }

    public List<WebElement> getPaymentSystemLogos() {
        return driver.findElements(paymentSystemLogos);
    }

    public WebElement getMoreAboutServiceLink() {
        return driver.findElement(moreAboutServiceLink);
    }

    public void clickMoreAboutServiceLink() {
        getMoreAboutServiceLink().click();
    }

    public WebElement getServiceTypeDropdown() {
        return driver.findElement(serviceTypeDropdown);
    }

    public void selectMobileServices() {
        driver.findElement(serviceTypeDropdown).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileServicesOption));
        driver.findElement(mobileServicesOption).click();
    }

    public WebElement getPhoneNumberInput() {
        return driver.findElement(phoneNumberInput);
    }

    public void enterPhoneNumber(String phoneNumber) {
        getPhoneNumberInput().sendKeys(phoneNumber);
    }

    public WebElement getContinueButton() {
        return driver.findElement(continueButton);
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public WebElement getAmountInput() {
        return driver.findElement(amountInput);
    }

    public WebElement getCardNumberInput() { return driver.findElement(cardNumberInput); }

    public WebElement getCardExpirationDateInput() { return driver.findElement(cardExpirationDateInput); }

    public WebElement getCardCVVInput() { return driver.findElement(cardCVVInput); }

    public WebElement getConfirmationAmountButton() { return driver.findElement(confirmationAmountButton); }

    public String getConfirmationAmountButtonText() { return getConfirmationAmountButton().getText(); }

    public String getEmptyServicesPhoneLabel() {
        return driver.findElement(emptyServicesPhoneLabel).getText();
    }

    public String getEmptyHomeInternetAccountLabel() {
        return driver.findElement(emptyHomeInternetAccountLabel).getText();
    }

    public String getEmptyInstallmentAgreementLabel() {
        return driver.findElement(emptyInstallmentAgreementLabel).getText();
    }

    public String getEmptyDebtPhoneLabel() {
        return driver.findElement(emptyDebtPhoneLabel).getText();
    }

    public String getEmptyCardNumberLabel() { return driver.findElement(emptyCardNumberLabel).getText(); }

    public String getEmptyCardExpiryLabel() { return driver.findElement(emptyCardExpiryLabel).getText(); }

    public String getEmptyCardCVVLabel() { return driver.findElement(emptyCardCVVLabel).getText(); }

    public List<WebElement> getPaymentSystemLogosConfirmation() {
        return driver.findElements(paymentSystemLogosConfirmation);
    }

}