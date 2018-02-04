package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;


public class Page3 {
    WebDriver driver;

    @FindBy(xpath = "//*[@class='sbrf-rich-outer']/h1")
    WebElement title;

    @FindBy(xpath = "//img[@src=\"/portalserver/content/atom/contentRepository/content/person/travel/banner-zashita-traveler.jpg?id=f6c836e1-5c5c-4367-b0d0-bbfb96be9c53\"]")
    WebElement image;

    public Page3(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public WebElement getTitle(){
        return title;
    }

    public void checkTitleErrorMessage(String errorMessage){
        String actualTitle = this.title.getText();
        Assert.assertTrue(String.format("Получено значение [%s]. Ожидалось [%s]", actualTitle, errorMessage),
                actualTitle.contains(errorMessage));
    }

    public void checkOutOnline (){
        image.click();
    }

    public void switchWindow () {
        String parentWindow = driver.getWindowHandle();
        Set<String> handles =  driver.getWindowHandles();
        for(String windowHandle  : handles) {
            if (!windowHandle.equals(parentWindow)) {
                driver.switchTo().window(windowHandle);
            }
        }
    }
    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void waitElement (WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(driver, 30, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}