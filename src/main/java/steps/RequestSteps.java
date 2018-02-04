package steps;

import pages.Page3;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.HashMap;

/**
 * Created by sonya on 31.01.2018.
 */
public class RequestSteps {

    @Step("выбрана сумма страховой защиты {0}")
    public void chooseSum (String sum) {
        new Page3().chooseSum(sum);
    }

    @Step ("выбрано оформление заявки")
    public void execute () {
        new Page3().execute();
    }

    @Step ("заполнено поле {0} значением {1}")
    public void fillField(String fieldName, String value) {
        new Page3().fillField(fieldName,value);
    }

    @Step("поля заполнены")
    public void fillFields(HashMap<String,String> fields){
        fields.forEach((k,v)->fillField(k,v));
    }

    @Step ("выбран пол {0}")
    public void chooseGender (String sex){
        new Page3().chooseGender(sex);
    }

    @Step ("проверен текст ошибки {0}")
    public void checkErrorMessage(String error){
        new Page3().checkErrorMessage(error);
    }

    @Step ("проверено значение поля {0} должно иметь значение {1}")
    public void checkField (String field, String expected){
        new Page3().checkField(field,expected);
    }

    @Step("поля проверены")
    public void checkFields(HashMap<String, String>hashMap){
        hashMap.forEach((k,v)->checkField(k,v));
    }

    @Step("выбрано продолжение оформления заявки")
    public void clickContinue (){
        new Page3().clickContinue();
    }
}