import org.junit.Test;
import pages.Page1;
import pages.Page2;
import pages.Page3;

public class Task2 extends BaseTest{
    @Test
    public void testSberbank(){
        Page1 page1 = new Page1(driver);
        page1.selectSection("Застраховать себя  и имущество");
        page1.waitElement(page1.getTravelInsuranceElement("Страхование путешественников"));
        page1.travelInsurance("Страхование путешественников");

        Page3 page3 = new Page3(driver);
        page3.waitElement(page3.getTitle());
        page3.checkTitleErrorMessage("Страхование путешественников");
        page3.checkOutOnline();
        page3.switchWindow();

        Page2 page2 = new Page2(driver);
        page2.chooseSum("Минимальная");
        page2.execute();

        page2.fillField("фамилия застрахованного", "Ivanov");
        page2.fillField("имя застрахованного", "Ivan");
        page2.fillField("дата рождения застрахованного", "01.01.1999");
        page2.fillField("фамилия", "Петров");
        page2.fillField("имя", "Петр");
        page2.fillField("отчество", "Петрович");
        page2.fillField("день рождения", "01.01.1989");
        page2.fillField("серия паспорта", "1234");
        page2.fillField("номер паспорта", "222222");
        page2.fillField("дата выдачи", "14.03.2009");
        page2.fillField("место выдачи", "Трололо");
        page2.chooseGender("мужской");

        page2.checkFields("фамилия застрахованного","Ivanov");
        page2.checkFields("имя застрахованного","Ivan");
        page2.checkFields("дата рождения застрахованного", "01.01.1999");
        page2.checkFields("фамилия", "Петров");
        page2.checkFields("имя", "Петр");
        page2.checkFields("отчество", "Петрович");
        page2.checkFields("день рождения", "01.01.1989");
        page2.checkFields("серия паспорта", "1234");
        page2.checkFields("номер паспорта", "222222");
        page2.checkFields("дата выдачи", "14.03.2009");
        page2.checkFields("место выдачи", "Трололо");

        page2.clickContinue();
        page2.checkErrorMessage("Заполнены не все обязательные поля");

    }

}