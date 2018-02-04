package steps;

import pages.Page1;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by sonya on 31.01.2018.
 */
public class MainSteps {
    @Step ("выбран пункт меню {0}")
    public void selectSection (String name) {
        new Page1().selectSection(name);
    }

    @Step ("выбран вид страхования {0}")
    public void travelInsurance (String name) {
        new Page1().travelInsurance(name);
    }

    @Step ("получен вид страхования {0}")
    public WebElement getTravelInsuranceElement (String name) {
        return new Page1().getTravelInsuranceElement(name);
    }

    @Step ("ожидание элемента {0}")
    public void waitElement (WebElement element) {
        new Page1().waitElement(element);
    }
}