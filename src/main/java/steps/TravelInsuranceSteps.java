package steps;

import pages.Page2;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * Created by sonya on 31.01.2018.
 */
public class TravelInsuranceSteps {
    @Step ("получен заголовок страницы")
    public WebElement getTitle(){
        return new Page2().getTitle();
    }

    @Step("заголовок проверен по шаблону {0}")
    public void checkTitleErrorMessage(String errorMessage){
        new Page2().checkTitleErrorMessage(errorMessage);
    }

    @Step("произведено нажатие на кнопку для оформления заявки")
    public void checkOutOnline (){
        new Page2().checkOutOnline();
    }

    @Step("произведена смена рабочего окна")
    public void switchWindow () {
        new Page2().switchWindow();
    }

    @Step ("ожидание элемента {0}")
    public void waitElement (WebElement element) {
        new Page2().waitElement(element);
    }
}