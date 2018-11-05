package pages;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void resizeBrowser(int width, int height) {
        Dimension d = new Dimension(width, height);
        driver.manage().window().setSize(d);
    }
}
