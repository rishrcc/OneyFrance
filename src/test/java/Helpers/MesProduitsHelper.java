package Helpers;

import Pages.MesProduits;
import Utility.BrowserDriver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MesProduitsHelper extends BrowserDriver {

    public WebDriverWait wait;

    public MesProduitsHelper(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void verifyProductPageTitle(String title) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MesProduits.titleProduit)));
        String extractedProductTitle = driver.findElement(By.cssSelector(MesProduits.titleProduit)).getText();
        Assert.assertEquals(title, extractedProductTitle);

    }

    public void verifyProductPageSubTitle(String subtitle) {
        String extractedProductSubTitle = driver.findElement(By.cssSelector(MesProduits.subTitleProduit)).getText();
        Assert.assertEquals(subtitle, extractedProductSubTitle);

    }

    public void verifyProductPageLogo(String icon) {
        String extractedProductPageIconPath = driver.findElement(By.cssSelector(MesProduits.iconContractType)).getAttribute("src");

        // Find the position of "_" and ".svg"
        int underscoreIndex = extractedProductPageIconPath.lastIndexOf("_");
        int svgIndex = extractedProductPageIconPath.lastIndexOf(".svg");
        String extractedProductPageIcon = extractedProductPageIconPath.substring(underscoreIndex + 1, svgIndex);

        Assert.assertEquals(icon, extractedProductPageIcon);
    }

    public void verifyProductPageNumberOfInstallment(String number_of_installments) {

        String extractedProductPageNumberOfInstallments = driver.findElement(By.xpath(MesProduits.txtNumberOfInstallments)).getText();
        assert extractedProductPageNumberOfInstallments.contains(number_of_installments);
    }

    public void clickOnChangeCard()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(MesProduits.lnkChangeCarteDePrelevement)));
        driver.findElement(By.cssSelector(MesProduits.lnkChangeCarteDePrelevement)).click();
    }
}
