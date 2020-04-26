package com.epam.spring.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BasePage {

    @Autowired
    private WebDriver driver;

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
