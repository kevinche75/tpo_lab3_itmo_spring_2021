package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[3]/div/div[1]/div/h1/div")
    WebElement searchResultHeader;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[2]/div[2]")
    WebElement vacancyButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[3]/div/div[3]/div/div[2]/div/div[3]/div/div/div[1]/div[2]/div[1]/span/span/span/a")
    WebElement firstVacancyHeader;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div[1]/div/h1")
    WebElement cvHeader;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div/div/div[2]/div[2]/div/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/span/a")
    WebElement firstCVHeader;

    @FindBy(xpath = "/html/body/div[5]/div[2]/div/div[2]/div[3]")
    WebElement companyButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[3]/div/div[1]/div/div[2]/div/form/div[1]/div[1]/input")
    WebElement companyInput;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[3]/div/div[1]/div/div[2]/div/form/div[1]/div[2]/input")
    WebElement companySearchButton;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[3]/div/div[1]/div/div[4]")
    WebElement companySearchResult;

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[3]/div/div[1]/div/div[5]/table/tbody/tr/td/div[1]/a")
    WebElement firstCompanyHeader;

    public WebDriver webDriver;

    public SearchPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public WebElement getSearchResultHeader() {
        return searchResultHeader;
    }

    public WebElement getVacancyButton(){
        return vacancyButton;
    }

    public WebElement getFirstVacancyHeader() {
        return firstVacancyHeader;
    }

    public WebElement getCvHeader() {
        return cvHeader;
    }

    public WebElement getFirstCVHeader() {
        return firstCVHeader;
    }

    public WebElement getCompanyInput() {
        return companyInput;
    }

    public WebElement getCompanyButton() {
        return companyButton;
    }

    public WebElement getCompanySearchResult() {
        return companySearchResult;
    }

    public WebElement getFirstCompanyHeader() {
        return firstCompanyHeader;
    }

    public WebElement getCompanySearchButton() {
        return companySearchButton;
    }
}
