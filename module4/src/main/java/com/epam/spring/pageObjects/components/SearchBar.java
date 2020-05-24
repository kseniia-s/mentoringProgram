package com.epam.spring.pageObjects.components;

import com.epam.spring.pageObjects.BaseItem;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SearchBar extends BaseItem {

    @Autowired
    private WebDriver driver;

    @FindBy(xpath = "//form[@role='search']//input[@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//ul[@id='jump-to-results']/li")
    private List<WebElement> repositoryList;

    public SearchBar() {
    }

    public void searchForRepo(String repoName) {
        searchField.sendKeys(repoName);
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
    }
}
