package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class WebActions {

    public void clickObject(WebElement element, WebDriver driver){
        try
        {
            if (element.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(element));
                element.click();
            }
        } catch (Exception e){
            System.out.println(element + "Not found");
        }


    }

    public void selectObject(WebElement selectElement,WebDriver driver, String selectBy, Object selectValue){
        try {
            if (selectElement.isDisplayed())
            {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(selectElement));

                Select select = new Select(selectElement);
                switch(selectBy.toLowerCase()){

                    case " index" :
                        select.selectByIndex((Integer)selectValue);
                        break;

                    case "visibleText":
                        select.selectByVisibleText((String)selectValue);
                        break;

                    case "value" :
                      select.selectByValue((String)selectValue);
                      break;


                }
            }



        }catch (Exception e){
            System.out.println(selectElement + "Not Found");
        }
    }

    public void sendKeys(WebElement textBox,WebDriver driver, String data){
        try {
            if (textBox.isDisplayed()) {
                Wait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(5))
                        .pollingEvery(Duration.ofMillis(1000))
                        .ignoring(WebDriverException.class);
                wait.until(ExpectedConditions.elementToBeClickable(textBox));

                textBox.clear();
                textBox.sendKeys(data);
            }
        } catch (Exception e){
            System.out.println(textBox +"Not Found");
        }
    }
}
