package drivers;

import data.BrowsersData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/**
 * Конфигурация Selenium WebDriver
 */
public final class WebDriverFactory {

    public static WebDriver getWebDriverInstance(BrowsersData browser) {
        switch (browser) {
            case Chrome:
                WebDriver driver = new ChromeDriver(getBaseChromeOptions());
                driver.manage().timeouts().implicitlyWait(
                        Long.parseLong(System.getProperty("webdriver.timeouts.implicitlywait")),
                        TimeUnit.MILLISECONDS);
                return driver;
            default:
                return null;
        }
    }

    private static ChromeOptions getBaseChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");

        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.PERFORMANCE, Level.INFO);

        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

        return chromeOptions;
    }

}
