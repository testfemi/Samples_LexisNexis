//package factory;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class DriverFactory {
//    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//
//    public static WebDriver getDriver() {
//        return driver.get();
//    }
//
//    public static void setWebDriver(WebDriver webdriver) {
//        driver.set(webdriver);
//    }
//
//    public static void closeDriver() {
//        if (driver.get() != null) {
//            driver.get().quit();
//            driver.remove();
//        }
//    }
//}
