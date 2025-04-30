package pageObjects;

import Utilities.WebActions;
import com.aventstack.extentreports.ExtentTest;
import extentReports.Reporting;
import jdk.dynalink.beans.StaticClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageRepos.UserPageRepo;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserPageObjects  extends WebActions {
    public static WebDriver driver;
    UserPageRepo userPageRepo;
    public UserPageObjects(WebDriver _driver){
        this.driver= _driver;
        userPageRepo = new UserPageRepo(driver);
    }


    public void correctLocationReturned(String location, ExtentTest node) throws InterruptedException, IOException {


        System.out.println(driver.getCurrentUrl());
        if(driver.getCurrentUrl().contains("SelectHotel")){

            node.pass("On the Select Hotel Page", Reporting.CaptureScreenShot(driver));


        Thread.sleep(2000);
        if ( userPageRepo.listLocation.size() >=1) {
            System.out.println("Location found");
            for (int i = 1; i < userPageRepo.listLocation.size(); i++) {
               // String userNameValue =  userPageRepo.listLocation.get(i).getText();
                String userNameValue =  userPageRepo.listLocation.get(i).getAttribute("value");
                System.out.println(userNameValue);
                if(userNameValue.equalsIgnoreCase(location)){
                    node.pass("Correct Location was found ", Reporting.CaptureScreenShot(driver));
                }else {
                    node.fail("No location was found failed", Reporting.CaptureScreenShot(driver));
                    Assert.fail("No location was found failed");
                }

            }

            }

        }
        else{
            node.fail("No location was found failed", Reporting.CaptureScreenShot(driver));
            Assert.fail("No location was found failed");
        }


        }

    public void searchHotel(String location, ExtentTest node) throws IOException {


        node.pass("Before search details has been captured ", Reporting.CaptureScreenShot(driver));

        selectObject(userPageRepo.selectLocation,driver,"Value",location);

        node.pass("search details has been captured ", Reporting.CaptureScreenShot(driver));
        clickObject(userPageRepo.searchButton,driver);

        node.pass("Searching hotel button clicked ",Reporting.CaptureScreenShot(driver));


      //  sendKeys(userPageRepo.searchButton,driver,location);



    }

}
