package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.Map;

public class WishlistStepdefs {
    private WebDriver driver;
    private HomePage homePage;
    private WishlistPopup wishlistPopup;
    private PLP wishList;

    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        homePage = pageObjectInitialization.getHomePage();
        wishList = pageObjectInitialization.getPlp();
        wishlistPopup = pageObjectInitialization.getWishlistPopup();
    }


    @And("the user select the product category")
    public void theUserSelectTheProductCategory() {
        homePage.clickOnHampersBithdaysCategory();
    }

    @When("the user select a product {}")
    public void theUserSelectAProductDataSku(String product) {
        wishList.clickOnAProductByDataSku(product);
    }

    @And("clicks on the {} Button")
    public void clicksOnTheButton(String arg0) {
        wishList.addProductToWishlist();
        wishlistPopup.clickViewWishlistButton();
    }

    @Then("the item should be added to the wishlist")
    public void theItemShouldBeAddedToTheWishlist() {
        Map<String,String> titles = wishList.getTitles();
        Assert.assertEquals("Product Titles does not match", titles.get("wishlistProductTitle").split("\n")[0], titles.get("wishlistProductPopUpProductTitle"));
    }

}
