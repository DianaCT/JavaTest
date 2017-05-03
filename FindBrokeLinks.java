import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class FindBrokeLinks {

    public static List findAllLinks(WebDriver driver) throws Exception {
        List<WebElement> elementList = new ArrayList<WebElement>();
        elementList = driver.findElements(By.tagName("a"));
        elementList.addAll(driver.findElements(By.tagName("img")));
        List finalList = new ArrayList();
        ;
        for (WebElement element : elementList) {
            if (element.getAttribute("href") != null) {
                finalList.add(element);
            }
        }
        return finalList;
    }

    public static int isLinkBroken(URL url) throws Exception {
        url = new URL("http://xxxxxxxxxxxxx.ro/");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            connection.connect();
            int responseCode = connection.getResponseCode();
            connection.disconnect();
            return responseCode;
        } catch (Exception e) {
            return 0;
        }
    }

    @Test
    public static void findbrokenlink() throws Exception {
        String bt = "http://xxxxxxxxxxxxxx.ro/";
        WebDriver driver = new FirefoxDriver();
        driver.get(bt);
        List<WebElement> allImages = findAllLinks(driver);
        System.out.println("Total number of elements found " + allImages.size());
        int goodlink = 0;
        int brokenlink = 0;
        for (WebElement element : allImages) {
            try {
                if (isLinkBroken(new URL(element.getAttribute("href"))) != 0) {
                    goodlink++;
                } else {
                    brokenlink++;
                }
                //               System.out.println("URL: " + element.getAttribute("href")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
                //               a++;
                //System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned " + isLinkBroken(new URL(element.getAttribute("href"))));
            } catch (Exception exp) {
                System.out.println("At " + element.getAttribute("innerHTML") + " Exception occured -&gt; " + exp.getMessage());

            }

        }
        System.out.println(goodlink + "  " + "  " + brokenlink);

    }

}







