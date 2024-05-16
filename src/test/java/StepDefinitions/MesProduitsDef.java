package StepDefinitions;

import Helpers.MesProduitsHelper;
import Utility.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class MesProduitsDef {

    public WebDriver driver;
    public MesProduitsHelper MesProduitsStep;

    public MesProduitsDef(){
        driver = BrowserDriver.getDriver();
        MesProduitsStep = new MesProduitsHelper(driver);
    }

    @Then("^I should see (.*) as title$")
    public void verifyProductPageTitle(String title)
    {
        MesProduitsStep.verifyProductPageTitle(title);
    }

    @And("^I should see (.*) as subtitle$")
    public void verifyProductPageSubTitle(String subtitle)
    {
        MesProduitsStep.verifyProductPageSubTitle(subtitle);
    }

    @And("^I should see (.*) as logo$")
    public void verifyProductPageLogo(String icon)
    {
        MesProduitsStep.verifyProductPageLogo(icon);
    }

    @And("^I should see (.*) as number of installments in the payment information$")
    public void i_should_see_number_of_installments_in_payment_info(String number_of_installments)
    {
        MesProduitsStep.verifyProductPageNumberOfInstallment(number_of_installments);
    }

    @Then("^I click on change card$")
    public void i_click_on_change_card_link()
    {
        MesProduitsStep.clickOnChangeCard();
    }
}
