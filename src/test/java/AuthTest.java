import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AuthPage;
import pages.MainPage;
import pages.ProfilePage;
import pages.SearchPage;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

public class AuthTest {

    public static AuthPage authpage;
    public static WebDriver chromeDriver;
    private static MainPage mainPage;

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
    public void setAuthPage(){
        chromeDriver.get(ConfProperties.getProperty("mainpage"));
        mainPage.getLoginButton().click();
        chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        authpage = new AuthPage(chromeDriver);
    }


    @DisplayName("Test login with password")
    @Test
    public void testAuthForm(){
        authpage.getLoginWithPasswordButton().click();
        authpage.getLoginFieldWithPassword().sendKeys(ConfProperties.getProperty("auth_email"));
        authpage.getPasswdField().sendKeys(ConfProperties.getProperty("auth_passwd"));
        authpage.getPasswdButton().click();
//        WebDriverWait waiter = new WebDriverWait(chromeDriver,300, 1000);
//        waiter.until((ExpectedCondition<Boolean>) d -> authpage.getCaptcha()!=null && authpage.getCaptcha().getAttribute("class").equals("recaptcha-checkbox-checkmark"));
//        {
            // Ввод капчи, АААААА
//            WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(300));
//            System.out.println(chromeDriver.findElement(By.id("recaptcha-anchor")).getAttribute("aria-checked"));
//            wait.until(ExpectedConditions.attributeToBe(chromeDriver.findElement(By.id("recaptcha-anchor")), "aria-checked", "true"));
//            wait.until(new ExpectedCondition<Boolean>(){
//                public Boolean apply(WebDriver d) {
//                    System.out.println(chromeDriver.findElement(By.id("recaptcha-anchor")).getAttribute("aria-checked"));
//                    return (d.findElement(By.id("recaptcha-anchor")).getAttribute("aria-checked").equals("true"));
//                }});
//        }
        authpage.getInButton().click();
        ProfilePage profilePage = new ProfilePage(chromeDriver);
        String expected = "Мои события";
        assertEquals(expected, profilePage.getMyEventsHeader().getText());
    }
}
