package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateVacancyPage {

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/form/div[2]/div[2]/div/div[2]/div/div[2]/div/span/input")
    WebElement phoneNumberInput;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/form/div[3]/div[2]/div/div[3]/div[1]/div[2]/label/span")
    WebElement noWorkButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/form/div[8]/div[2]/button")
    WebElement publish;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/form/div[4]/div[2]/button")
    WebElement publishWOFields;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/form/div[2]/div[2]/div/div[2]/div/div[2]/div[2]")
    WebElement phoneNumberNeeded;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/form/div[3]/div[2]/div/div[3]/div[1]/div[3]")
    WebElement workButtonNeeded;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/h1")
    WebElement createVacancyHeader;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div/div[2]/div[1]/div[1]/h2/span")
    WebElement createSuccess;

    public WebDriver webDriver;

    public CreateVacancyPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public WebElement getPublishWOFields() {
        return publishWOFields;
    }

    public WebElement getCreateSuccess() {
        return createSuccess;
    }

    public WebElement getPhoneNumberInput() {
        return phoneNumberInput;
    }

    public WebElement getNoWorkButton() {
        return noWorkButton;
    }

    public WebElement getPublish() {
        return publish;
    }

    public WebElement getPhoneNumberNeeded() {
        return phoneNumberNeeded;
    }

    public WebElement getWorkButtonNeeded() {
        return workButtonNeeded;
    }

    public WebElement getCreateVacancyHeader() {
        return createVacancyHeader;
    }


}
