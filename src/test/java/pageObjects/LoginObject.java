package pageObjects;

import Utilities.WebActions;
import Utilities.WebUtilities;
import com.aventstack.extentreports.ExtentTest;
import extentReports.Reporting;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pageRepos.LoginRepo;

import java.io.IOException;


public class LoginObject extends WebActions {
private WebDriver driver;
    private  LoginRepo loginObj;
    public LoginObject(WebDriver driver){
        this.driver = driver;
         loginObj = new LoginRepo(driver);
    }


    public  void  login(String username, String password,ExtentTest node) throws IOException {
        //clickObject(loginObj.myAccBtn,driver);
        sendKeys(loginObj.username,driver,username);
        sendKeys(loginObj.password,driver,password);
        node.pass("log details has been captured ", Reporting.CaptureScreenShot(driver));
        clickObject(loginObj.loginButton,driver);
    }

    public void validateLogin(ExtentTest node) throws IOException {

        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().contains("SearchHotel")){
            node.pass("log in passed", Reporting.CaptureScreenShot(driver));
        }else{
            node.fail("log in failed", Reporting.CaptureScreenShot(driver));
            Assert.fail("log in failed");
        }

    }
}
