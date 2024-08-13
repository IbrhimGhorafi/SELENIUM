package com.example.trainingselenium.StepDefs;

import com.example.trainingselenium.Config.PageObjectInitialization;
import com.example.trainingselenium.Config.WebDriverConfiguration;
import com.example.trainingselenium.Pages.HomePage;
import com.example.trainingselenium.Pages.LoginPopUp2;
import com.example.trainingselenium.Utils.Locators;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ResetPasswordStepdefs {
    private WebDriver driver;
    private HomePage homePage;
    private LoginPopUp2 loginPopUp2;

    @Before
    public void setup() throws Exception {
        driver = WebDriverConfiguration.getDriver();
        PageObjectInitialization pageObjectInitialization = new PageObjectInitialization(driver);
        homePage = pageObjectInitialization.getHomePage();
        loginPopUp2 = pageObjectInitialization.getLoginPopUp2();
    }

    @And("the user access the login form")
    public void theUserAccessTheLoginForm() {
        homePage.clickOnTheAccountIcon();
    }

    @When("the user attempts to reset the password")
    public void theUserAttemptsToResetThePassword() {
        loginPopUp2.clickForgottenThePasswordLink();
    }

    @And("the user inserts a valid email {} and clicks the reset button")
    public void theUserInsertsAValidEmailEmailAndClicksTheResetButton(String email) {
        loginPopUp2.enterEmailAddress(email);
        loginPopUp2.clickResetPasswordButton();
    }

    @Then("the user should see a popup message indicating that an email has been sent for resetting the password")
    public void theUserShouldSeeAPopupMessageIndicatingThatAnEmailHasBeenSentForResettingThePassword() {
    }

    @And("the user accesses the Yopmail website")
    public void theUserAccessesTheYopmailWebsite() {
        loginPopUp2.navigateToYopmail();
    }

    @And("the user logs in with the email {} used for password reset")
    public void theUserLogsInWithTheEmailEmailUsedForPasswordReset(String email) {
        loginPopUp2.loginToYopmail(email);
    }

    @And("the user retrieves the latest email")
    public void theUserRetrievesTheLatestEmail() {
        loginPopUp2.checkingTheLastEmail();
    }

    @And("the user inserts a new password {} and confirms it")
    public void theUserInsertsANewPasswordNewPasswordAndConfirmsIt(String newPassword) {
        loginPopUp2.changeThePassword(newPassword);
    }

    @And("the user sees a popup confirming that the password has been successfully changed")
    public void theUserSeesAPopupConfirmingThatThePasswordHasBeenSuccessfullyChanged() {
        WebElement passwordResetPopup = driver.findElement(By.xpath(Locators.LOGIN_TOAST_POPUP_ICON));
        Assert.assertTrue(passwordResetPopup.isDisplayed());
        loginPopUp2.clickOKButton();
    }

    @And("the user attempts to login with valid {} and the new {}")
    public void theUserAttemptsToLoginWithValidAndTheNew(String email, String newPassword) {
        loginPopUp2.enterEmail(email);
        loginPopUp2.enterPassword(newPassword);
        loginPopUp2.clickOnLoginButton();
    }


}
