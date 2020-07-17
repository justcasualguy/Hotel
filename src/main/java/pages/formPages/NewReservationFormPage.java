package pages.formPages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageBase;
import properties.XPaths;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class NewReservationFormPage extends PageBase {
    By beginDate;
    By beginTime;
    By endDate;
    By endTime;
    By saveButton;


    public NewReservationFormPage(WebDriver webDriver) {
        super(webDriver);
        beginDate = By.xpath(XPaths.getXPath("beginDate"));
        beginTime = By.xpath(XPaths.getXPath("beginTime"));
        endDate = By.xpath(XPaths.getXPath("endDate"));
        endTime = By.xpath(XPaths.getXPath("endTime"));
        saveButton = By.xpath(XPaths.getXPath("saveRecordButton"));
    }





    public void enterBegginigDate(){
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
        Locale locale = new Locale("en");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",locale);
        LocalDate localDate = LocalDate.now();

        fluentWaitForElement(webDriver, beginDate,
                ExpectedConditions.presenceOfElementLocated(
                        beginDate
                ));

        webDriver.findElement(beginDate).sendKeys(
                localDate.format(dateTimeFormatter)
        );

    }

    public void enterBegginingTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDate = LocalDateTime.now();
        wait.until(ExpectedConditions.elementToBeClickable(
                beginTime
        ));
        webDriver.findElement(beginTime).sendKeys(
                Keys.ENTER
        );
    }

    public void enterEndDate(){
        Locale locale = new Locale("en");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy",locale);
        LocalDate localDate = LocalDate.now().plusDays(1);

        wait.until(ExpectedConditions.elementToBeClickable(
                endDate
        ));

        webDriver.findElement(endDate).sendKeys(
                localDate.format(dateTimeFormatter)
        );

    }

    public void enterEndTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDate = LocalDateTime.now();
        wait.until(ExpectedConditions.elementToBeClickable(
                endTime
        ));

        webDriver.findElement(endTime).sendKeys(
                Keys.ENTER
        );
    }

    public void enterReservationDate(){

        enterBegginigDate();
        enterBegginingTime();
        enterEndDate();
        enterEndTime();

    }
    public void clickSaveButton(){
        fluentWaitForElement(webDriver,saveButton,
                ExpectedConditions.elementToBeClickable(saveButton));
        Actions actions = new Actions(webDriver);
        actions.moveToElement(
                webDriver.findElements(saveButton).get(0)
        ).click().build().perform();
    }
}
