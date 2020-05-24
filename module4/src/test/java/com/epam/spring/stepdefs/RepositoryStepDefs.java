package com.epam.spring.stepdefs;

import com.epam.spring.pageObjects.RepositoryPage;
import com.epam.spring.pageObjects.SearchResultsPage;
import com.epam.spring.pageObjects.components.SearchBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;

public class RepositoryStepDefs {

    @Autowired
    private WebDriver driver;

    @Autowired
    private SearchBar searchBar;

    @Autowired
    private RepositoryPage repositoryPage;

    @Autowired
    private SearchResultsPage searchResultsPage;

    @When("user search for repository {string}")
    public void userSearchForRepositoryMentoringProgram(String string) {
        searchBar.searchForRepo(string);
    }

    @Then("repository list are shown on results page")
    public void repositoryListAreShownOnResultsPage() {
        int resultsCount = searchResultsPage.getRepositoriesList().size();
        Assert.assertTrue("Results are not found", resultsCount > 0);
    }

    @And("user opens the first repository by clicking on the title")
    public void userOpensTheFirstRepositoryByClickingOnTheTitle() {
        searchResultsPage.getRepositoriesList().get(0).click();
    }

    @Then("repository {string} is opened")
    public void repositoryIsOpened(String string) {
        Assert.assertTrue(repositoryPage.repositoryIsOpened(string));
    }
}
