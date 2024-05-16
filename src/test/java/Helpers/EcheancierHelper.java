package Helpers;

import Pages.Dashboard;
import Pages.Echeanciers;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EcheancierHelper extends BrowserDriver {

    public WebDriverWait wait;
    public EcheancierHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyProductNameAndIconOnEcheancierMainPage(String product, String icon)
    {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Echeanciers.txtProductName)));
        String extractedEcheancierMainPageProductName = driver.findElement(By.cssSelector(Echeanciers.txtProductName)).getText();
        String extractedEcheancierMainPageIconPath = driver.findElement(By.xpath(Echeanciers.iconContractType)).getAttribute("src");

        // Find the position of "_" and ".svg"
        int underscoreIndex = extractedEcheancierMainPageIconPath.lastIndexOf("_");
        int svgIndex = extractedEcheancierMainPageIconPath.lastIndexOf(".svg");

        // Extract the substring between "_" and ".svg"
        String extractedEcheancierMainPageIcon = extractedEcheancierMainPageIconPath.substring(underscoreIndex + 1, svgIndex);

        Assert.assertEquals(product,extractedEcheancierMainPageProductName);
        Assert.assertEquals(icon,extractedEcheancierMainPageIcon);
    }

    public void verifyEcheancierInitialAndActualise()
    {
        try{
            WebElement txtEcheancierInitial = driver.findElement(By.xpath(Echeanciers.txtEcheancierInitial));
            WebElement txtEcheancierActualise = driver.findElement(By.xpath(Echeanciers.txtEcheancierActualise));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.print("No echeanciers initial/Actualise present on the screen");
        }
    }

    public void clickOnEcheancierInitial()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.txtEcheancierInitial)));
        driver.findElement(By.xpath(Echeanciers.txtEcheancierInitial)).click();
    }

    public void clickOnEcheancierActualise()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Echeanciers.txtEcheancierActualise)));
        driver.findElement(By.xpath(Echeanciers.txtEcheancierActualise)).click();
    }

    public void verifyProductNameAndNumberOfInstallmentsUnderEcheancierInitial(String product, String number_of_installments)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Echeanciers.titleProductName)));
        String extractedProductName = driver.findElement(By.cssSelector(Echeanciers.titleProductName)).getText();
        String extractedNumberOfInstallments = driver.findElement(By.cssSelector(Echeanciers.txtNumberOfInstallments)).getText();

        Assert.assertEquals(product,extractedProductName);
        assert extractedNumberOfInstallments.contains(number_of_installments);

        try{
            WebElement txtInstallmentOne = driver.findElement(By.xpath(Echeanciers.txtInstallmentOne));
            WebElement txtInstallmentTwo = driver.findElement(By.xpath(Echeanciers.txtInstallmentTwo));
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.print("The detailed installments are missing");
        }
    }

    public void verifyProductNameAndNumberOfInstallmentsUnderEcheancierActualise(String product)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(Echeanciers.titleProductName)));
        String extractedProductName = driver.findElement(By.cssSelector(Echeanciers.titleProductName)).getText();
        Assert.assertEquals(product,extractedProductName);
    }
}
