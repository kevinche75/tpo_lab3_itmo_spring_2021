package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CompanyPage {

    @FindBy(xpath = "/html/body/div[6]/div/div[1]/div[4]/div/div[2]/div[2]/div/div[1]/div/h1/span[1]")
    WebElement companyName;

    public WebDriver webDriver;

    public CompanyPage(WebDriver webDriver){
        PageFactory.initElements(webDriver, this);
        this.webDriver = webDriver;
    }

    public WebElement getCompanyName() {
        return companyName;
    }
}
