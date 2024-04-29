
package pages;

import helper.Log;
import interfaces.ISelectable;
import interfaces.IValidation;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utility.ElementUtil;

import java.time.Duration;
import java.util.List;

import static helper.ScenarioContext.driver;

public class GenericFunctionsPage extends LoginPageObject implements ISelectable, IValidation {

    private final String
            FIND_TEXT_FIELD_XPATH_MENU = "//*[text()='%1$s' or @placeholder='%1$s']",
            FIND_TEXT_FIELD_XPATH_SUBCATEGORY = "//div[text()='%1$s'] | //div[text()='%1$s ']",
            FIND_TEXT_FIELD_XPATH_AFTER_SUBCATEGORY = "//div[text()='%1$s'][1] | //div[text()='%1$s']";



    public void viewMenuClick(String validateData) throws InterruptedException {
        Thread.sleep(5000);
        ElementUtil.jsClick(ElementUtil.getXpath(FIND_TEXT_FIELD_XPATH_MENU, validateData));
        Thread.sleep(5000);

    }


    public void viewSubcategoryClick(String validateData) throws InterruptedException {
        Thread.sleep(5000);
        ElementUtil.jsClick(ElementUtil.getXpath(FIND_TEXT_FIELD_XPATH_SUBCATEGORY, validateData));
        Thread.sleep(5000);

    }

    public void viewAfterSubcategoryClick(String validateData) throws InterruptedException {
        Thread.sleep(5000);
        ElementUtil.jsClick(ElementUtil.getXpath(FIND_TEXT_FIELD_XPATH_AFTER_SUBCATEGORY, validateData));
        Thread.sleep(5000);

    }

    public void clickElementSafely(String validateData) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By locator = ElementUtil.getXpath(FIND_TEXT_FIELD_XPATH_SUBCATEGORY, validateData);

        try {

            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        } catch (TimeoutException e) {
            Log.error("Element not clickable within the time frame: " + validateData);
            // Optionally, fall back to JavaScript click if regular click fails
            WebElement element = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    @Override
    public void enterData(String container, String fieldLabel, String value) {

    }

    @Override
    public void enterTextIntoSearchbar(String text) {

    }

    @Override
    public String getURL() {
        return null;
    }

    @Override
    public void validateTextFieldsAreVisible(List<String> listOfTextFieldNames) {

    }

    @Override
    public void validateResultsAreVisible(List<String> results) {

    }

    @Override
    public void validateTabsAreVisible(List<String> listOfTextFieldNames) {

    }

    @Override
    public boolean validateScreenIsVisible(String screenName) {
        return false;
    }

    @Override
    public void validateButtonsAreDisabled(List<String> buttonNames, boolean areDisabled) {

    }

    @Override
    public BasePageObject enterLoginCredentials(String username, String password) {
        return null;
    }

    @Override
    public BasePageObject login() {
        return null;
    }

    @Override
    public BasePageObject logout() {
        return null;
    }

    @Override
    public boolean onLoginPage() {
        return false;
    }

    @Override
    public boolean isLoggedIn(String username) {
        return false;
    }

    @Override
    public boolean isLogoutDisplayed() {
        return false;
    }

    @Override
    public void LogoutFromApplication() {

    }


    @Override
    public boolean isElementPresentAndClickable(String elementText) {
        return false;
    }
}


