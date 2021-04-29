import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CVPage;
import pages.CompanyPage;
import pages.MainPage;
import pages.SearchPage;

import java.util.ArrayList;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SearchCompanyTest {

    private static WebDriver chromeDriver;
    private static MainPage mainPage;
    private static SearchPage searchPage;
    private static String workExample = "Tester";

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

    @BeforeEach
    public void setSearchPage(){
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
        mainPage.getSearchInput().sendKeys(workExample);
        mainPage.getSearchButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage = new SearchPage(chromeDriver);
        searchPage.getCompanyButton().click();
    }

    public String openCompany(){
        String name = searchPage.getFirstCompanyHeader().getText();
        searchPage.getFirstCompanyHeader().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return name;
    }

    @DisplayName("Test switch to Company search")
    @Test
    public void testSwitch(){
        String searchInput = searchPage.getCompanyInput().getAttribute("value");
        assertEquals(workExample.toLowerCase(), searchInput);
    }

    @DisplayName("Test search of company")
    @Test
    public void testSearchNew(){
        String newCompany = "Apple";
        searchPage.getCompanyInput().clear();
        searchPage.getCompanyInput().sendKeys(newCompany);
        searchPage.getCompanySearchButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String result = searchPage.getCompanySearchResult().getText();
        String pattern = ".*(\\d) компаний найдено";
        assertTrue(result.matches(pattern));
    }

    @DisplayName("Test choose Company")
    @Test
    public void testChooseCV(){
        String newCompany = "Apple";
        searchPage.getCompanyInput().clear();
        searchPage.getCompanyInput().sendKeys(newCompany);
        searchPage.getCompanySearchButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String cvName = openCompany();
        CompanyPage page = new CompanyPage(chromeDriver);
        String nameOnVacancyPage = page.getCompanyName().getText();
        assertEquals(cvName, nameOnVacancyPage);
    }
}
