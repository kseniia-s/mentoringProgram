package module3.pageObjects;

import module3.settings.ScenarioContext;
import org.openqa.selenium.support.PageFactory;

import static module3.helpers.WaitHelpers.waitForPageSourcesToBeCompletelyLoaded;
import static module3.helpers.WaitHelpers.waitPageToBeCompletelyLoaded;

public abstract class BasePage {

    BasePage() {
        waitPageToBeCompletelyLoaded();
        waitForPageSourcesToBeCompletelyLoaded();
        PageFactory.initElements(ScenarioContext.context().getBrowser(), this);
        ScenarioContext.context().setCurrentPage(this);
    }
}
