package module3.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(id = "searchInput")
    private WebElement searchingField;

    @FindBy(id = "searchButton")
    private WebElement searchingIcon;

    public void searchByKeyword(String keyword) {
        searchingField.sendKeys(keyword);
        searchingIcon.click();
    }
}
