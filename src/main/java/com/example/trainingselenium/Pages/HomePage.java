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

import java.time.Duration;

@Slf4j
public class HomePage {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.SUBSCRIPTION_EMAIL_INPUT)
    private WebElement subscriptionEmailInput;

    @FindBy(how = How.XPATH, using = Locators.SELECT_COUNTRY)
    private WebElement selectCountry;

    @FindBy(how = How.XPATH, using = Locators.SELECT_GENERAL_INTEREST)
    private WebElement selectGeneralInterest;

    @FindBy(how = How.XPATH, using = Locators.SELECT_PRODUCT_INTEREST)
    private WebElement selectProductInterest;

    @FindBy(how = How.XPATH, using = Locators.SUBSCRIBE_BUTTON)
    private WebElement subscribeButton;

    @FindBy(how = How.XPATH, using = Locators.SELECT_COUNTRY_CURRENCY_SHOPPING)
    private WebElement changeDestination;

    @FindBy(how = How.XPATH, using = Locators.POPUP_MESSAGE_SUCCESS_OF_SUBSCRIBE)
    private WebElement messageSuccessSubscribe;

    @FindBy(how = How.XPATH, using = Locators.ICON_PERSON_IN_HEADER)
    private WebElement iconPerson;

    @FindBy(how = How.XPATH, using = Locators.LINK_DETAILS_USER_PAGE)
    private WebElement linkDetails;

    @FindBy(how = How.XPATH, using = Locators.ICON_SEARCH_IN_HEADER)
    private WebElement iconSearch;

    @FindBy(how = How.XPATH, using = Locators.SEARCH_INPUT)
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = Locators.SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(how = How.XPATH, using = Locators.SEARCH_RESULT_TEXT)
    private WebElement searchResultText;

    @FindBy(how = How.XPATH,using = Locators.ICON_WISH_LIST_IN_HEADER)
    private WebElement iconWishList;

    @FindBy(how = How.XPATH,using = Locators.ICON_BAG_IN_HEADER)
    private WebElement iconBag;

    @FindBy(how = How.XPATH,using = Locators.HAMPERS_CATEGORY)
    private WebElement hampersCategory;

    @FindBy(how = How.XPATH,using = Locators.HAMPERS_CATEGORY_BIRTHDAYS)
    private WebElement hampersCategoryBirthdays;

    @FindBy(how = How.XPATH,using = Locators.WISHLIST_POPUP_PRODUCT_TITLE)
    private WebElement wishlistPopupProductTitle;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
//        WebElement we = driver.findElement(By.xpath(Locators.ICON_BAG_IN_HEADER));
//        we.click();
//        actions.moveToElement(we).doubleClick().perform();
    }

    public void clickOnHampersBithdaysCategory() {
        wait.until(ExpectedConditions.visibilityOf(hampersCategory));
        actions.moveToElement(hampersCategory).perform();
        wait.until(ExpectedConditions.visibilityOf(hampersCategoryBirthdays));
        actions.moveToElement(hampersCategoryBirthdays).click().perform();
    }


    public void scrollToSubscriptionSection() {
        wait.until(ExpectedConditions.visibilityOf(subscriptionEmailInput));
        actions.click(subscriptionEmailInput).perform();
        actions.scrollToElement(subscribeButton).perform();
    }

    public void enterSubscriptionEmail(String email) {
        wait.until(ExpectedConditions.visibilityOf(subscriptionEmailInput));
        subscriptionEmailInput.sendKeys(email);
    }

    public void selectCountry(String countryName) {
        selectOption(selectCountry, Locators.COUNTRY_OPTION_XPATH, countryName);
    }

    public void selectGeneralInterest(String generalInterestName) {
        selectOption(selectGeneralInterest, Locators.GENERAL_INTEREST_OPTION_XPATH, generalInterestName);
    }

    public void selectProductInterest(String productInterestName) {
        selectOption(selectProductInterest, Locators.PRODUCT_INTEREST_OPTION_XPATH, productInterestName);
    }

    public void subscribeButton() {
        wait.until(ExpectedConditions.elementToBeClickable(subscribeButton)).click();
    }

    public void changeDestination() {
        wait.until(ExpectedConditions.visibilityOf(changeDestination));
        actions.moveToElement(changeDestination).click(changeDestination).perform();
    }

    public String messageOfSuccessSubscribe() {
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOf(messageSuccessSubscribe));
        return successMessage.getText();
    }

    public void clickOnIconPersonButton() {
        wait.until(ExpectedConditions.elementToBeClickable(iconPerson));
        actions.moveToElement(iconPerson).click().perform();
    }

    private void selectOption(WebElement field, String optionLocator, String value) {
        actions.moveToElement(field).click().perform();
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(optionLocator, value))));
        option.click();
    }

    public void navigateToDetailsPage() {
        wait.until(ExpectedConditions.elementToBeClickable(iconPerson));
        actions.moveToElement(iconPerson).perform();
        wait.until(ExpectedConditions.elementToBeClickable(linkDetails));
        actions.click(linkDetails).perform();
    }

    public void clickOnIconSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(iconSearch));
        actions.moveToElement(iconSearch).click().perform();
    }

    public void enterSearchInput(String valueOnSearch) {
        wait.until(ExpectedConditions.elementToBeClickable(searchInput));
        actions.moveToElement(searchInput).click().perform();
        actions.sendKeys(searchInput, valueOnSearch).perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public void clickOnSearchButton() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));
        actions.click(searchButton).perform();
    }

    public String getSearchResultText() {
        wait.until(ExpectedConditions.visibilityOf(searchResultText));
        actions.moveToElement(searchResultText).perform();
        return searchResultText.getText();
    }

    public void clickOnWishListIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(iconWishList));
        actions.moveToElement(iconWishList).click().perform();
    }

    public void clickOnBagIcon(){
        wait.until(ExpectedConditions.elementToBeClickable(iconBag));
        actions.moveToElement(iconBag).click().perform();
    }
}
