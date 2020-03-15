package module3.helpers;

import module3.settings.ScenarioContext;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelpers {

    private static int pageLoadTimeout = 5;

    public static void waitForPageSourcesToBeCompletelyLoaded() {
        JavascriptExecutor js = ((JavascriptExecutor) ScenarioContext.context().getBrowser());
        js.executeScript("return window.jQuery != undefined && jQuery.active == 0;");
    }

    public static void waitPageToBeCompletelyLoaded() {
        new WebDriverWait(ScenarioContext.context().getBrowser(), pageLoadTimeout)
                .until(wait -> ((JavascriptExecutor) ScenarioContext.context().getBrowser()).executeScript("return document.readyState").equals("complete"));
    }
}

