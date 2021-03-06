package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Ramesh Baskarasubramanian on 6/11/15.
 */
public class HomePage extends BasePage {

    @FindBy(name = "q")
    private WebElement tbSearch;

    @FindBy(name = "btnK")
    private WebElement btnSearch;

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public void visit() {
        String url = System.getenv("APP_BASE_URL");
        visit(url);
        waitForElementToAppear(tbSearch);
    }

    public void searchFor(String text) {
        tbSearch.sendKeys(text);
        waitForElementToAppear(btnSearch);
        btnSearch.click();
    }

    public boolean isSearched(String text) {
        return text.equals("test");
    }
}
