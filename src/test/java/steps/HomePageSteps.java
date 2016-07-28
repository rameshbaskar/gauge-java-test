package steps;

import com.thoughtworks.gauge.Step;
import org.junit.Assert;
import pages.HomePage;
import utils.Logger;

/**
 * Created by ramesh on 28/07/16.
 */
public class HomePageSteps {

    private HomePage homePage = new HomePage();

    @Step("I open the home page")
    public void I_open_the_home_page() {
        Logger.info("Loading the home page...");
        homePage.visit();
    }

    @Step("I search for <text>")
    public void I_search_for_text(String text) {
        Logger.info("Searching for " + text + " ...");
        homePage.searchFor(text);
    }

    @Step("I should get the search results for <text>")
    public void I_should_get_the_search_results_for(String text) {
        Logger.info("Verifying if " + text + " is searched...");
        Assert.assertTrue(homePage.isSearched(text));
    }
}
