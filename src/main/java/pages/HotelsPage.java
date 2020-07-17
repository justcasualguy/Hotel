package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import properties.XPaths;

public class HotelsPage extends PageBase{
    By newButton;

    public HotelsPage(WebDriver webDriver) {
        super(webDriver);
        newButton = By.xpath(XPaths.getXPath("newRecordButton"));
    }

    public void clickNewButton(){
        wait.until(ExpectedConditions.elementToBeClickable(newButton));
        webDriver.findElement(newButton).click();
    }
}
