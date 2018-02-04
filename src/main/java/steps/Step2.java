//Step для страницы с выбором страхования путешественников

package steps;

import pages.Page2;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;


public class Step2 {
    WebDriver driver;
    @Step("Проверка на ошибки")
    public void checkSP(String errorMessage){
        new Page2(driver).checkSP();
    }


    @Step("Переход на новую вкладку")
    public void changeWindow () {
        new Page2(driver).changeWindow();
    }

}