import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MetatitleMetadescription {

    @Test
    public void findMetaTitleandMetaDescription() throws Exception {
        WebDriver driver = new FirefoxDriver();
        driver.get("http://xxxxxxxxxxx.ro/");
        Thread.sleep(2000);
        String N = driver.getTitle();
        int lungimetitlu = N.length();
        if (!(N.equals(""))) {
            System.out.println("Titlul principal este: " + N);
            System.out.println("Numarul stringului este:  " + lungimetitlu);
        } else {
            System.out.println("Pagina nu are meta title");

        }

        WebElement metadescription = driver.findElement(By.xpath("//meta[@name='description']"));
        String M = metadescription.getAttribute("content");
        int lungimedescription = M.length();
        if (!(M.equals(""))) {
            System.out.println("Descrierea este: " + M);
            System.out.println("Nr caractere descriere: " + lungimedescription);
        } else {
            System.out.println("Pagina nu are descriere");

        }


    }
}












