import steps.Step_Base;
import steps.Step1;
import steps.Step3;
import steps.Step2;
import org.junit.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.HashMap;

public class Task3 extends Step_Base {

    Step1 step1 = new Step1();
    Step2 step2 = new Step2();
    Step3 step3 = new Step3();
    HashMap <String, String> testData = new HashMap<>();


    @Test
    public void task3selenuim(){

        step1.selectSection("Застраховать себя  и имущество");
        step1.waitElement(step1.getTravelInsuranceElement("Страхование путешественников"));
        step1.travelInsurance("Страхование путешественников");

        //step2.waitElement(step2.getTitle());
        step2.checkSP("Страхование путешественников");
        step2.changeWindow();

        step3.minrequest("Минимальная");
        step3.PressMin();

        testData.put("фамилия застрахованного", "Ivanov");
        testData.put("имя застрахованного", "Ivan");
        testData.put("дата рождения застрахованного", "01.01.1999");
        testData.put("фамилия", "Петров");
        testData.put("имя", "Петр");
        testData.put("отчество", "Петрович");
        testData.put("день рождения", "");
        testData.put("серия паспорта", "1234");
        testData.put("номер паспорта", "222222");
        testData.put("дата выдачи", "14.03.2009");
        testData.put("место выдачи", "Трололо");

        step3.fillFields(testData);
        step3.checkFields(testData);

        step3.EndRequest();
        step3.checkZP();
    }

}