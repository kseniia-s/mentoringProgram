package module3.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import module3.settings.Browser;

public class WaitHelpers {

    private static int pageLoadTimeout = 5;

    public static void waitForPageSourcesToBeCompletelyLoaded() {
        JavascriptExecutor js = (JavascriptExecutor) Browser.getDriver();
        js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
    }

    public static void waitPageToBeCompletelyLoaded() {
        new WebDriverWait(Browser.getDriver(), pageLoadTimeout)
                .until(wait -> ((JavascriptExecutor) Browser.getDriver()).executeScript("return document.readyState").equals("complete"));
    }
}

