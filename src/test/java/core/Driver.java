package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import utils.Logger;

/**
 * Created by Ramesh Baskarasubramanian on 6/10/15.
 */
public class Driver {
    private static WebDriver webDriver = null;

    public synchronized static void start() {
        if (webDriver == null) {
            Logger.info("WebDriver not initialized. Starting one now...");
            try {
                launchDriver();
                Logger.info("WebDriver started.");
            } catch (Exception e) {
                Logger.error("Unable to initialize the web driver !!!");
                Logger.exception(e);
            }
        }
    }

    public synchronized static WebDriver driver() {
        return webDriver;
    }

    public static void close() {
        if (webDriver != null) {
            Logger.info("Closing open sessions...");
            webDriver.quit();
            webDriver = null;
        }
    }

    private static void launchDriver() {
        String browser = System.getenv("BROWSER");
        String chromeDriverPath = System.getenv("CHROME_DRIVER_PATH");

        if (browser.equals("firefox")) {
            Logger.info("Starting firefox driver now...");
            webDriver = new FirefoxDriver(new FirefoxProfile());
        } else {
            Logger.info("Starting chrome driver now...");
            System.setProperty("webdriver.chrome.driver", chromeDriverPath);
            webDriver = new ChromeDriver();
        }
    }
}
