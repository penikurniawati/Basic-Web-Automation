package base;

import driver.Webdriverinit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PageObject {

//    getDriver
    public WebDriver getDriver(){
        return Webdriverinit.driver;
    }

//    find
    public WebElement find(By locator){
        return getDriver().findElement(locator);
    }

    public List<WebElement> findAll(By locator){
        return getDriver().findElements(locator);
    }

//    type
    public void type(By locator, String text){
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

//    click
    public void click(By locator){
        find(locator).click();
    }

//    select
    public void selectByVisibleText(By locator, String text){
        WebElement element = find(locator);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

//    open URL
    public void openUrl(String url){
        getDriver().get(url);
    }
}
