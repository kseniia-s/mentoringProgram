package com.epam.spring.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    @FindBy(id="")
    private WebElement userNameField;

    @FindBy(id="")
    private WebElement passwordField;

    @FindBy(id="")
    private WebElement signInButton;

    public void fillLoginForm(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
}
