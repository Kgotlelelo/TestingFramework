package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class Reporting  {


    public static ExtentReports initializeExtentReports(String ReportName) {
        ExtentReports extent =  new ExtentReports();
        ExtentSparkReporter  spark = new ExtentSparkReporter(ReportName);


        extent.attachReporter(spark);
        return extent;

    }
    public static Media CaptureScreenShot(WebDriver driver) throws IOException {
        File sFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        byte [] fileContent = FileUtils.readFileToByteArray(new File(String.valueOf(sFile)));
        String endcodedString = Base64.getEncoder().encodeToString(fileContent);
        return MediaEntityBuilder.createScreenCaptureFromBase64String(endcodedString).build();
    }



}