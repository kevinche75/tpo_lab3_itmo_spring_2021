import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SearchPage;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SearchTest {

    private static WebDriver chromeDriver;
    private static MainPage mainPage;
    private static SearchPage searchPage;

    @BeforeAll
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
        mainPage = new MainPage(chromeDriver);
    }

    @AfterAll
    public static void close(){
        chromeDriver.close();
    }

    @Test
    @DisplayName("Test Search Button exist")
    public void testSearchButtonExist(){
        assertTrue(mainPage.getSearchButton().isDisplayed());
    }

    @Test
    @DisplayName("Test Search Input exist")
    public void testSearchInputExist(){
        assertTrue(mainPage.getSearchInput().isDisplayed());
    }

    @Test
    @DisplayName("Test Search Vacancies")
    public void testSearchVacancies(){
        String workExample = "Tester";
        String resultExpect = "Работа " + workExample.toLowerCase() + " в Санкт-Петербурге";
        mainPage.getSearchInput().sendKeys(workExample);
        mainPage.getSearchButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage = new SearchPage(chromeDriver);
        assertEquals(resultExpect, searchPage.getSearchResultHeader().getText());
    }
}


