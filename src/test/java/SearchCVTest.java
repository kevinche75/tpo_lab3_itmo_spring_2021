import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CVPage;
import pages.MainPage;
import pages.SearchPage;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class SearchCVTest {

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
        searchPage.getVacancyButton().click();
    }

    @DisplayName("Test switch to CV search")
    @Test
    public void testSwitch(){
        String header = searchPage.getCvHeader().getText();
        String pattern = "Найдено .*(\\d) резюме у .*(\\d) соискателей";
        assertTrue(header.matches(pattern));
    }

    public String openCV(){
        String name = searchPage.getFirstCVHeader().getText();
        searchPage.getFirstCVHeader().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ArrayList<String> tabs = new ArrayList<String> (chromeDriver.getWindowHandles());
        String currentTab = chromeDriver.getWindowHandle();
        chromeDriver.switchTo().window(tabs.get(tabs.indexOf(currentTab)+1));
        return name;
    }

    @DisplayName("Test choose CV")
    @Test
    public void testChooseCV(){
        String cvName = openCV();
        CVPage page = new CVPage(chromeDriver);
        String nameOnVacancyPage = page.getNameElement().getText();
        assertEquals(cvName, nameOnVacancyPage);
    }
}
