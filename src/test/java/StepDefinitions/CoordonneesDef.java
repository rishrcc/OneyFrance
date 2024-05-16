package StepDefinitions;

import Helpers.CoordonneesHelper;
import Utility.BrowserDriver;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class CoordonneesDef {
    public WebDriver driver;
    public CoordonneesHelper CoordonneesStep;

    public CoordonneesDef(){
        driver = BrowserDriver.getDriver();
        CoordonneesStep = new CoordonneesHelper(driver);
    }

    @Then("^I should see the (.*)$")
    public void verifyFullName(String fullname)
    {
        CoordonneesStep.verifyFullname(fullname);
    }
}
