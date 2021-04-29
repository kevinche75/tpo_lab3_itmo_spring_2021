package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    @FindBy(xpath = "/html/body/div[1]/div/div[1]/div/ul[1]/li[1]/a")
    private WebElement inButton;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div/div[1]/div[3]/div/div/form/div/div[1]/div/input")
    private WebElement searchInput;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div/div[1]/div[3]/div/div/form/div/div[2]/button")
    private WebElement searchButton;

    @FindBy(xpath = "/html/body/div[5]/div[3]/div/div[1]/div[1]/div/div[5]/a")
    private WebElement loginButton;

    public WebDriver webDriver;

    public MainPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public void searchWork(String work){

    }

    public void clickLogInButton(){
        inButton.click();
    }


    public WebElement getSearchInput() {
        return searchInput;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getInButton() {
        return inButton;
    }

    public WebElement getLoginButton() {
        return loginButton;
    }
}
