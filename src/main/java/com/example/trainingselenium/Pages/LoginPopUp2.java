package com.example.trainingselenium.Pages;

import com.example.trainingselenium.Utils.Locators;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

@Slf4j
public class LoginPopUp2 {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;
    private String setNewPasswordLink;


    @FindBy(how = How.XPATH, using = Locators.FORGOTTEN_THE_PASSWORD_LINK)
    private WebElement forgottenThePasswordLink;

    @FindBy(how = How.XPATH, using = Locators.RESET_PASSWORD_EMAIL_INPUT)
    private WebElement emailAddressInput;

    @FindBy(how = How.XPATH, using = Locators.RESET_PASSWORD_BUTTON)
    private WebElement resetPasswordButton;

    @FindBy(how = How.XPATH, using = Locators.YOPMAIL_EMAIL_INPUT)
    private WebElement yopmailEmailInput;

    @FindBy(how = How.XPATH, using = Locators.YOPMAIL_EMAIL_BUTTON)
    private WebElement yopmailLoginButton;

    @FindBy(how = How.XPATH, using = Locators.YOPMAIL_SET_NEW_PASSWORD_LINK)
    private WebElement yopmailSetNewPasswordLink;

    @FindBy(how = How.XPATH, using = Locators.NEW_PASSWORD_INPUT)
    private WebElement newPasswordInput;

    @FindBy(how = How.XPATH, using = Locators.CONFIRM_NEW_PASSWORD_INPUT)
    private WebElement confirmNewPasswordInput;

    @FindBy(how = How.XPATH, using = Locators.SAVE_NEW_PASSWORD_BUTTON)
    private WebElement saveNewPasswordButton;

    @FindBy(how = How.ID, id = "refresh")
    private WebElement yopmailRefreshButton;

    @FindBy(how = How.ID, id = "toast-ok-button")
    private WebElement popupOkButton;

    @FindBy(how = How.XPATH, using = Locators.EMAIL_LOGING_INPUT)
    private WebElement emailLoginInput;

    @FindBy(how = How.XPATH, using = Locators.PASSWORD_LOGIN_INPUT)
    private WebElement passwordLoginInput;

    @FindBy(how = How.XPATH, using = Locators.LOGIN_BUTTON)
    private WebElement loginButton;

    public LoginPopUp2(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void clickForgottenThePasswordLink() {
        wait.until(ExpectedConditions.elementToBeClickable(forgottenThePasswordLink));
        actions.moveToElement(forgottenThePasswordLink).click().perform();
    }

    public void enterEmailAddress(String emailAddress) {
        wait.until(ExpectedConditions.visibilityOf(emailAddressInput));
        actions.moveToElement(emailAddressInput).click().sendKeys(emailAddress).perform();
    }

    public void clickResetPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordButton));
        actions.moveToElement(resetPasswordButton).click().perform();
    }

    public void navigateToYopmail() {
        driver.navigate().to("https://yopmail.com/");
    }

    public void loginToYopmail(String emailAddress){
        wait.until(ExpectedConditions.visibilityOf(yopmailEmailInput));
        actions.moveToElement(yopmailEmailInput).sendKeys(emailAddress).sendKeys(Keys.ENTER).perform();
    }

    public void checkingTheLastEmail (){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wait.until(ExpectedConditions.elementToBeClickable(yopmailRefreshButton));
        actions.moveToElement(yopmailRefreshButton).click().perform();
        driver.switchTo().frame("ifmail");
        wait.until(ExpectedConditions.elementToBeClickable(yopmailSetNewPasswordLink));
        setNewPasswordLink = yopmailSetNewPasswordLink.getAttribute("href");
    }

    public void changeThePassword(String newPassword) {
        driver.navigate().to(setNewPasswordLink);
        wait.until(ExpectedConditions.elementToBeClickable(newPasswordInput));
        actions.moveToElement(newPasswordInput).click().sendKeys(newPassword).perform();
        wait.until(ExpectedConditions.elementToBeClickable(confirmNewPasswordInput));
        actions.moveToElement(confirmNewPasswordInput).click().sendKeys(newPassword).perform();
        wait.until(ExpectedConditions.elementToBeClickable(saveNewPasswordButton));
        actions.moveToElement(saveNewPasswordButton).click().perform();
    }

    public void clickOKButton() {
        wait.until(ExpectedConditions.elementToBeClickable(popupOkButton));
        actions.moveToElement(popupOkButton).click().perform();
    }

    public void enterEmail(String email) {

        wait.until(ExpectedConditions.elementToBeClickable(emailLoginInput));
//        emailLoginInput.sendKeys(email);
        actions.moveToElement(emailLoginInput).perform();
        actions.click(emailLoginInput).perform();
        actions.sendKeys(emailLoginInput, email).perform();
        log.info(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordLoginInput));
        actions.moveToElement(passwordLoginInput).click().sendKeys(password).perform();
    }

    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        actions.moveToElement(loginButton).click().perform();
    }


}
