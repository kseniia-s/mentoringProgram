package com.epam.spring.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WelcomePage extends BasePage {

    @Autowired
    private WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'header-nav-current-user')]/a[@role='menuitem']/strong")
    private WebElement userName;

    @FindBy(xpath = "//summary[@aria-label='View profile and more']/img")
    private WebElement userIcon;

    public Boolean isUserLoggedIn(String predefinedUserName) {
        try {
            openUserProfileMenu();
            return userName.getText().trim().equals(predefinedUserName);
        } catch (NullPointerException e) {
            return false;
        }
    }

    private void openUserProfileMenu() {
        userIcon.click();
    }
}
