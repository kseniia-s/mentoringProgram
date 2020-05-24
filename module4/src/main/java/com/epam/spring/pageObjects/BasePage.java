package com.epam.spring.pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public abstract class BasePage {

    @Autowired
    private WebDriver driver;

    public void waitForPageToBeLoaded() {
        ExpectedCondition<Boolean> pageLoadCondition = driver1 -> ((JavascriptExecutor) driver1)
                .executeScript("return document.readyState").equals("complete");
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(pageLoadCondition);
    }

    public List<WebElement> waitAllElementsToBeVisibleAndReturnList(List<WebElement> list) {
        return new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfAllElements(list));
    }
}
