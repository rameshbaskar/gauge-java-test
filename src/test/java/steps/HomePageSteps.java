package steps;

import com.thoughtworks.gauge.Step;

import static org.junit.Assert.assertTrue;

/**
 * Created by ramesh on 28/07/16.
 */
public class HomePageSteps extends BaseStep {

    @Step("I open the home page")
    public void I_open_the_home_page() {
        homePage.visit();
    }

    @Step("I search for <text>")
    public void I_search_for_text(String text) {
        homePage.searchFor(text);
    }

    @Step("I should get the search results for <text>")
    public void I_should_get_the_search_results_for(String text) {
        assertTrue(homePage.isSearched(text));
    }
}
