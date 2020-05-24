package com.epam.spring.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//ul[@class='repo-list']/li")
    private List<WebElement> repositoriesList;

    private By fullRepositoryName = By.xpath("//div[contains(@class,'text-normal')]//a");

    public List<WebElement> getRepositoriesList() {
        return repositoriesList;
    }

    public int getResultsCount() {
        return waitAllElementsToBeVisibleAndReturnList(repositoriesList).size();
    }

    public void openFirstFoundRepo() {
        repositoriesList.get(0).findElement(fullRepositoryName).click();
    }
}
