package module3.pageObjects;

import module3.enums.GeoPoint;
import module3.pageObjects.components.WikiCalendar;
import module3.settings.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static module3.helpers.WaitHelpers.waitForPageSourcesToBeCompletelyLoaded;
import static module3.helpers.WaitHelpers.waitPageToBeCompletelyLoaded;

public class SearchResultsPage extends BasePage {

    @FindBy(id = "firstHeading")
    private WebElement mainHeading;

    @FindBy(xpath = "//*[@id='Events']/parent::h2/following-sibling::ul[1]/child::li")
    private List<WebElement> eventsList;

    private By calendar = By.xpath("//table[contains(@class,'toccolours') and @cellpadding='2']");

    public SearchResultsPage() {
        waitPageToBeCompletelyLoaded();
        waitForPageSourcesToBeCompletelyLoaded();
    }

    public String getMainHeading() {
        return mainHeading.getText().trim();
    }

    public List<WebElement> getEventsList() {
        return eventsList;
    }

    public List<GeoPoint> getGeoPointsList() {
        return getEventsList()
                .stream()
                .flatMap(article -> article.findElements(By.tagName("a")).stream())
                .map(WebElement::getText)
                .map(GeoPoint::getGeoPointByCountryName)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    public WikiCalendar getCalendar() {
        return new WikiCalendar(Browser.getDriver().findElement(calendar));
    }
}
