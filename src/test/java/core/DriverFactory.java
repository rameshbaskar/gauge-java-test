package core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class DriverFactory {

    synchronized static WebDriver getDriver() {
        String browser = System.getenv("BROWSER");
        if (browser == null) {
            return chromeDriver();
        } else {
            if (browser.equalsIgnoreCase("firefox")) {
                return firefoxDriver();
            } else {
                return chromeDriver();
            }
        }
    }

    private static WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private static WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}

