import org.junit.Test;
import pages.Page1;
import pages.Page3;
import pages.Page2;

public class Task2 extends BaseTest{
    @Test
    public void Task2Selenium(){

        //Инициализация страниц
        Page1 page1 = new Page1(driver);
        Page2 page2 = new Page2(driver);
        Page3 Page3 = new Page3(driver);

        //Выполнение команд для основной страницы
        page1.selectSection("Застраховать себя  и имущество");
        page1.waitElement(page1.getTravelInsuranceElement("Страхование путешественников"));
        page1.travelInsurance("Страхование путешественников");

        //Выполнение команд для страницы страхования путешественников
        page2.checkSP();
        page2.changeWindow();

        //Выбор минимального макета для страхования на третьей странице
        Page3.minrequest("Минимальная");
        Page3.PressMin();

        //Ввод данных в заявку по застрахованным
        Page3.fillField("фамилия застрахованного", "Boos");
        Page3.fillField("имя застрахованного", "Gleb");
        Page3.fillField("дата рождения застрахованного", "17.09.1994");

        //Ввод данных в заявку по стразователю
        Page3.fillField("фамилия", "Иванов");
        Page3.fillField("имя", "Иван");
        Page3.fillField("отчество", "Иванович");
        Page3.fillField("день рождения", "17.09.1994");

        //Ввод данных паспорта
        Page3.fillField("серия паспорта", "1111");
        Page3.fillField("номер паспорта", "111111");
        Page3.fillField("дата выдачи", "17.09.1994");
        Page3.fillField("место выдачи", "Москва");


        //Проверка ввода данных в заявку по застрахованным
        Page3.checkFields("фамилия застрахованного","Boos");
        Page3.checkFields("имя застрахованного","Gleb");
        Page3.checkFields("дата рождения застрахованного", "17.09.1994");

        //Проверка ввода данных в заявку по стразователю
        Page3.checkFields("фамилия", "Иванов");
        Page3.checkFields("имя", "Иван");
        Page3.checkFields("отчество", "Иванович");
        Page3.checkFields("день рождения", "17.09.1994");

        //Проверка ввода данных паспорта
        Page3.checkFields("серия паспорта", "1111");
        Page3.checkFields("номер паспорта", "111111");
        Page3.checkFields("дата выдачи", "17.09.1994");
        Page3.checkFields("место выдачи", "Москва");


        //Утверждение данных
        Page3.EndRequest();

        //Проверка заполненных полей
        Page3.checkZP();

    }
}