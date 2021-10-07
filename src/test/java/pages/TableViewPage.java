package pages;

import base.PageObject;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TableViewPage extends PageObject{

    Actions actions = new Actions(getDriver());

    public void clickButtonTableView(){
        click(By.id("tableView"));
    }

    public void hoverButtonShowTable(){
        WebElement buttonShowTable = find(By.id("tableView"));
        actions.moveToElement(buttonShowTable);
    }

    public void showTable(){
        find(By.id("tablequote"));
    }
}
