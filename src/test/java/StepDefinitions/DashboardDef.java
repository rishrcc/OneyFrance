package StepDefinitions;

import Helpers.DashboardHelper;
import Helpers.EcheancierHelper;
import Helpers.LoginHelper;
import Helpers.ProchainsPrelevementsHelper;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class DashboardDef {

    public WebDriver driver;
    public DashboardHelper DashboardStep;
    public LoginHelper LoginStep;
    public ProchainsPrelevementsHelper ProchainsPrelevementsSteps;
    public EcheancierHelper EcheancierSteps;

    public DashboardDef(){
        driver = BrowserDriver.getDriver();
        LoginStep = new LoginHelper(driver);
        DashboardStep = new DashboardHelper(driver);
        ProchainsPrelevementsSteps = new ProchainsPrelevementsHelper(driver);
        EcheancierSteps = new EcheancierHelper(driver);
    }

    @And("^I am seeing my first name from (.*) on dashboard$")
    public void firstNameDashboard(String fullname)
    {
        DashboardStep.verifyNameOnDashboard(fullname);
    }

    @When("^I click on coordonnees$")
    public void clickOnCoordonnees()
    {
        DashboardStep.clickOnCoordonnees();
    }

    @When("^I click on echeancier$")
    public void clickOnEcheancier()
    {
        DashboardStep.clickOnEcheanciers();
    }

    @When("^I click on prochains prelevements$")
    public void iClickOnProchainsPrelevements()
    {
        DashboardStep.clickOnProchainsPrelevements();
    }

    @When("^I click on product from the side menu$")
    public void clickOnProductName()
    {
        DashboardStep.clickOnProductNameFromSideMenu();
    }

    @Then("^I should see (.*) on the side menu$")
    public void verifyProductNameOnSideMenu(String product)
    {
        DashboardStep.verifySideMenuProductName(product);
    }

    @And("^I should see (.*) and (.*) on the main page$")
    public void verifyProductNameAndIconOnMainPage(String product, String icon)
    {
        DashboardStep.verifyMainPageProductNameAndIcon(product,icon);
    }

    @And("^I should expect to see (.*) and (.*) installments under Mes prochains prelevements$")
    public void verifyProductNameAndNumberOfInstallments(String product,String number_of_installments)
    {
        DashboardStep.verifyProductAndInstallmentsOnPProchainsPrelevement(product,number_of_installments);
    }
}
