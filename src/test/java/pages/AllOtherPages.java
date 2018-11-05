package pages;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;

// Overall a
public class AllOtherPages extends BasePage {

    private HashMap<String, String> pageUrls;

    public AllOtherPages(WebDriver driver) {
        super(driver);
        pageUrls = new HashMap<>();
        pageUrls.put("best credit cards" , "https://www.creditcards.com/best-credit-cards/");
        pageUrls.put("rewards cards" , "https://www.creditcards.com/rewards-cards/");
        pageUrls.put("sign up bonuses" , "https://www.creditcards.com/signup-bonuses/");
        pageUrls.put("cash back" , "https://www.creditcards.com/cash-back/");
        pageUrls.put("balance transfer", "https://www.creditcards.com/balance-transfer/");
        pageUrls.put("zero APR", "https://www.creditcards.com/zero-interest/");
        pageUrls.put("no annual fee", "https://www.creditcards.com/no-annual-fee/");
        pageUrls.put("low interest", "https://www.creditcards.com/low-interest/");
        pageUrls.put("travel", "https://www.creditcards.com/travel/");
        pageUrls.put("airline", "https://www.creditcards.com/airline-miles/");
        pageUrls.put("hotel", "https://www.creditcards.com/hotel/");
        pageUrls.put("no foreign transaction fee", "https://www.creditcards.com/no-foreign-transaction-fee/");
        pageUrls.put("business", "https://www.creditcards.com/business/");
        pageUrls.put("student", "https://www.creditcards.com/student/");
        pageUrls.put("gas", "https://www.creditcards.com/gas/");
    }

    public String getUrl(String name) {
        return pageUrls.get(name);
    }
}
