package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class HomePage extends BasePage{

    String baseUrl = "https://www.creditcards.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void goToBaseUrl() {
        driver.get(baseUrl);
    }

    public WebElement getNavBarDropdown(String name) {
        WebElement webElementReturned;
        switch(name) {
            case "card category" : webElementReturned = this.getDropdownCardCategory(); break;
            case "card issuer"   : webElementReturned = this.getDropdownCardIssuer(); break;
            case "credit range"  : webElementReturned = this.getDropdownCreditRange(); break;
            case "tools"         : webElementReturned = this.getDropdownTools(); break;
            case "resources"     : webElementReturned = this.getDropdownResources(); break;
            default              : webElementReturned = null; break;
        }

        return webElementReturned;
    }

    public HashMap<String, WebElement> getElementsNavBar() {
        HashMap<String, WebElement> elementsNavBar = new HashMap<>();
        elementsNavBar.put("card category", this.getElementCardCategory());
        elementsNavBar.put("card issuer", this.getElementCardIssuer());
        elementsNavBar.put("credit range", this.getElementCreditRange());
        elementsNavBar.put("tools", this.getElementToolsNavBar());
        elementsNavBar.put("resources", this.getElementResourcesNavBar());
        return elementsNavBar;
    }

    public HashMap<String, WebElement> getCreditScoreButtons() {
        HashMap<String, WebElement> creditScoreButtons = new HashMap<>();
        creditScoreButtons.put("excellent",this.getExcellentButton());
        creditScoreButtons.put("good", this.getGoodButton());
        creditScoreButtons.put("fair", this.getFairButton());
        creditScoreButtons.put("needs work", this.getNeedsWorkButton());
        creditScoreButtons.put("no credit", this.getNoCreditButton());

        return creditScoreButtons;
    }

    public WebElement getCreditOptionDropdown(String rating) {
        WebElement dropdownToReturn;
        switch(rating) {
            case "excellent" : dropdownToReturn = this.getExcellentDropdown(); break;
            case "good"      : dropdownToReturn = this.getGoodDropdown(); break;
            case "fair"      : dropdownToReturn = this.getFairDropdown(); break;
            case "needs work": dropdownToReturn = this.getNeedsWorkDropdown(); break;
            case "no credit" : dropdownToReturn = this.getNoCreditDropdown(); break;
            default          : dropdownToReturn = null; break;
        }

        return dropdownToReturn;
    }

    public WebElement getElementCardCategory() {
        return driver.findElement(By.xpath("//header[@role='banner']/nav[@role='navigation']/ul[@class='menu']/li[1]/a[@href='#']"));
    }

    public WebElement getElementCardIssuer() {
        return driver.findElement(By.xpath("//header[@role='banner']/nav[@role='navigation']/ul[@class='menu']/li[2]/a[@href='#']"));
    }

    public WebElement getElementCreditRange() {
        return driver.findElement(By.xpath("//header[@role='banner']/nav[@role='navigation']/ul[@class='menu']/li[3]/a[@href='#']"));
    }

    public WebElement getElementToolsNavBar() {
        return driver.findElement(By.xpath("//header[@role='banner']/nav[@role='navigation']/ul[@class='menu']/li[4]/a[@href='#']"));
    }

    public WebElement getElementResourcesNavBar() {
        return driver.findElement(By.xpath("//header[@role='banner']/nav[@role='navigation']/ul[@class='menu']/li[5]/a[@href='#']"));
    }

    public WebElement getDropdownCardCategory() {
        return driver.findElement(By.xpath("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']//ul[@class='menu__submenu menu__submenu--4-column']"));
    }

    public WebElement getDropdownCardIssuer() {
        return driver.findElement(By.xpath("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']//ul[@class='menu__submenu menu__submenu--3-column']"));
    }

    public WebElement getDropdownCreditRange() {
        return driver.findElement(By.xpath("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']//ul[@class='menu__submenu menu__submenu--2-column']"));
    }

    public WebElement getDropdownTools() {
        return driver.findElement(By.xpath("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']/li[4]/ul[@class='menu__submenu menu__submenu--1-column']//ul[@class='menu__submenu-column']"));
    }

    public WebElement getDropdownResources() {
        return driver.findElement(By.xpath("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']/li[5]/ul[@class='menu__submenu menu__submenu--1-column']//ul[@class='menu__submenu-column']"));
    }

    public WebElement getBalanceTransferLink() {
        return driver.findElement(By.xpath("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']//ul[@class='menu__submenu menu__submenu--4-column']/li/ul[2]//a[@href='/balance-transfer/']"));
    }

    public WebElement getBoxInitialState() {
        // Initial text which changes after clicking one of the main buttons
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContent cardFinder__tabContent--default']"));
    }

    public WebElement getExcellentButton() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContainer']/label[1]"));
    }

    public WebElement getGoodButton() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContainer']/label[2]"));
    }

    public WebElement getFairButton() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContainer']/label[3]"));
    }

    public WebElement getNeedsWorkButton() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContainer']/label[4]/strong[.='Needs Work']"));
    }

    public WebElement getNoCreditButton() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//label[@class='cardFinder__tab cardFinder__tab--limited']/strong[.='Limited / No Credit']"));
    }

    public WebElement getExcellentDropdown() {
        return driver.findElement(By.xpath("/html/body/div[1]/main/section[1]/div[1]/form/div[2]/div[1]/div[1]"));
    }

    public WebElement getGoodDropdown() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContent cardFinder__tabContent--good']"));
    }

    public WebElement getFairDropdown() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContent cardFinder__tabContent--fair']"));
    }

    public WebElement getNeedsWorkDropdown() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContent cardFinder__tabContent--needsWork']"));
    }

    public WebElement getNoCreditDropdown() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//form[@name='cardFinder']//div[@class='cardFinder__tabContent cardFinder__tabContent--noCredit']"));
    }

    public WebElement getPointGuyImg() {
        return driver.findElement(By.xpath("/html/body[@class='']//main[@role='main']/section[@class='homePage-hero']//img[@alt='The Points Guy logo']"));
    }

    public WebElement getHamburger() {
        return driver.findElement(By.cssSelector(".menu__logo-wrapper div"));
    }

    public WebElement getSmallMenu() {
//        return driver.findElement(By.css("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']"));
        return driver.findElement(By.cssSelector("[class='menu__submenu menu__submenu--3-column'] li:nth-of-type(1) .menu__submenu-column:nth-of-type(1)"));
    }

    public WebElement getSmallCardIssuer() {
        return driver.findElement(By.xpath("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']/li[2]/a[@href='#']"));
    }

    public WebElement getSmallCardIssuerDropdown() {
        return driver.findElement(By.xpath("//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']//ul[@class='menu__submenu menu__submenu--3-column menu__submenu--visible']/li/ul[1]"));
    }

    public String getSmallCardIssuerDropdownLocator() {
        return "//div[@class='boxy']/header[@role='banner']/header[@role='banner']/nav[@role='navigation']/ul[@class='menu']//ul[@class='menu__submenu menu__submenu--3-column menu__submenu--visible']/li/ul[1]";
    }

    public WebElement getCopyrightFooter() {
        return driver.findElement(By.xpath("/html/body/div[1]/footer"));
    }

    public WebElement getAdDisclosureButton() {
        return driver.findElement(By.xpath("/html//main[@role='main']/section[@class='homePage-hero']//label[@class='homePage-hero__adDisclosure']"));
    }
}
