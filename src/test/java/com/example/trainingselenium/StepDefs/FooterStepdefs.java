package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.ChooseCountryAndCurrencyForShoppingPopup;
import com.example.trainingselenium.Pages.CookiesPopup;
import com.example.trainingselenium.Pages.Footer;
import com.example.trainingselenium.Pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class FooterStepdefs {
    private WebDriver driver;
    private HomePage homePage;
    private Footer footerNewsLetter;
    private ChooseCountryAndCurrencyForShoppingPopup chooseCountryAndCurrencyForShoppingPopup;
    private CookiesPopup cookiesPopup;

    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        homePage = pageObjectInitialization.getHomePage();
        footerNewsLetter = pageObjectInitialization.getFooterNewsLetter();
        cookiesPopup = pageObjectInitialization.getCookiesPopup();
        chooseCountryAndCurrencyForShoppingPopup = pageObjectInitialization.getChooseCountryAndCurrencyForShoppingPopup();
    }

    @And("the user select the EU country switcher {} and {}")
    public void theUserSelectTheEUCountrySwitcherCountryAndCurrency(String country, String currency) {
        chooseCountryAndCurrencyForShoppingPopup.clickCountryDropdown();
        chooseCountryAndCurrencyForShoppingPopup.enterCountryInput(country);
        chooseCountryAndCurrencyForShoppingPopup.selectCountry(country);
        chooseCountryAndCurrencyForShoppingPopup.clickCurrencyDropdown();
        chooseCountryAndCurrencyForShoppingPopup.selectCurrency(currency);
        chooseCountryAndCurrencyForShoppingPopup.clickStartShoppingButton();
    }

    @And("the user has accessed the sign-up bloc")
    public void theUserHasAccessedTheSignUpBloc() {
        footerNewsLetter.scrollDownToNewsletterEmailInput();
    }

    @When("the user inserts a valid email {} and attempts to subscribe")
    public void theUserInsertsAValidEmailEmailAndAttemptsToSubscribe(String email) {
        footerNewsLetter.enterNewsletterEmailInput(email);
    }

    @And("the user selects the country where they live {}")
    public void theUserSelectsTheCountryWhereTheyLiveCountry(String country) {
        footerNewsLetter.selectNewsletterCountryDropdown(country);
    }

    @And("the user selects the most exciting topic from the world of Fortnums {}")
    public void theUserSelectsTheMostExcitingTopicFromTheWorldOfFortnumsFortnumTopic(String fortnumTopic) {
        footerNewsLetter.selectNewsletterGeneralInterest(fortnumTopic);
    }

    @And("the user selects the Fortnums product {} they would take to a desert island")
    public void theUserSelectsTheFortnumsProductProductTheyWouldTakeToADesertIsland(String product) {
        footerNewsLetter.selectNewsletterProductInterest(product);
    }

    @And("the user attemps to subscribe")
    public void theUserAttempsToSubscribe() {
        footerNewsLetter.clickNewsletterSignUpButton();
    }

    @Then("the user is successfully subscribed")
    public void theUserIsSuccessfullySubscribed() {
    }

    @After
    public void quitDriver(){
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
