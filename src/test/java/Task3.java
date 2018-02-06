import steps.Step_Base;
import steps.MainStep;
import steps.RequestStep;
import steps.InsuranceTravelStep;
import org.junit.Test;

import java.util.HashMap;

public class Task3 extends Step_Base {

    MainStep mainStep = new MainStep();
    InsuranceTravelStep insuranceTravelStep = new InsuranceTravelStep();
    RequestStep requestStep = new RequestStep();
    HashMap <String, String> testData = new HashMap<>();


    @Test
    public void task3selenuim(){

        mainStep.selectSection("Застраховать себя  и имущество");
        mainStep.waitElement(mainStep.getTravelInsuranceElement("Страхование путешественников"));
        mainStep.travelInsurance("Страхование путешественников");

        //insuranceTravelStep.waitElement(insuranceTravelStep.getTitle());
        insuranceTravelStep.checkSP("Страхование путешественников");
        insuranceTravelStep.changeWindow();

        requestStep.minrequest("Минимальная");
        requestStep.PressMin();

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

        requestStep.fillFields(testData);
        requestStep.checkFields(testData);

        requestStep.EndRequest();
        requestStep.checkZP();
    }

}