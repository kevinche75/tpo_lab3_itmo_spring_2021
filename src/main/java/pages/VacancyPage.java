package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VacancyPage {

    public WebDriver webDriver;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div[1]/div[1]/div/div/h1")
    WebElement nameElement;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div[1]/div[3]/div[1]/div/div/div/div/div/a")
    WebElement respondButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div[1]/div[3]/div[3]/div/div/div[2]/div/div[1]/div")
    WebElement stayContactsPlane;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div[1]/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div/form/div[1]/div/input")
    WebElement stayContactsInput;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div[1]/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div/form/div[4]/div/button")
    WebElement stayContactsButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div[1]/div[3]/div[3]/div/div/div[2]/div/div[1]/div/div/form/div[1]/p")
    WebElement sentOnEmail;

    public VacancyPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public WebElement getNameElement() {
        return nameElement;
    }

    public WebElement getRespondButton() {
        return respondButton;
    }

    public WebElement getStayContactsPlane() {
        return stayContactsPlane;
    }

    public WebElement getStayContactsInput() {
        return stayContactsInput;
    }

    public WebElement getStayContactsButton() {
        return stayContactsButton;
    }

    public WebElement getSentOnEmail() {
        return sentOnEmail;
    }
}
