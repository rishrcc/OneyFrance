package StepDefinitions;

import Helpers.CoordonneesHelper;
import Helpers.DashboardHelper;
import Helpers.LoginHelper;
import TestData.LoginData;
import Utility.BrowserDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.openqa.selenium.WebDriver;


public class LoginDef {

    public WebDriver driver;
    public LoginHelper LoginStep;
    public DashboardHelper DashboardStep;

    public LoginDef()
    {
        driver = BrowserDriver.getDriver();
        LoginStep = new LoginHelper(driver);
        DashboardStep = new DashboardHelper(driver);
    }

    @Given("^I am logged in with (.*) and (.*) on weak authentication$")
    public void i_am_logged_in_with_and_on_weak_authentication(String username, String password)
    {
        LoginStep.weakAuthenticationNavigateToUrl();
        LoginStep.closePopUp();
        LoginStep.weakAuthenticationLogin(username,password);
        DashboardStep.closeMobileDownloadPopUp();
    }

    @Given("^I am logged in with (.*) user on weak authentication$")
    public void i_am_logged_in_with_icon_user_on_weak_authentication(String icon)
    {
        LoginStep.weakAuthenticationNavigateToUrl();
        LoginStep.closePopUp();
        LoginStep.weakAuthenticationLogin(icon);
        DashboardStep.closeMobileDownloadPopUp();
    }

}
