package stepdefinitions;

import enums.Pages;
import helper.Log;
import helper.ScenarioContext;
import interfaces.INavigable;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.GenericFunctionsPage;


import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class GenericFunctionsStepDef extends PageTracker {

    private GenericFunctionsPage genericFunctionsPage;

    public GenericFunctionsStepDef() {
        this.genericFunctionsPage = new GenericFunctionsPage(); // Assuming there's a default constructor
    }

    @Given("the user navigates to the {string} page")
    public void the_user_navigates_to_the_page(String pageRef) {

        //Set page via PageTracker#setPage
        Pages page = Pages.getPagesEnumFromPageRef(pageRef);
        setPage(page);

        //Get current tab for page (if exists)
        String handle = page.getTabHandle();

        /* If page already has a browser tab, switch
        to this tab rather than creating a new one */
        if (handle != null) {

            /* If this browser tab IS NOT currently selected, switch
            to it, otherwise just continue (as we are already on the correct
            browser tab) */
            Log.info("Browser tab already exists for the %s page", page.getPageRef());
            if (!ScenarioContext.driver.getWindowHandle().equals(handle)) {
                Log.info("Switching to the existing browser tab (%s) for the %s page",
                        handle,
                        page.getPageRef());
                ScenarioContext.driver.switchTo().window(handle);
            }

            //Otherwise, the browser tab for the page MUST already be selected/open
            Log.info("Existing browser tab (%s) for the %s page is currently selected",
                    handle,
                    page.getPageRef());

            //Log warning that we are re-navigating to the page
            Log.info("Re-navigating to the %s page", page.getPageRef());
        }

        /* Else, we need to assign a browser tab for this page:

            if the current URL of the current browser tab equals "data;"
            (i.e., the default tab which opens when launching the WebDriver), then
            use this tab for the page
        */
        else if (ScenarioContext.driver.getCurrentUrl().equals("data:,")) {
            Log.info("No browser tab currently allocated for the %s page", page.getPageRef());
            Log.info("Allocating the default (i.e. data:,) browser tab for the %s page", page.getPageRef());
            page.setTabHandle(ScenarioContext.driver.getWindowHandle());
            Log.info("Browser tab (%s) allocated to the %s page",
                    page.getTabHandle(),
                    page.getPageRef());
        }

        /* Else, If no browser tab is available/currently allocated to this page, create
        and allocate a new tab to this page and switch to it */
        else {
            Log.info("No browser tab currently allocated for the %s page", page.getPageRef());
            //Create & switch to a new browser tab
            Log.info("Creating and switching to new browser tab");
            ScenarioContext.driver.switchTo().newWindow(WindowType.TAB);
            //Allocate this new tab to the page
            page.setTabHandle(ScenarioContext.driver.getWindowHandle());
            Log.info("Browser tab (%s) allocated to the %s page",
                    page.getTabHandle(),
                    page.getPageRef());
        }

        /* Cast page to our desired interface (i.e. INavigableURL)
        and navigate to the page via URL */
        ScenarioContext.currentPage.castPagesAs(INavigable.class).navigateTo();

        // Accept cookies if present

        acceptCookiesIfPresent();

    }

    public void acceptCookiesIfPresent() {
        WebDriverWait wait = new WebDriverWait(ScenarioContext.driver, Duration.ofSeconds(10));
        try {
            WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("onetrust-accept-btn-handler")));
            acceptCookiesButton.click();
        } catch (Exception e) {
            Log.info("Accept cookies button not found or not clickable.");
        }
    }

    @When("Click the {string} heading on the Home page")
    public void i_click_on_the_from_the_top_right_hand_menu_bar(String string) throws InterruptedException {
        Pages page = Pages.getPagesEnumFromPageRef("Generic Page");
        setPage(page);
        ScenarioContext.currentPage.getPageRef();
        Thread.sleep(2000);
        ScenarioContext.currentPage.castPagesAs(GenericFunctionsPage.class).viewMenuClick(string);
        Log.info("Click on View profile Successful");

    }


    @When("Click the {string} Subcategory")
    public void i_click_on_the_Subcategory(String string) throws InterruptedException {
        Pages page = Pages.getPagesEnumFromPageRef("Generic Page");
        setPage(page);
        ScenarioContext.currentPage.getPageRef();
        Thread.sleep(2000);
        ScenarioContext.currentPage.castPagesAs(GenericFunctionsPage.class).viewSubcategoryClick(string);
        Log.info("Click on View profile Successful");

    }

    @Then("the following industries should be present and clickable:")
    public void the_following_industries_should_be_present_and_clickable(DataTable dataTable) throws InterruptedException {
        List<String> industries = dataTable.asList(String.class);
        for (String industry : industries) {
            genericFunctionsPage.clickElementSafely(industry);
            Log.info("Clicked on " + industry + " heading successfully");
        }
    }

    @When("Click the below {string} Link")
    public void the_below_link(String string) throws InterruptedException {
        Pages page = Pages.getPagesEnumFromPageRef("Generic Page");
        setPage(page);
        ScenarioContext.currentPage.getPageRef();
        Thread.sleep(2000);
        ScenarioContext.currentPage.castPagesAs(GenericFunctionsPage.class).viewAfterSubcategoryClick(string);
        Log.info("Clicked on subcategory: " + string);


    }


}