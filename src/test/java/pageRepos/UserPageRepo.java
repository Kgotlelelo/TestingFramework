package pageRepos;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.util.List;

public class UserPageRepo {

    public UserPageRepo(WebDriver driver){
        PageFactory.initElements(driver,this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver,10),this);
    }

    @FindBy(xpath = "//*[@name='Submit']")
    public WebElement searchButton;

    @FindBy(xpath = "//*[@name='location']")
    public WebElement selectLocation;


    @FindBy(xpath = "//input[contains(@name,'location')]")
    public List<WebElement> listLocation;



}
