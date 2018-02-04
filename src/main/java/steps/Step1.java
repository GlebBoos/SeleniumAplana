//Step для основной страницы

package steps;

import pages.Page1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;


public class Step1 {
    WebDriver driver;
    @Step ("выбран пункт меню {0}")
    public void selectSection (String name) {
        new Page1(driver).selectSection(name);
    }

    @Step ("выбран вид страхования {0}")
    public void travelInsurance (String name) {
        new Page1(driver).travelInsurance(name);
    }

    @Step ("получен вид страхования {0}")
    public WebElement getTravelInsuranceElement (String name) {
        return new Page1(driver).getTravelInsuranceElement(name);
    }

    @Step ("Ожидание")
    public void waitElement (WebElement element) {
        new Page1(driver).waitElement(element);
    }
}