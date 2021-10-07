package pages;

import base.PageObject;
import driver.Webdriverinit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class InputQuotePage extends PageObject {

    public void openPage(){
//        Webdriverinit.driver.get("http://bdd.atlasid.tech/");
        openUrl("http://bdd.atlasid.tech/");
    }
    public void inputQuote(String quote){
//        WebElement quoteElement = Webdriverinit.driver.findElement(By.id("inputQuote"));
//        quoteElement.clear();
//        quoteElement.sendKeys(quote);
        type(By.id("inputQuote"),quote);
    }

    public void selectColor(String color){
//        WebElement selectColor  = Webdriverinit.driver.findElement(By.id("colorSelect"));
//
//        Select select = new Select(selectColor); //selector di sini manggil dari line 45 yang webelemet selectcolor
//        select.selectByVisibleText(color);
        selectByVisibleText(By.id("colorSelect"), color);
    }

    public void clickButtonAddQuote(){
//        WebElement buttonElement = Webdriverinit.driver.findElement(By.id("buttonAddQuote"));
//        buttonElement.click();
        click(By.id("buttonAddQuote"));
    }

    public boolean checkQuoteExist(String quote){
        List<WebElement> quoteElements = Webdriverinit.driver.findElements(By.name("quoteText"));
        //looping khusus untuk list, klo bukan list gabisa
        boolean isSame = false;
        for(WebElement data : quoteElements){
            if(data.getText().equals(quote)){
                isSame = true;
                break; //klo udah ketemu, looping berhenti
            }
        }
//        quoteElements.stream().map(WebElement::getText).anyMatch(dt -> dt.equals(quote));
        return isSame;
    }

    public void verifyProgressBar(){
        WebElement progress = find(By.className("progress-bar"));
        Assert.assertEquals("4 / 10", progress.getText());
    }

}
