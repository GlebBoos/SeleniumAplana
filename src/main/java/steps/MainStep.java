//Step для основной страницы

package steps;

import pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;


public class MainStep {
    WebDriver driver;
    @Step ("выбран пункт меню {0}")
    public void selectSection (String name) {
        new MainPage(driver).selectSection(name);
    }

    @Step ("выбран вид страхования {0}")
    public void travelInsurance (String name) {
        new MainPage(driver).travelInsurance(name);
    }

    @Step ("получен вид страхования {0}")
    public WebElement getTravelInsuranceElement (String name) {
        return new MainPage(driver).getTravelInsuranceElement(name);
    }

    @Step ("Ожидание")
    public void waitElement (WebElement element) {
        new MainPage(driver).waitElement(element);
    }
}