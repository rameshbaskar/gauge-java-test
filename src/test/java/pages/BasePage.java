package pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

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
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT, SECONDS)
                .pollingEvery(2, SECONDS)
                .ignoring(NoSuchElementException.class);

        fluentWait.until(driver -> visibilityOf(element).apply(driver));
    }

    void waitForElementToBeVisible(By strategy) {
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(TIMEOUT, SECONDS)
                .pollingEvery(2, SECONDS)
                .ignoring(NoSuchElementException.class);

        fluentWait.until(driver -> presenceOfElementLocated(strategy).apply(driver));
    }
}
