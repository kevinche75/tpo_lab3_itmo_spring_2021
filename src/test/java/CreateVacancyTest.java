import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.AuthPage;
import pages.CreateVacancyPage;
import pages.MainPage;
import pages.ProfilePage;

import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class CreateVacancyTest {

    public static AuthPage authpage;
    public static WebDriver chromeDriver;
    private static MainPage mainPage;
    private static ProfilePage profilePage;

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

    public void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    @BeforeEach
    public void setAuthPage(){
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
        mainPage.getLoginButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authpage = new AuthPage(chromeDriver);
        authpage.getLoginWithPasswordButton().click();
        authpage.getLoginFieldWithPassword().sendKeys(ConfProperties.getProperty("auth_email"));
        authpage.getPasswdField().sendKeys(ConfProperties.getProperty("auth_passwd"));
        authpage.getPasswdButton().click();
    }

    @DisplayName("Test create Vacancy")
    @Test
    public void testCreateVacancy(){
        authpage.getInButton().click();
        profilePage = new ProfilePage(chromeDriver);
        profilePage.getCreateVacancy().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String expected = "Ваше резюме";
        CreateVacancyPage createVacancyPage = new CreateVacancyPage(chromeDriver);
        assertEquals(expected, createVacancyPage.getCreateVacancyHeader().getText());
    }

    @DisplayName("Test create Vacancy fill fields")
    @Test
    public void testCreateVacancyFillFields(){
        authpage.getInButton().click();
        profilePage = new ProfilePage(chromeDriver);
        profilePage.getCreateVacancy().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CreateVacancyPage createVacancyPage = new CreateVacancyPage(chromeDriver);
        createVacancyPage.getPhoneNumberInput().sendKeys("9524567612");
        createVacancyPage.getNoWorkButton().click();
        createVacancyPage.getPublish().click();
        String expected = "Резюме успешно опубликовано. Модератор проверит ваше резюме в ближайшее время";
        assertEquals(expected, createVacancyPage.getCreateSuccess().getText());
    }

    @DisplayName("Test create Vacancy wo fields")
    @Test
    public void testCreateVacancyWOFillFields(){
        authpage.getInButton().click();
        profilePage = new ProfilePage(chromeDriver);
        profilePage.getCreateVacancy().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        CreateVacancyPage createVacancyPage = new CreateVacancyPage(chromeDriver);
        createVacancyPage.getPublishWOFields().click();
        String expected = "Обязательное поле";
        assertEquals(expected, createVacancyPage.getPhoneNumberNeeded().getText());
        assertEquals(expected, createVacancyPage.getWorkButtonNeeded().getText());
    }
}
