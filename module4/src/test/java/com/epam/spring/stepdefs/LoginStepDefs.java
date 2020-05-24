package com.epam.spring.stepdefs;

import com.epam.spring.SpringIntegrationTest;
import com.epam.spring.configurations.ApplicationConfig;
import com.epam.spring.pageObjects.HomePage;
import com.epam.spring.pageObjects.LoginPage;
import com.epam.spring.pageObjects.WelcomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = ApplicationConfig.class)
public class LoginStepDefs extends SpringIntegrationTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginStepDefs.class);

    @Autowired
    private WebDriver driver;

    @Autowired
    private HomePage homePage;

    @Autowired
    private LoginPage loginPage;

    @Autowired
    private WelcomePage welcomePage;

    @Value("${github.username}")
    private String predefinedUserName;

    @Value("${github.useremail}")
    private String predefinedUserEmail;

    @Value("${github.password}")
    private String predefinedUserPassword;

    @Given("opened browser with github home page {string}")
    public void openedBrowserWithGithubHomePage(String string) {
        driver.navigate().to(string);
    }

    @When("user clicks on Sign in button")
    public void userClicksOnSignInButton() {
        homePage.clickOnSignIn();
    }

    @And("user fills a login form with predefined username and password")
    public void userFillsALoginFormWithPredefinedUsernameAndPassword() {
        loginPage.setUsername(predefinedUserEmail);
        loginPage.setPassword(predefinedUserPassword);
    }

    @And("user clicks on Sign in button at the login form")
    public void userClicksOnSignInButtonAtTheLoginForm() {
        loginPage.clickSignInButton();
        welcomePage.waitForPageToBeLoaded();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {
        Boolean userIsLoggedIn = welcomePage.isUserLoggedIn(predefinedUserName);
        Assert.assertTrue("Welcome page is not opened", userIsLoggedIn);
    }
}
