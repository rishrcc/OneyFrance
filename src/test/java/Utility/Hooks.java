package Utility;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public static String scenarioName;
    public WebDriver driver;

    @Before
    public void setup()
    {
        driver = BrowserDriver.getDriver();
    }

    @Before
    public void startRecording(Scenario scenario) throws Exception
    {
        scenarioName = scenario.getName();
        TestRecorder.startRecording("src/test/java/Recording/" + scenarioName);
    }

    @AfterStep
    public void takeScreenshotAfterEachStep(Scenario scenario)
    {
        BrowserDriver.takeScreenshotAfterStep(scenario);
    }

    @After
    public  void tearDown(Scenario scenario) throws Exception {
        TestRecorder.stopRecording();
        BrowserDriver.quitDriver(scenario);
    }

}

