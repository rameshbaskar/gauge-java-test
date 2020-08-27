package core;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.WebDriver;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class Driver {
    private static WebDriver driver = null;

    public static WebDriver getDriver() {
        return driver;
    }

    private static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        if (driver == null) {
            driver = DriverFactory.getDriver();
        }
    }

    @AfterSuite
    public void afterSuite() {
        closeDriver();
    }
}
