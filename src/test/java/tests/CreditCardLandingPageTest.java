package tests;

import helper_functions.HelperFunctions;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import pages.AllOtherPages;
import pages.HomePage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class CreditCardLandingPageTest {
    private HelperFunctions helperFunc;
    private HomePage homePage;
    private WebDriver driver;
    private AllOtherPages otherPages;

    @Parameters("browser")
    @BeforeClass
    public void startDriver(String browser) {
         helperFunc = new HelperFunctions();

        if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", helperFunc.getGeckoDriver());
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", helperFunc.getIEDriverServer());
            driver = new InternetExplorerDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", helperFunc.getChromeDriver());
            driver = new ChromeDriver();
        }

        homePage = new HomePage(driver);
        homePage.goToBaseUrl();

        otherPages = new AllOtherPages(driver);
    }

    @Test
    public void verifyNavBarItemHoverAndLinks() {
        homePage.maximizeWindow();

        HashMap<String, WebElement> elementsNavBar = homePage.getElementsNavBar();

        for (String elementName : elementsNavBar.keySet()) {
            WebElement elementDropdown = homePage.getNavBarDropdown(elementName);
            Assert.assertFalse(elementDropdown.isDisplayed(), "Expected dropdown menu to not be displayed, but it was.");
            Actions action = new Actions(driver);
            action.moveToElement(elementsNavBar.get(elementName)).build().perform();
            Assert.assertTrue(elementDropdown.isDisplayed(), "Expected dropdown menu to be displayed but it was not.");
        }

        // test for only one dropdown link's functionality for now as the whole impl might take too long with my current knowledge
        String elementName = "card category";
        WebElement elementDropdown = elementsNavBar.get(elementName);
        Actions action = new Actions(driver);
        action.moveToElement(elementsNavBar.get(elementName)).build().perform();
        Assert.assertTrue(elementDropdown.isDisplayed());
        WebElement elementBalanceTransferLink = homePage.getBalanceTransferLink();

        // click on a dropdown link
        action.moveToElement(elementBalanceTransferLink).click().build().perform();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        boolean correctLink = wait.until(ExpectedConditions.urlToBe(otherPages.getUrl("balance transfer")));

        Assert.assertTrue(correctLink, "Expected URL to go to " + otherPages.getUrl("balance transfer") + " after clicking link, instead URL is: " + driver.getCurrentUrl());
    }

    @Test
    public void verifyCreditScoreButtonsAndDropdown() {
        homePage.maximizeWindow();
        String initialText = "Select your credit score above to see the top categories for you";
        WebElement boxInitialState = homePage.getBoxInitialState();
        Assert.assertEquals(boxInitialState.getText(), "Select your credit score above to see the top categories for you", "Expected initial text to be: " + initialText + " , but instead was: " + boxInitialState.getText());

        HashMap<String, WebElement> creditScoreButtons = homePage.getCreditScoreButtons();

        for (String rating : creditScoreButtons.keySet()) {
            WebElement creditOptionDropdown = homePage.getCreditOptionDropdown(rating);

            Actions action = new Actions(driver);
            action.moveToElement(creditScoreButtons.get(rating)).build().perform();
            Assert.assertFalse(creditOptionDropdown.isDisplayed(), "Expected dropdown to not appear when only hovering over the button, instead the dropdown appeared.");

            action.moveToElement(creditScoreButtons.get(rating)).click().build().perform();
            WebDriverWait wait = new WebDriverWait(driver, 15);
            WebElement credOptionDropdown = wait.until(ExpectedConditions.visibilityOf(creditOptionDropdown));
            Assert.assertTrue(credOptionDropdown.isDisplayed(), "Expected dropdown to appear when button is clicked, instead dropdown did not appear.");

            WebElement placeToMoveAwayTo = homePage.getPointGuyImg();
            action.moveToElement(placeToMoveAwayTo).build().perform();
            Assert.assertTrue(credOptionDropdown.isDisplayed(), "Expected dropdown to remain even when cursor moves away from button, instead display disappears.");
        }
    }

    @Test
    public void verifySmallerWindowFunctionality() throws Exception {
        int smallWidth = 555, smallHeight = 555;
        homePage.resizeBrowser(smallWidth,smallHeight);

        TimeUnit.SECONDS.sleep(5); // A bit ugly, but I don't know how to wait for this burger icon to show up with what I've set up.
        WebElement elementHamburger = homePage.getHamburger();
        Assert.assertTrue(elementHamburger.isDisplayed(), "Expected hamburger menu icon to be displayed, instead it was not.");

        Actions action = new Actions(driver);
        action.moveToElement(elementHamburger).click().build().perform();

        TimeUnit.SECONDS.sleep(10);
        WebElement smallMenu = homePage.getSmallMenu();
        Assert.assertTrue(smallMenu.isDisplayed(), "Expected small menu to be displayed, instead it was not.");

        Assert.assertTrue(helperFunc.verifyElementAbsent(driver, homePage.getSmallCardIssuerDropdownLocator()), "Dropdown should not be present until after clicking, instead found it is already present.");
        WebElement smallCardIssuer = homePage.getSmallCardIssuer();
        action.moveToElement(smallCardIssuer).click().build().perform();

        WebElement smallCardIssuerDropdown = homePage.getSmallCardIssuerDropdown();
        Assert.assertTrue(smallCardIssuerDropdown.isDisplayed(), "Expect small (mobile version) of card issuer dropdown to be displayed after a button press, yet it was not.");
    }

    @Test
    public void verifyDisclosuresAndCopyRights() {
        WebElement copyrightFooter = homePage.getCopyrightFooter();

        Assert.assertTrue(copyrightFooter.getText().contains("Copyright 2018 CreditCards.com. All Rights Reserved"));
    }

    @AfterClass
    public void shutDownDriver() {
        driver.quit();
    }
}