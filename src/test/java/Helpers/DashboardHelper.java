package Helpers;

import Pages.Dashboard;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class DashboardHelper extends BrowserDriver {

    public WebDriverWait wait;

    public DashboardHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyNameOnDashboard(String fullname)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtFirstName)));
        String extractedFirstName = driver.findElement(By.cssSelector(Dashboard.txtFirstName)).getText();
        String[] nameParts = fullname.split(" ");
        String firstName = nameParts[0];
        Assert.assertEquals(firstName,extractedFirstName);
    }

    public void clickOnCoordonnees()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.lnkCoordonnees)));
        driver.findElement(By.xpath(Dashboard.lnkCoordonnees)).click();
    }

    public void clickOnEcheanciers()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.lnkEcheanciers)));
        driver.findElement(By.xpath(Dashboard.lnkEcheanciers)).click();
    }

    public void clickOnProchainsPrelevements()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.lnkProchainsPrelevements)));
        driver.findElement(By.xpath(Dashboard.lnkProchainsPrelevements)).click();
    }

    public void closeMobileDownloadPopUp()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Dashboard.titlePopMobileAppDownload)));
        driver.findElement(By.xpath(Dashboard.btnCloseMobileAppDownloadPopUp)).click();
    }

    public void verifySideMenuProductName(String product)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtSideMenuProductName)));
        String extractedSideMenuProduct = driver.findElement(By.cssSelector(Dashboard.txtSideMenuProductName)).getText();
        Assert.assertEquals(product,extractedSideMenuProduct);

    }

    public void verifyMainPageProductNameAndIcon(String product, String icon)
    {
        String extractedMainPageProductName = driver.findElement(By.cssSelector(Dashboard.txtMainPageProductName)).getText();
        String extractedMainPageIconPath = driver.findElement(By.cssSelector(Dashboard.iconMainPageProduct)).getAttribute("src");

        // Find the position of "_" and ".svg"
        int underscoreIndex = extractedMainPageIconPath.lastIndexOf("_");
        int svgIndex = extractedMainPageIconPath.lastIndexOf(".svg");

        // Extract the substring between "_" and ".svg"
        String extractedMainPageIcon = extractedMainPageIconPath.substring(underscoreIndex + 1, svgIndex);

        Assert.assertEquals(product,extractedMainPageProductName);
        Assert.assertEquals(icon,extractedMainPageIcon);

    }

    public void verifyProductAndInstallmentsOnPProchainsPrelevement(String product, String number_of_installments)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtMesProchainsPrelevements)));
        String extractedProductName = driver.findElement(By.cssSelector(Dashboard.txtMesProchainsPrelevements)).getText();
        String extractedNumberOfInstallments = driver.findElement(By.cssSelector(Dashboard.txtNumberOfInstallments)).getText();

        assert extractedProductName.contains(product);
        assert extractedNumberOfInstallments.contains(number_of_installments);

    }

    public void clickOnProductNameFromSideMenu()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtSideMenuProductName)));
        driver.findElement(By.cssSelector(Dashboard.txtSideMenuProductName)).click();
    }

    public void verifyWelcomeScreen()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Dashboard.txtWelcome)));
        String txtWelcomeName = driver.findElement(By.cssSelector(Dashboard.txtWelcome)).getText();
        assert txtWelcomeName.contains("Bienvenue");

    }
}
