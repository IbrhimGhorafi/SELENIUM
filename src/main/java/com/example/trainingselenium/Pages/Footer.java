package com.example.trainingselenium.Pages;

import com.example.trainingselenium.Utils.Locators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

@Slf4j
public class Footer {
    private WebDriver driver;
    private FluentWait<WebDriver> fluentWait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.NEWSLETTER_EMAIL_INPUT)
    private WebElement newsletterEmailInput;

    @FindBy(how = How.XPATH, using = Locators.NEWSLETTER_COUNTRY_DROPDOWN)
    private WebElement newsletterCountry;

    @FindBy(how = How.XPATH, using = Locators.NEWSLETTER_GENERAL_INTEREST)
    private WebElement newsletterGeneralInterest;

    @FindBy(how = How.XPATH, using = Locators.NEWSLETTER_PRODUCT_INTEREST)
    private WebElement newsletterProductInterest;

    @FindBy(how = How.XPATH, using = Locators.NEWSLETTER_SIGNUP_BUTTON)
    private WebElement newsletterSignUpButton;

    public Footer(WebDriver driver) {
        this.driver = driver;
        fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void scrollDownToNewsletterEmailInput() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(newsletterEmailInput));
        actions.scrollToElement(newsletterEmailInput).perform();
//        actions.moveToElement(newsletterEmailInput).click().perform();
//        actions.sendKeys(newsletterEmailInput, email).build().perform();
    }

    public void enterNewsletterEmailInput(String email) {
        fluentWait.until(ExpectedConditions.elementToBeClickable(newsletterEmailInput));
//        actions.scrollToElement(newsletterEmailInput).perform();
        actions.moveToElement(newsletterEmailInput).click().perform();
        actions.sendKeys(newsletterEmailInput, email).build().perform();
    }

    public void selectNewsletterCountryDropdown(String country) {
        Select dropdown = new Select(newsletterCountry);
        dropdown.selectByValue(country);
    }

    public void selectNewsletterGeneralInterest(String fortnumTopic) {
        Select dropdown = new Select(newsletterGeneralInterest);
        dropdown.selectByValue(fortnumTopic);
    }


    public void selectNewsletterProductInterest(String product) {
        Select dropdown = new Select(newsletterProductInterest);
        dropdown.selectByValue(product);
    }


    public void clickNewsletterSignUpButton() {
        fluentWait.until(ExpectedConditions.elementToBeClickable(newsletterSignUpButton));
        actions.moveToElement(newsletterSignUpButton).click().perform();
    }


}
