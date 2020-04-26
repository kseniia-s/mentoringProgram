package com.epam.spring.pageObjects;

import com.epam.spring.pageObjects.components.SearchBar;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage {

    @Autowired
    private SearchBar searchBar;

    @FindBy(xpath="//header//a[contains(@href,'login')]")
    private WebElement signInButton;

    public void clickOnSignIn(){
        signInButton.click();
    }
}
