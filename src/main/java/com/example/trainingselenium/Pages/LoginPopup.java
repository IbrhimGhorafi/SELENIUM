package com.example.trainingselenium.Pages;

import com.example.trainingselenium.Utils.Locators;
import dev.failsafe.internal.util.Assert;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;
@Slf4j
public class LoginPopup {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.FORGET_PASSWORD_LINK)
    private WebElement forgotPasswordLink;

    @FindBy(how = How.XPATH, using = Locators.EMAIL_RESET_PASSWORD_INPUT)
    private WebElement emailResetPasswordInput;

    @FindBy(how = How.XPATH, using = Locators.RESET_PASSWORD_BUTTON)
    private WebElement resetPasswordButton;

//    @FindBy(how = How.XPATH, using = Locators.EMAIL_LOGIN_INPUT)
//    private WebElement emailLoginInput;

//    @FindBy(how = How.XPATH, using = Locators.PASSWORD_LOGIN_INPUT)
//    private WebElement passwordLoginInput;

//    @FindBy(how = How.XPATH, using = Locators.LOGIN_BUTTON)
//    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = Locators.SUCCESS_LOGGED_MESSAGE_POPUP)
    private WebElement messageSuccessLoggedIn;

    @FindBy(how = How.XPATH, using = Locators.MESSAGE_RECEIVED_EMAIL_INSTRUCTION_RESET_PASSWORD)
    private WebElement messageReceivedEmail;

    @FindBy(how = How.XPATH,using = Locators.BACK_TO_LOGIN_BUTTON)
    private WebElement backToLoginButton;

    @FindBy(how = How.XPATH, using = Locators.EMAIL_LOGING_INPUT)
    private WebElement emailLoginInput;

    @FindBy(how = How.XPATH, using = Locators.PASSWORD_LOGIN_INPUT)
    private WebElement passwordLoginInput;

    @FindBy(how = How.XPATH, using = Locators.LOGIN_BUTTON)
    private WebElement loginButton;

    @FindBy(how = How.XPATH, using = Locators.POST_LOGIN_POPUP_OK_BUTTON)
    private WebElement postLoginPopupOkButton;

    public LoginPopup(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void clickOnForgetPasswordLink() {
        wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
        actions.moveToElement(forgotPasswordLink).click().perform();
    }

    public void enterEmailForResetPasswordInput(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailResetPasswordInput));
        actions.moveToElement(emailResetPasswordInput).click().perform();
        actions.sendKeys(emailResetPasswordInput, email).build().perform();
    }

    public void clickOnResetPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(resetPasswordButton));
        actions.moveToElement(resetPasswordButton).click().perform();
    }

    public void enterEmailLoginInput(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(emailLoginInput));
        actions.moveToElement(emailLoginInput).click().perform();
        actions.sendKeys(emailLoginInput, email).build().perform();
    }

    public void enterPasswordLoginInput(String password) {
        wait.until(ExpectedConditions.elementToBeClickable(passwordLoginInput));
        actions.moveToElement(passwordLoginInput).click().perform();
        actions.sendKeys(passwordLoginInput, password).build().perform();
    }

    public void clickOnLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        actions.moveToElement(loginButton).click().perform();
    }

    public void clickOnOkPopupButton() {
        wait.until(ExpectedConditions.elementToBeClickable(postLoginPopupOkButton));
        actions.moveToElement(postLoginPopupOkButton).click().perform();
    }

//    public void enterEmailLoginInput(String email) {
//        log.info("enterEmailLoginInput : {}",email);
//        wait.until(ExpectedConditions.elementToBeClickable(emailLoginInput));
//        actions.moveToElement(emailLoginInput).click().perform();
//        actions.sendKeys(emailLoginInput, email).build().perform();
//    }
//
//    public void enterPasswordLoginInput(String password) {
//        wait.until(ExpectedConditions.elementToBeClickable(passwordLoginInput));
//        actions.moveToElement(passwordLoginInput).click().perform();
//        actions.sendKeys(passwordLoginInput, password).build().perform();
//    }
//
//    public void clickOnLoginButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//        actions.moveToElement(loginButton).click().perform();
//    }

    public String getMessageSuccessLoggedIn() {
        return messageSuccessLoggedIn.getText();
    }
    public String getMessageReceivedEmail() {
        return messageReceivedEmail.getText();
    }
    public void clickOnBackToLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(backToLoginButton));
        actions.moveToElement(backToLoginButton).click().perform();
    }

}
