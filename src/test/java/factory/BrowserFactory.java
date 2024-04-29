package factory;

import enums.BrowserOptions;
import helper.Log;
import helper.ScenarioContext;
import helper.TestConfig;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.*;

/**
 * Utility class which configures the {@link DesiredCapabilities} for the browser
 * of the {@link WebDriver} and ensures each test thread has its own WebDriver instance.
 */
public class BrowserFactory {

    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return driverThreadLocal.get();
    }

    public static void setWebDriver(WebDriver driver) {
        driverThreadLocal.set(driver);
    }

    public static void closeDriver() {
        if (driverThreadLocal.get() != null) {
            driverThreadLocal.get().quit();
            driverThreadLocal.remove();
        }
    }

    public static WebDriver initialiseBrowser(DesiredCapabilities caps) {
        ScenarioContext.browser = BrowserOptions.valueOf(TestConfig.getPropertyValue("browser").toUpperCase());
        caps.setBrowserName(ScenarioContext.browser.browserName());
        PageLoadStrategy pls = PageLoadStrategy.NORMAL;
        caps.setCapability(CapabilityType.PAGE_LOAD_STRATEGY, pls);

        WebDriver driver;
        switch (ScenarioContext.browser) {
            case CHROME -> {
                ChromeOptions ops = new ChromeOptions();
                ops.addArguments("--remote-allow-origins=*");
                ops = ops.merge(caps);
                driver = new ChromeDriver(ops);
            }
            case IE -> {
                driver = new InternetExplorerDriver();
            }
            case EDGE -> {
                driver = new EdgeDriver();
            }
            case FIREFOX -> {
                driver = new FirefoxDriver();
            }
            default -> throw new WebDriverException("No default browser configuration available. You must specify a browser.");
        }
        setWebDriver(driver);
        return getDriver();
    }
}
