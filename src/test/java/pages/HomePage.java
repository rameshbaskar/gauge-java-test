package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Logger;

/**
 * Created by Ramesh Baskarasubramanian on 6/11/15.
 */
public class HomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement tbSearch;

    @FindBy(name = "btnG")
    private WebElement btnSearch;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void visit() {
        String url = System.getenv("APP_BASE_URL");
        Logger.info("Loading HomePage using URL: " + url);
        visit(url);
        if (!elementWithWaitFor(tbSearch).isDisplayed()) {
            Logger.exception(new Exception("Home page not loaded !!!"));
        }
    }

    public void searchFor(String text) {
        tbSearch.sendKeys(text);
        btnSearch.click();
    }

    public boolean isSearched(String text) {
        return getValueFrom(tbSearch).contains(text);
    }
}
