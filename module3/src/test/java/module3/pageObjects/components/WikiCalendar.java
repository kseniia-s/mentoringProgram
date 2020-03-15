package module3.pageObjects.components;

import module3.helpers.Utils;
import module3.pageObjects.SearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WikiCalendar extends BaseItem {

    public WikiCalendar(WebElement root) {
        super(root);
    }

    public SearchResultsPage changeDateToTomorrow() {
        String tomorrowDate = Utils.getTomorrowDate();
        root.findElement(By.xpath("//a[contains(text(),'" + tomorrowDate + "')]")).click();
        return new SearchResultsPage();
    }
}
