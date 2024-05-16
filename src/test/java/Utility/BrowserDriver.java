package Utility;

import com.google.common.collect.ImmutableMap;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.ByteArrayInputStream;



public class BrowserDriver {
    public static WebDriver driver;

    public BrowserDriver(WebDriver driver)
    {

        BrowserDriver.driver = driver;
    }

    public static WebDriver getDriver()
    {
        if (driver == null) {
            //System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
/*
            // Set mobile emulation options
            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("mobileEmulation",
                    ImmutableMap.of("deviceName", "iPhone 6")); // Adjust deviceName accordingly

            // Create WebDriver instance
            driver = new ChromeDriver(options);
*/

        }
        return driver;
    }

    public static void takeScreenshotAfterStep(Scenario scenario)
    {
        byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Step Screenshot", new ByteArrayInputStream(screenshot));
    }

    public static void quitDriver(Scenario scenario)
    {
        if (driver != null) {
            if (scenario.isFailed())
            {
                byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
                Allure.addAttachment("Failed Screenshot", new ByteArrayInputStream(screenshot));
            }
            driver.quit();
            driver = null;
        }
    }
}
