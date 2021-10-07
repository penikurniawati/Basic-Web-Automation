import com.sun.corba.se.spi.orbutil.fsm.Input;
import driver.Webdriverinit;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.InputQuotePage;
import pages.TableViewPage;

public class TestRunWithPageObject {

    private InputQuotePage inputQuotePage = new InputQuotePage();
    private TableViewPage tableViewPage = new TableViewPage();

    @BeforeEach
    public void initializeWebdriver(){
        Webdriverinit.initialize();
    }

//    @AfterEach
//    public void quitWebdriver(){
//        Webdriverinit.quit();
//    }

    @Test
    public void addQuote() throws InterruptedException {
        //inisialisasi webdriver
        inputQuotePage.openPage();
        inputQuotePage.inputQuote("There is will a way");
        inputQuotePage.selectColor("Yellow");
        inputQuotePage.clickButtonAddQuote();

        Assertions.assertTrue(inputQuotePage.checkQuoteExist("There is will a way"));

        //wait
        Thread.sleep(5000);
    }

    @Test
    public void addThreeQuote() throws InterruptedException {
        //inisialisasi webdriver
        inputQuotePage.openPage();
        inputQuotePage.inputQuote("First Quote");
        inputQuotePage.selectColor("Yellow");
        inputQuotePage.clickButtonAddQuote();
        inputQuotePage.inputQuote("Second Quote");
        inputQuotePage.selectColor("Cyan");
        inputQuotePage.clickButtonAddQuote();
        inputQuotePage.inputQuote("Third Quote");
        inputQuotePage.selectColor("Blue");
        inputQuotePage.clickButtonAddQuote();
        inputQuotePage.verifyProgressBar();
        Thread.sleep(5000);
    }

    @Test
    public void hoverToShowTable() throws InterruptedException {
        //inisialisasi webdriver
        inputQuotePage.openPage();
        tableViewPage.clickButtonTableView();
        tableViewPage.hoverButtonShowTable();
        tableViewPage.showTable();
        Thread.sleep(5000);
    }
}
