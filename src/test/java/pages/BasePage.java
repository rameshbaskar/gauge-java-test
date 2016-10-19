package pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
class BasePage {
    static WebDriver driver = Driver.getDriver();
    private static final long TIMEOUT = 60;

    void visit(String url) {
        driver.get(url);
    }

    void waitForElementToBeVisible(WebElement element) {
        WebDriverWait driverWait = new WebDriverWait(driver, TIMEOUT);
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    void waitForElementToBeVisible(By strategy) {
        WebDriverWait driverWait = new WebDriverWait(driver, TIMEOUT);
        driverWait.until(ExpectedConditions.presenceOfElementLocated(strategy));
    }
}
