package com.example.trainingselenium.Pages;

import com.example.trainingselenium.Utils.Locators;
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
import java.util.HashMap;
import java.util.Map;

public class PLP {
    private WebDriver driver;
    private FluentWait<WebDriver> wait;
    private Actions actions;

    @FindBy(how = How.XPATH, using = Locators.ALL_PRODUCTS)
    private WebElement productsListPage;

    @FindBy(how = How.XPATH, using = Locators.FIRST_PRODUCT)
    private WebElement firstProductInPage;

    @FindBy(how = How.XPATH, using = Locators.PRODUCT_DETAILS_PAGE_ADD_TO_WISHLIST)
    private WebElement addToWishlist;

//    @FindBy(how = How.XPATH, using = Locators.PRODUCT_DETAILS_PAGE)
//    private WebElement productDetailsPageByDataSku;


    public PLP(WebDriver driver) {
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(100))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class);
        actions = new Actions(driver);
    }

    public void clickOnTheFirstProduct() {
        wait.until(ExpectedConditions.visibilityOf(firstProductInPage));
        actions.moveToElement(firstProductInPage).click().build().perform();
    }

    public void clickOnAProductByDataSku(String dataSku) {
        String xpath = String.format(Locators.PRODUCT_DETAILS_PAGE, dataSku);
        WebElement productDetailsPageByDataSku = driver.findElement(By.xpath(xpath));
        wait.until(ExpectedConditions.visibilityOf(productDetailsPageByDataSku));
        actions.moveToElement(productDetailsPageByDataSku).click().build().perform();
    }

    public void addProductToWishlist(){
        wait.until(ExpectedConditions.visibilityOf(addToWishlist));
        actions.moveToElement(addToWishlist).click().build().perform();
    }

    public Map<String, String> getTitles(){
        WebElement wishlistTitle = driver.findElement(By.xpath(Locators.WISHLIST_PRODUCT_TITLE));
        Map<String, String> titles = new HashMap<>();

        wait.until(ExpectedConditions.visibilityOf(wishlistTitle));
        String wishlistProductTitle = wishlistTitle.getText();

        titles.put("wishlistProductTitle", wishlistProductTitle);
        titles.put("wishlistProductPopUpProductTitle", WishlistPopup.PRODUCT_TITLE);

        return titles;
    }


}
