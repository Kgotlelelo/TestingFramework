package stepDefinitions;

import DataReader.DataFunction;
import Utilities.WebUtilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import extentReports.Reporting;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginObject;
import pageObjects.UserPageObjects;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static DataReader.DataFunction.Password;
import static DataReader.DataFunction.Username;


public class MystepDef {

    ExtentTest node;
    ExtentReports repo;
    WebUtilities util = new WebUtilities();
    LoginObject login_Obj;
    UserPageObjects user_Obj;

    String url = util.getConfigPropertyValue("Framework.properties", "baseUrl");
    String browser = util.getConfigPropertyValue("Framework.properties", "browser");
    String username = util.getConfigPropertyValue("Framework.properties", "username");
    String password = util.getConfigPropertyValue("Framework.properties", "password");

    @Before
    public void beforeTest() throws IOException {
        java.util.Date date = new java.util.Date();
        String datetime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss"));;
        repo = Reporting.initializeExtentReports("reporting/TestingAssessmentnReport"+datetime+".html");
        ExtentTest test = repo.createTest("Testing Assessment"+new Timestamp(date.getTime())).assignAuthor("Kgotlelelo");
        node = test.createNode("MyNode");
        util.setDriver(browser);
        DataFunction.dataFunction("Credentials",1);
        login_Obj= new LoginObject(util.getWebDriver());
        user_Obj= new UserPageObjects(util.getWebDriver());



    }

    @After
    public  void  afterTest(){
        util.getWebDriver().quit();
        repo.flush();
    }

    @Given("user is on the landing page")
    public void userIsOnTheLandingPage() {
        util.navigateToURL(url);
    }

    @When("user logs in")
    public void userLogsIn() throws IOException {
        login_Obj.login(username,password, node);
    }


    @And("Validate the user is on search page")
    public void validateTheUserIsOnSearchPage() throws IOException {
        login_Obj.validateLogin(node);
    }


    @And("Seach Hotel {string}")
    public void seachHotel(String arg0) throws IOException {
        user_Obj.searchHotel(arg0,node);
    }

    @Then("Verify that the list of location {string} returned")
    public void verifyThatTheListOfLocationReturned(String arg0) throws IOException, InterruptedException {
        user_Obj.correctLocationReturned(arg0,node);
        System.out.println("Verified");
    }
}

