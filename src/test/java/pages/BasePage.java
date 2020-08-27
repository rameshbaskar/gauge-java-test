package pages;

import core.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

class BasePage {

    private final static int IMPLICIT_TIMEOUT = 5;
    private final static int ELEMENT_TIMEOUT = 30;
    static WebDriver driver;

    BasePage() {
        driver = Driver.getDriver();
        driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
    }

    void visit(String url) {
        driver.get(url);
    }

    WebElement findElement(By locator) {
        return (new WebDriverWait(driver, ELEMENT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    void waitForElementToAppear(WebElement element) {
        new WebDriverWait(driver, ELEMENT_TIMEOUT)
                .until(ExpectedConditions.visibilityOf(element));
    }

    void waitForElementToDisappear(WebElement element) {
        new WebDriverWait(driver, ELEMENT_TIMEOUT)
                .until(ExpectedConditions.invisibilityOf(element));
    }

    void waitForElementToBeClickable(WebElement element) {
        new WebDriverWait(driver, ELEMENT_TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
