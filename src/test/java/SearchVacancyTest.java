import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import pages.SearchPage;
import pages.VacancyPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SearchVacancyTest {

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

    @BeforeEach
    public void setSearchPage(){
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
        String workExample = "Tester";
        mainPage.getSearchInput().sendKeys(workExample);
        mainPage.getSearchButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPage = new SearchPage(chromeDriver);
    }

    public String openVacancy(){
        String name = searchPage.getFirstVacancyHeader().getText();
        searchPage.getFirstVacancyHeader().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ArrayList<String> tabs = new ArrayList<String> (chromeDriver.getWindowHandles());
        String currentTab = chromeDriver.getWindowHandle();
        chromeDriver.switchTo().window(tabs.get(tabs.indexOf(currentTab)+1));
        return name;
    }

    @DisplayName("Test Choose Vacancy")
    @Test
    public void testChooseVacancy(){
        String name = openVacancy();
        VacancyPage page = new VacancyPage(chromeDriver);
        String nameOnVacancyPage = page.getNameElement().getText();
        assertEquals(name, nameOnVacancyPage);
    }

    @DisplayName("Test Respond to Vacancy")
    @Test
    public void testRespond(){
        String name = openVacancy();
        VacancyPage page = new VacancyPage(chromeDriver);
        page.getRespondButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        assertTrue(page.getStayContactsPlane().isDisplayed());
    }

    @DisplayName("Test Respond to Vacancy with email")
    @Test
    public void testRespondWithEmail(){
        String name = openVacancy();
        VacancyPage page = new VacancyPage(chromeDriver);
        page.getRespondButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String testEmail = "test@test.test";
        page.getStayContactsInput().sendKeys(testEmail);
        page.getStayContactsButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expected = "Мы отправили письмо с кодом на почту " + testEmail + ", введите код из письма";
        assertEquals(expected, page.getSentOnEmail().getText());
    }
}
