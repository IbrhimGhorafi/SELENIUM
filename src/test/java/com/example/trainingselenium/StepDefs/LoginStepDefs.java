package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.ChooseCountryAndCurrencyForShoppingPopup;
import com.example.trainingselenium.Pages.CookiesPopup;
import com.example.trainingselenium.Pages.HomePage;
import com.example.trainingselenium.Pages.LoginPopup;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

@Slf4j
public class LoginStepDefs {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPopup loginPopup;
    private ChooseCountryAndCurrencyForShoppingPopup chooseCountryAndCurrencyForShoppingPopup;
    private CookiesPopup cookiesPopup;

    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        log.info("Setup Driver {}", driver);
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        homePage = pageObjectInitialization.getHomePage();
        loginPopup = pageObjectInitialization.getLoginPopup();
        cookiesPopup = pageObjectInitialization.getCookiesPopup();
        chooseCountryAndCurrencyForShoppingPopup = pageObjectInitialization.getChooseCountryAndCurrencyForShoppingPopup();
    }


    @Given("the user is on the Fortnums and Mason homepage")
    public void theUserIsOnTheFortnumsAndMasonHomepage() {
        cookiesPopup.acceptAllCookies();
        homePage.changeDestination();
    }

    @And("the user select the Non EU country switcher {} and {}")
    public void theUserSelectTheNonEUCountrySwitcherCountryAndCurrency(String country, String currency) {
        chooseCountryAndCurrencyForShoppingPopup.clickCountryDropdown();
        chooseCountryAndCurrencyForShoppingPopup.enterCountryInput(country);
        chooseCountryAndCurrencyForShoppingPopup.selectCountry(country);
        chooseCountryAndCurrencyForShoppingPopup.clickCurrencyDropdown();
        chooseCountryAndCurrencyForShoppingPopup.selectCurrency(currency);
        chooseCountryAndCurrencyForShoppingPopup.clickStartShoppingButton();
    }

    @And("the user has accessed the login form")
    public void theUserHasAccessedTheLoginForm() {
        homePage.clickOnIconPersonButton();
    }

    @After
    public  void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
