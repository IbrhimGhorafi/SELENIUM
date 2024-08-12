package com.example.trainingselenium.Pages;

import com.example.trainingselenium.Utils.Locators;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class WishlistPopup {

    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;
    static String PRODUCT_TITLE;

    @FindBy(how = How.XPATH, using = Locators.WISHLIST_POPUP)
    private WebElement wishlistPopUp;

    @FindBy(how = How.XPATH, using = Locators.WISHLIST_POPUP_VIEW_WISHLIST)
    private WebElement wishlistPopUpViewButton;

    @FindBy(how = How.ID, using = "toast-view-wishlist-button")
    private WebElement viewWishlistButton;

    public WishlistPopup(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void clickViewWishlistButton(){
        PRODUCT_TITLE = driver.findElement(By.xpath(Locators.WISHLIST_POPUP_PRODUCT_TITLE)).getText();
        wait.until(ExpectedConditions.visibilityOf(wishlistPopUp));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", viewWishlistButton);
        viewWishlistButton.click();
//          wait.until(ExpectedConditions.visibilityOf(wishlistPopUp));
////        wait.until(ExpectedConditions.elementToBeClickable(wishlistPopUpViewButton));
////        wait.until(ExpectedConditions.alertIsPresent());
//        actions.moveToElement(wishlistPopUpViewButton).click().perform();
    }
}
