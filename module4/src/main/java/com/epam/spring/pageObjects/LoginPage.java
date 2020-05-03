package com.epam.spring.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class LoginPage {

    @FindBy(id="login_field")
    private WebElement userNameField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(name="commit")
    private WebElement signInButton;

    public void fillLoginForm(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public void clickSignInButton(){
        signInButton.click();
    }
}
