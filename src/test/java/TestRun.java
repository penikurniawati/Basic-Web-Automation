
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class TestRun {

  @Test
  public void testRunWebAutomation() throws InterruptedException {
    //    String quoteLocator = "inputQuote";

    //setup chromedriver
    WebDriverManager.chromedriver().setup();
    //initialize chrome options
    ChromeOptions options = new ChromeOptions();
    //setting chrome capabilities https://peter.sh/experiments/chromium-command-line-switches/
    options.addArguments("--start-maximized,--incognito");
    WebDriver driver = new ChromeDriver(options);
    //for mac it --start-maximized not working properly. So need use this command to maximize
    driver.manage().window().maximize();

//    scenario open page
    driver.get("http://bdd.atlasid.tech/");
    Thread.sleep(5000);

//    scenario input quote
//    cara 1
    By inputQuote = By.id("inputQuote");
    driver.findElement(inputQuote).sendKeys("Hallo 1");

//    cara 2
    driver.findElement(By.id("inputQuote")).sendKeys("Hello selamat pagi");

//    cara 3 yang lebih sering
    WebElement quoteElement = driver.findElement(By.id("inputQuote"));
    quoteElement.sendKeys("Hello ketiga");
    Thread.sleep(300);

//    scenario choose color from dropdown list
    WebElement selectColor  = driver.findElement(By.id("colorSelect"));
    selectColor.click();
    selectColor.sendKeys("Blue");
    Thread.sleep(300);

    Select select = new Select(selectColor); //selector di sini manggil dari line 45 yang webelemet selectcolor
    select.selectByValue("Yellow");
    Thread.sleep(3000);
    select.selectByIndex(2);
    Thread.sleep(3000);
    select.selectByVisibleText("White");
    Thread.sleep(3000);

    WebElement buttonElement = driver.findElement(By.id("buttonAddQuote"));
    buttonElement.click();
    Thread.sleep(3000);

    String xpathAlert = "//*[@class='alert alert-info']";
    WebElement alertElement = driver.findElement(By.xpath(xpathAlert));
    String alert = alertElement.getText();
    System.out.println("alertnya ada = " + alert);
    Assert.assertTrue(alert.equals("Info: Click on a Quote to delete it!"));

//    select.selectByVisibleText("Atlas Tech ID Web Playground");
//    WebElement getT = driver.findElement(By.xpath(""))
//    WebElement getTitle = driver.findElement(By.xpath("/html/body/div/div[1]/div/h1"));
//    System.out.println(getTitle.getText());
//
//    WebElement quoteElement2 = driver.findElement(By.id("inputQuote"));
//    quoteElement2.sendKeys("Peni Kurniawati");
//    Thread.sleep(300);
//
//    WebElement selectColor2  = driver.findElement(By.id("colorSelect"));
//    selectColor2.click();
//    selectColor2.sendKeys("Blue");
//    Thread.sleep(300);
//
//    WebElement buttonElement2 = driver.findElement(By.id("buttonAddQuote"));
//    buttonElement2.click();
//    Thread.sleep(3000);
//
//    String xpathAlert = "//*[@class='alert alert-info']";
//    WebElement alertElement = driver.findElement(By.xpath(xpathAlert));
//    String alert = alertElement.getText();
//    System.out.println("alertnya ada = " + alert);
//    Assert.assertTrue(alert.equals("Info: Click on a Quote to delete it!"));
//
//    WebElement poweredBy = driver.findElement(By.id("poweredBy"));
//    System.out.println(poweredBy.getText());
//
//    String resource = "Info: Click on a Quote to delete it!";
//    Assert.assertEquals(alert, resource);
//    Assert.assertTrue(alertElement.isDisplayed());
//
//    System.out.println("alertnya ada = " + alert);
//    Assert.assertTrue(alert.equals("Info: Click on a Quote to delete it!"));

    driver.quit();
  }
}
