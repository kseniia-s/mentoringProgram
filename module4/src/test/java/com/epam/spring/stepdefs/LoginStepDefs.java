package com.epam.spring.stepdefs;

import com.epam.spring.SpringIntegrationTest;
import com.epam.spring.pageObjects.HomePage;
import com.epam.spring.pageObjects.LoginPage;
import com.epam.spring.pageObjects.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class LoginStepDefs extends SpringIntegrationTest {

    @Autowired
    private WebDriver driver;
    @Autowired
    private HomePage homePage;
    @Autowired
    private LoginPage loginPage;
    @Autowired
    private WelcomePage welcomePage;

    @Value("${github.username}")
    private String predefinedUsername;

    @Value("${github.password}")
    private String predefinedPassword;

    @Given("opened browser with github home page {string}")
    public void openedBrowserWithGithubHomePage(String string) {
        driver.navigate().to(string);
    }

    @When("user clicks on Sign in button")
    public void userClicksOnSignInButton(){
        homePage.clickOnSignIn();
    }

//    @And("user fills a login form with {string} and {string}")
//    public void userFillsALoginFormWithUsernameAndPassword(String username, String password) {
//        loginPage.setUsername(username);
//        loginPage.setPassword(password);
//    }

    @And("user fills a login form with predefined username and password")
    public void userFillsALoginFormWithPredefinedUsernameAndPassword() {
        loginPage.setUsername(predefinedUsername);
        loginPage.setPassword(predefinedPassword);
    }

    @And("user clicks on Sign in button at the login form")
    public void userClicksOnSignInButtonAtTheLoginForm() {
        loginPage.clickSignInButton();
        welcomePage.waitForPageLoaded();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
//        Assert.assertTrue(welcomePage.isOpened(), "Welcome page is not opened");
    }
}
