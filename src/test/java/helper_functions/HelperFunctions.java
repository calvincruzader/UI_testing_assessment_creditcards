package helper_functions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class HelperFunctions {

    private HashMap<String,String> driverPaths;

    public HelperFunctions() {
        driverPaths = new HashMap<String,String>();
        driverPaths.put("firefox","src\\test\\resources\\geckodriver.exe");
        driverPaths.put("ie", "src\\test\\resources\\IEDriverServer.exe");
        driverPaths.put("chrome", "src\\test\\resources\\chromedriver.exe");
    }

    public String getGeckoDriver() {
        return driverPaths.get("firefox");
    }
    public String getIEDriverServer() {
        return driverPaths.get("ie");
    }
    public String getChromeDriver() {
        return driverPaths.get("chrome");
    }

    public boolean verifyElementAbsent(WebDriver driver, String locator) throws Exception {
        try {
            driver.findElement(By.xpath(locator));
            System.out.println("Element Present");
            return false;

        } catch (NoSuchElementException e) {
            System.out.println("Element absent");
            return true;
        }
    }
}
