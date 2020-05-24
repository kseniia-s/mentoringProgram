package com.epam.spring.pageObjects;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryPage extends BasePage {

    @Autowired
    private WebDriver driver;

    public boolean repositoryIsOpened(String repoName) {
        return driver.getCurrentUrl().contains(repoName) && driver.getTitle().contains(repoName);
    }
}
