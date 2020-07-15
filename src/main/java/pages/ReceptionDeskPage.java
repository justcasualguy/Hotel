package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.xpi.XpiDriverService;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import properties.XPaths;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ReceptionDeskPage extends PageBase{
    By beginDatePicker;
    By beginDateTime;
    By endDatePicker;
    By endDateTime;
    By roomCapacitySelect;
    By checkAvailabilityButton;
    By makeReservationButton;
    By hotelsWithGivenPriceReservationButton;

    public ReceptionDeskPage(WebDriver webDriver) {
        super(webDriver);
        beginDatePicker = By.xpath(XPaths.getXPath("beginDatePicker"));
        beginDateTime = By.xpath(XPaths.getXPath("beginDateTime"));
        endDatePicker= By.xpath(XPaths.getXPath("endDatePicker"));
        endDateTime = By.xpath(XPaths.getXPath("endDateTime"));
        roomCapacitySelect = By.xpath(XPaths.getXPath("roomCapacitySelect"));
        checkAvailabilityButton = By.xpath(XPaths.getXPath("checkAvailabilityButton"));
        makeReservationButton = By.xpath(XPaths.getXPath("makeReservationButton"));
        hotelsWithGivenPriceReservationButton = By.xpath(XPaths.getXPath("hotelsWithGivenPriceReservationButton"));
    }

    public void enterBegginigDate(){
        Locale locale = new Locale("en");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",locale);
        LocalDate localDate = LocalDate.now();

        wait.until(ExpectedConditions.elementToBeClickable(
           beginDatePicker
        ));

        webDriver.findElement(beginDatePicker).sendKeys(
                localDate.format(dateTimeFormatter)
        );

    }

    public void enterBegginingTime(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDate = LocalDateTime.now();
        wait.until(ExpectedConditions.elementToBeClickable(
                beginDateTime
        ));
        webDriver.findElement(beginDateTime).sendKeys(
                Keys.ENTER
        );
    }

    public void enterEndDate(){
        Locale locale = new Locale("en");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy",locale);
        LocalDate localDate = LocalDate.now().plusDays(1);

        wait.until(ExpectedConditions.elementToBeClickable(
                endDatePicker
        ));

        webDriver.findElement(endDatePicker).sendKeys(
                localDate.format(dateTimeFormatter)
        );

    }

    public void enterEndTime(){

        wait.until(ExpectedConditions.elementToBeClickable(
                endDateTime
        ));

        webDriver.findElement(endDateTime).sendKeys(
                Keys.ENTER
        );
    }

    public void enterReservationDate(){

        enterBegginigDate();
        enterBegginingTime();
        enterEndDate();
        enterEndTime();

    }
   public void clickCheckAvailability(){
       wait.until(ExpectedConditions.presenceOfElementLocated(
               checkAvailabilityButton
       ));
       webDriver.findElement(checkAvailabilityButton).click();
   }

   public void selectFirstHotelWithPrice(){
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(
                hotelsWithGivenPriceReservationButton,
                0
        ));
        webDriver.findElements(hotelsWithGivenPriceReservationButton).get(0).click();

   }

   public void clickMakeReservation(){
        wait.until(ExpectedConditions.elementToBeClickable(makeReservationButton));
        webDriver.findElement(makeReservationButton).click();
   }



}
