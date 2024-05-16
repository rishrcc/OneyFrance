package StepDefinitions;

import Helpers.EcheancierHelper;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class EcheancierDef {

    public WebDriver driver;
    public EcheancierHelper EcheancierStep;

    public EcheancierDef()
    {
        driver = BrowserDriver.getDriver();
        EcheancierStep = new EcheancierHelper(driver);
    }

    @Then("^I should be able to see (.*) and the (.*) on the echeancier main screen$")
    public void iShouldBeAbleToSeeProductAndIconOnEcheancierMainScreen(String product, String icon)
    {
        EcheancierStep.verifyProductNameAndIconOnEcheancierMainPage(product,icon);
    }

    @And("^I should see echeancier initial and echeancier actualise$")
    public void iShouldSeeEcheancierInitialAndEcheancierActualise()
    {
        EcheancierStep.verifyEcheancierInitialAndActualise();
    }

    @And("^I click on echeancier initial$")
    public void iClickOnEcheancierInitial()
    {
        EcheancierStep.clickOnEcheancierInitial();
    }

    @Then("^I should be able to see (.*) and the (.*) on the echeancier initial screen$")
    public void iShouldSeeProductAndNumberOfInstallmentsOnEcheancierInitialScreen(String product, String number_of_installments)
    {
        EcheancierStep.verifyProductNameAndNumberOfInstallmentsUnderEcheancierInitial(product,number_of_installments);
    }

    @And("^I click on echeancier actualise$")
    public void iClickOnEcheancierActualise()
    {
        EcheancierStep.clickOnEcheancierActualise();
    }

    @Then("^I should be able to see (.*) on the echeancier actualise screen$")
    public void iShouldSeeProductAndNumberOfInstallmentsOnEcheancierActualiseScreen(String product)
    {
        EcheancierStep.verifyProductNameAndNumberOfInstallmentsUnderEcheancierActualise(product);
    }
}
