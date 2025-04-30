package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebUtilities {

private  WebDriver driver;
    public  WebDriver getWebDriver(){

        return driver;
    }

    public void setDriver(String browser){
        switch (browser.toLowerCase()) {

            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                driver =  new FirefoxDriver();
                break;

            case "edge" :
                WebDriverManager.edgedriver().setup();
                driver =  new EdgeDriver();
                break;

            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
    }

    public void navigateToURL(String url){

        driver.get(url);
    }

    public String getConfigPropertyValue(String propertyFileName, String propertyName) {
        String Value = null;
        try {
            FileInputStream fileIS = new FileInputStream(new File(propertyFileName));
            Properties prop = new Properties();
            prop.load(fileIS);

            Value = prop.getProperty(propertyName);
        } catch (IOException e) {
            System.out.println("Unable to launch as Framework.Properties is not properly configured");
            System.exit(0);
        }

        return Value;
    }

}
