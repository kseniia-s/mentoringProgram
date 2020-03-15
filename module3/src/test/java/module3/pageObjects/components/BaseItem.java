package module3.pageObjects.components;

import org.openqa.selenium.WebElement;

abstract class BaseItem {

    WebElement root;

    BaseItem(WebElement root) {
        this.root = root;
    }
}
