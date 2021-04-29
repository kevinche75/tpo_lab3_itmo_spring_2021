package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AuthPage {

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/div/form/div[1]/input")
    private WebElement loginField;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/form/div[1]/input")
    private WebElement loginFieldWithPassword;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/div/form/div[4]/button")
    private WebElement loginButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/div/form/div[4]/span")
    private WebElement loginWithPasswordButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/form/div[2]/span/input")
    private WebElement passwdField;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/form/div[4]/div/button")
    private WebElement passwdButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[1]/div[1]/div[2]/div/form/div[5]/div/button")
    private WebElement inButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[2]/div/div/div/span[1]/a")
    private WebElement VKButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[2]/div/div/div/span[2]/a")
    private WebElement GoogleButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div/div/div[1]/div[2]/div/div/div/span[3]/a")
    private WebElement MyWorldButton;
///html/body/div/div/div[2]/div[1]/div[1]/div
///html/body/div/div/div[2]/div[1]/div[1]/div
///html/body/div[8]/div[4]/iframe
    @FindBy(xpath = "/html/body/div[2]/div[3]/div[1]/div/div/span/div[4]")
    private WebElement captcha;

    public WebDriver webDriver;

    public AuthPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public WebElement getLoginField() {
        return loginField;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }

    public WebElement getPasswdField() {
        return passwdField;
    }

    public WebElement getPasswdButton() {
        return passwdButton;
    }

    public WebElement getLoginWithPasswordButton() {
        return loginWithPasswordButton;
    }

    public WebElement getVKButton() {
        return VKButton;
    }

    public WebElement getGoogleButton() {
        return GoogleButton;
    }

    public WebElement getMyWorldButton() {
        return MyWorldButton;
    }

    public WebElement getLoginFieldWithPassword() {
        return loginFieldWithPassword;
    }

    public WebElement getInButton() {
        return inButton;
    }

    public WebElement getCaptcha() {
        return captcha;
    }
}
