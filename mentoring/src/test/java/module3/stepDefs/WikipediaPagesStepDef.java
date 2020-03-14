package module3.stepDefs;

import module3.enums.GeoPoint;
import module3.helpers.Utils;
import module3.pageObjects.SearchResultsPage;
import module3.pageObjects.HomePage;
import module3.settings.Browser;
import module3.settings.ScenarioContext;
import org.jbehave.core.annotations.AfterStories;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.steps.Steps;
import org.junit.Assert;

import java.util.List;

public class WikipediaPagesStepDef extends Steps {

    @AfterStories
    public void quit()
    {
        Browser.tearDown();
    }

    @Given("an opened browser with an $URL")
    public void anOpenedBrowserWithABaseURL(String URL) {
        Browser.getDriver().navigate().to(URL);
    }

    @When("user searches events that occurred in the same day as today")
    public void whenUserSearchesEventsThatOccurredInTheSameDayAsToday() {
        String todayMonthAndDate = Utils.getFormattedCurrentDate();
        new HomePage().searchByKeyword(todayMonthAndDate);

        ScenarioContext.context().setData("today's date", todayMonthAndDate);
    }

    @Then("events for the searched day are shown")
    public void thenEventsForTheSearchedDayAreShown() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        String mainHeading = searchResultsPage.getMainHeading();
        String todayDate = (String) ScenarioContext.context().getData("today's date");
        int eventsCount = searchResultsPage.getEventsList().size();

        Assert.assertTrue("Nothing found for the current date", eventsCount > 0);
        Assert.assertEquals("Selected date from the calendar is not matched to the shown date on the page", mainHeading, todayDate);
        ScenarioContext.context().setData("initial events count", eventsCount);

        System.out.println(eventsCount);
    }

    @Then("articles with Geo-points mentioning are shown")
    public void thenArticlesWithGeopointsMentioningAreShown() {
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        List<GeoPoint> geoPoints = searchResultsPage.getGeoPointsList();

        System.out.println("initial geoPoints count: " + geoPoints.size());
        System.out.println("initial geoPoints: " + geoPoints);

        Assert.assertTrue(geoPoints.size() > 0);

        ScenarioContext.context().setCurrentPage(searchResultsPage);
        if (!ScenarioContext.context().isDataSet("initial geoPoints")) {
            ScenarioContext.context().setData("initial geoPoints", geoPoints);
        }
    }

    @When("user changes the date to tomorrow using a calendar")
    public void whenUserChangesTheDateToTomorrowUsingACalendar() {
        SearchResultsPage searchResultsPage = (SearchResultsPage) ScenarioContext.context().getCurrentPage();
        searchResultsPage.getCalendar().changeDateToTomorrow();
    }

    @Then("the number of articles with Geo-points mentioning is changed")
    public void thenTheNumberOfArticlesWithGeopointsMentioningIsChanged() {
        SearchResultsPage searchResultsPage = (SearchResultsPage) ScenarioContext.context().getCurrentPage();
        List<GeoPoint> initialGeoPoints = (List<GeoPoint>) ScenarioContext.context().getData("initial geoPoints");
        List<GeoPoint> currentGeoPoints = searchResultsPage.getGeoPointsList();

        System.out.println("current geoPoints count: " + currentGeoPoints.size());
        System.out.println("current geoPoints: " + currentGeoPoints);

        System.out.println("initial geoPoints count: " + initialGeoPoints.size());
        System.out.println("initial geoPoints: " + initialGeoPoints);

        Assert.assertNotEquals(currentGeoPoints, initialGeoPoints);
    }
}
