import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class LoginTest {
    @Test

    public void loginWithValidCredential() throws Exception {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.findElement(By.className("global-header-section-button")).click();
        driver.findElement(By.id("user")).sendKeys("diana.camelia.tapu@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Emanuel.1");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector(".header-btn-text.js-member-name")).getText()
                .contains("Diana Tapu"));
        driver.findElement(By.cssSelector("a.board-tile.mod-add")).click();
        driver.findElement(By.id("boardNewTitle")).sendKeys("Work");
        driver.findElement(By.cssSelector(".primary.wide.js-submit")).click();
        driver.findElement(By.className(".list-name-input")).sendKeys("");





    }

    @Test
    public void loginWithNoEmail() {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.findElement(By.className("global-header-section-button")).click();
        driver.findElement(By.id("user")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("Emanuel.1");
        driver.findElement(By.id("login")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("p.error-message")).getText()
                .contains("Missing email"));
        driver.quit();

    }

    @Test
    public void loginWithNoparola() throws Exception {
        WebDriver driver = new FirefoxDriver();

        driver.get("https://trello.com/");
        driver.findElement(By.className("global-header-section-button")).click();
        driver.findElement(By.id("user")).sendKeys("diana.camelia.tapu@gmail.com");
        driver.findElement(By.id("password")).sendKeys("");
        driver.findElement(By.id("login")).click();
        Thread.sleep(2000);
        Assert.assertTrue(driver.findElement(By.cssSelector("p.error-message")).getText()
                .contains("Invalid password"));
        driver.quit();


    }

    @Test
    public void testDropdown() {
        String facebooklink = "https://www.facebook.com/";
        WebDriver driver = new FirefoxDriver();
        driver.get(facebooklink);
        Select dropdown = new Select(driver.findElement(By.id("month")));
        dropdown.selectByVisibleText("Mar");
        Select dropdown1 = new Select(driver.findElement(By.id("day")));
        dropdown1.selectByValue("13");
        Select dropdown2 = new Select(driver.findElement(By.id("year")));
        dropdown2.selectByIndex(3);

        driver.quit();

    }

    @Test
    public void adtoChard() throws Exception {
        String emag = "http://m.emag.ro/";
        WebDriver driver = new FirefoxDriver();
        driver.get(emag);
        driver.findElement(By.id("m7")).click();
        driver.findElement(By.id("c466")).click();
        driver.findElement(By.cssSelector("a[href*='3682536/c']")).click();
        driver.findElement(By.cssSelector("a[href*='ERD47HBBM']")).click();
        //      driver.findElement(By.cssSelector("button[data-offer-id='10326156']")).click();
        try {
            driver.findElement(By.cssSelector("button[data-offer-id='1032615']")).isDisplayed();
            System.out.println("true");
        } catch (Exception e) {
            System.out.println("false");
            System.out.println(e);
        }

        //       Thread.sleep(1000);
        //       Assert.assertTrue(driver.findElement(By.cssSelector("h4[class='mrg-sep-none']")).getText()
//                .contains("Produsul a fost adaugat in cos"));

//        driver.quit();


    }
    @Test
    public void findHeding()throws Exception{
        WebDriver driver = new FirefoxDriver();
        String trello = "https://trello.com/";
        driver.get(trello);
        Thread.sleep(2000);
        WebElement n =driver.findElement(By.tagName("h1"));
        System.out.println(n.getText());

    }

}



