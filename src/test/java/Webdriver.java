import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.w3c.dom.css.ElementCSSInlineStyle;
import java.util.concurrent.TimeUnit;
public class Webdriver {
    public static void main(String[] args) throws InterruptedException {
        // Setting system properties of ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
        // Creating an object of ChromeDriver
        WebDriver driver = new ChromeDriver();
        // Deschidem url
        driver.get("https://formy-project.herokuapp.com/form");
        // same as
        // driver.navigate().to("https://formy-project.herokuapp.com/form");
        // maximiza fereastra
        driver.manage().window().maximize();
        // Deleting all the cookies
        driver.manage().deleteAllCookies();
        // refresh page
        driver.navigate().refresh();
        // back si fw
        // driver.navigate().back();
        // driver.navigate().forward();
        // Specifiying pageLoadTimeout and Implicit wait
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS); // cat timp sa asteptam pentru a se incarca pagina
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // cat timp asteptam pentru gasirea elementelor
        // find element by ID and save it a variable of type WebElement
        // completam first name
        WebElement first_name_input = driver.findElement(By.id("first-name"));
        first_name_input.sendKeys("andy");
        // clear input value
        first_name_input.clear();
        // type again
        first_name_input.sendKeys("Andy");
        // find by name
        // driver.findElement(By.name("btnK")).click();
        // by link text (elementul este a)
        // driver.findElement(By.linkText("Submit")).click();
        // by partial link text
        // driver.findElement(By.partialLinkText("Sub")).click();
        // by xpath: //element[@attribute='value']
        // completam last name
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("Sinpetrean");
        // by xpath: element text (ce e cu negru)
        // am navigat spre parinte si spre copii
        driver.findElement(By.xpath("//label[text()='Job title']/parent::strong/parent::div//input")).sendKeys("tester");
        // by xpath : urmatorul frate (avem si preceding-sibling
        // completam job title
        driver.findElement(By.xpath("//label[text()='Job title']/parent::strong/following-sibling::input")).sendKeys("automation engineer");
        // open dropdown
        driver.findElement(By.xpath("//select[@id='select-menu']")).click();
        // select an element based by index (starts from 1)
        driver.findElement(By.xpath("(//option[@value])[1]")).click();
        // find a list of elements, click first elem.
        driver.findElements(By.xpath("//option[@value]")).get(0).click();
        // explicit wait
        // dropdown care se deschide greu
        // inainte sa dam click, asteptam elemetul sa fie incarcat
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement elementToWait = driver.findElement(By.xpath("//option[text()='10+']"));
        wait.until(ExpectedConditions.elementToBeClickable(elementToWait));
        elementToWait.click();
        // pauza
        Thread.sleep(3000);
        // by xpath: dupa partial text, *=orice element
        // click submit
        driver.findElement(By.xpath("//*[contains(text(), 'Sub')]")).click();
        // verify page title
        Assert.assertEquals(driver.getTitle(), "Formy");
        // verify page URL
        Assert.assertTrue(driver.getCurrentUrl().contains("/thanks"));
        // verify element text (mesajul)
        Assert.assertEquals(driver.findElement(By.xpath("//div[@role='alert']")).getText(), "The form was successfully submitted!");
        // inchidem chrome
        driver.quit();
    }
}