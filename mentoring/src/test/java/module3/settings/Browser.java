package module3.settings;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static ChromeDriver driver;

    private Browser () {}

    public static WebDriver getDriver() {
        if (driver == null) {
            WebDriverManager.globalConfig().setForceCache(false);
            WebDriverManager.chromedriver().version("79.0.3945.36").setup();

            ChromeOptions options = new ChromeOptions();

            options.addArguments("start-maximized");
            options.addArguments("enable-automation");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            System.out.println(driver.getCapabilities().getVersion());
        }
        return driver;
    }

    public static void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }
}
