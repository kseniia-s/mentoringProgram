package com.epam.spring.stepdefs;

import com.epam.spring.SpringIntegrationTest;
import com.epam.spring.pageObjects.HomePage;
import com.epam.spring.pageObjects.LoginPage;
import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.DataTable;
import io.cucumber.core.gherkin.vintage.internal.gherkin.ast.TableRow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import java.util.*;

public class LoginStepDefs extends SpringIntegrationTest {
    @Autowired
    private WebDriver driver;

    @Autowired
    private HomePage homePage;
    @Autowired
    private LoginPage loginPage;

    @Given("opened browser with github home page {string}")
    public void openedBrowserWithGithubHomePage(String string) {
        driver.navigate().to(string);
    }

    @When("user clicks on Sign in button")
    public void userClicksOnSignInButton(){
        homePage.clickOnSignIn();
    }

    @And("user fills a login form")
    public void userFillsALoginForm(DataTable table) {
        LoginPage loginPage = new LoginPage();
        List<TableRow> signForms = table.getRows();

        for (TableRow row : signForms) {
            String userName = row.getCells().get(0).getValue();
            String password = row.getCells().get(1).getValue();

            loginPage.fillLoginForm(userName, password);
        }
    }

    @And("user clicks on Sign in button at the login form")
    public void userClicksOnSignInButtonAtTheLoginForm() {
        loginPage.clickSignInButton();
    }

    @Then("user is logged in")
    public void userIsLoggedIn() {

    }
}