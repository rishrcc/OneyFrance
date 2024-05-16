package Helpers;

import Pages.Echeanciers;
import Pages.ProchainsPrelevements;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProchainsPrelevementsHelper extends BrowserDriver {

    public WebDriverWait wait;

    public ProchainsPrelevementsHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyProductNameAndIconOnProchainsPrelevementsPage(String product, String icon)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(ProchainsPrelevements.txtProductNameProchainPrelevement)));
        String extractedProchainsPrelevementsProductName = driver.findElement(By.cssSelector(ProchainsPrelevements.txtProductNameProchainPrelevement)).getText();
        String extractedProchainsPrelevementsIconPath = driver.findElement(By.cssSelector(ProchainsPrelevements.iconContractTypeProchainPrelevement)).getAttribute("src");

        // Find the position of "_" and ".svg"
        int underscoreIndex = extractedProchainsPrelevementsIconPath.lastIndexOf("_");
        int svgIndex = extractedProchainsPrelevementsIconPath.lastIndexOf(".svg");

        // Extract the substring between "_" and ".svg"
        String extractedProchainsPrelevementsPageIcon = extractedProchainsPrelevementsIconPath.substring(underscoreIndex + 1, svgIndex);

        Assert.assertEquals(product,extractedProchainsPrelevementsProductName);
        Assert.assertEquals(icon,extractedProchainsPrelevementsPageIcon);
    }
}
