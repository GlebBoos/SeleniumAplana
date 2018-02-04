//Step для страницы с вводо данных и оформлением заявки
package steps;

import pages.Page3;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.HashMap;


public class Step3 {
    WebDriver driver;

    @Step("выбрана сумма страховой защиты {0}")
    public void PressMin () {
        new Page3(driver).PressMin();
    }

    @Step ("выбрано оформление заявки")
    public void minrequest (String sum) {
        new Page3(driver).minrequest(sum);
    }

    @Step ("заполнено поле {0} значением {1}")
    public void fillField(String fieldName, String value) {
        new Page3(driver).fillField(fieldName,value);
    }

    @Step("поля заполнены")
    public void fillFields(HashMap<String,String> fields){
        fields.forEach((k,v)->fillField(k,v));
    }

    @Step ("проверен текст ошибки {0}")
    public void checkZP(){
        new Page3(driver).checkZP();
    }

    @Step ("проверено значение поля {0} должно иметь значение {1}")
    public void checkField (String field, String expected){
        new Page3(driver).checkFields(field,expected);
    }

    @Step("поля проверены")
    public void checkFields(HashMap<String, String>hashMap){
        hashMap.forEach((k,v)->checkField(k,v));
    }

    @Step("выбрано продолжение оформления заявки")
    public void EndRequest (){
        new Page3(driver).EndRequest();
    }
}