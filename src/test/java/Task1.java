//Сценарий №1
//        1.Перейти на страницу http://www.sberbank.ru/ru/person
//        2.Нажать на – Застраховать себя и имущество
//        3.Выбрать – Страхование путешественников
//        4.Проверить наличие на странице заголовка – Страхование путешественников
//        5.Нажать на – Оформить Онлайн
//        6.На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
//        7.Нажать Оформить
//        8.На вкладке Оформить заполнить поля:
//          •Фамилию и Имя, Дату рождения застрахованных
//          •Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
//          •Паспортные данные
//          •Контактные данные не заполняем
//        9.Проверить, что все поля заполнены правильно
//        10.Нажать продолжить
//        11.Проверить, что появилось сообщение - Заполнены не все обязательные поля
//
// Author: Boos Gleb


import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task1 {
    private WebDriver driver;
    private String baseUrl;
    //SimpleDateFormat today = new SimpleDateFormat("dd.MM.yyyy");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = " http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testInsurance() throws Exception {

        //Установка задержки для страницы
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        //Доступ к необходимому URL
        driver.get(baseUrl);

        //Открытие вкладки "Застраховать себя и имущество"
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/a/span/span[1]")).click();
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/div/div/div[2]/div/a"))));

        //Открыть вкладку "Страхование путешественников"
        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/table/tbody/tr/td/div/div/div/div/div/div[1]/div[1]/div[4]/div/div/div/ul/li[5]/div/div/div[2]/div/a")).click();

        //Проверка наличия "Страхование путешественников"
        assertEquals("Страхование путешественников",
                driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div/div/div/div/div[2]/div[2]/div/div/div/div[1]/div/div/div/div/div/h1")).getText());

        //Открытие окна "Оформить онлайн" c переключением на новое окно
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[@id=\"SBRF_TabContainer_sb_bundle-47610460\"]/div/div[1]/div/div[1]/div/div/div/div/div/p/a/img")).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//*[@id=\"views\"]/form/section/section/section[2]/div[1]/div[1]/div/div[1]"))));
        driver.findElement(By.xpath("//*[@id=\"views\"]/form/section/section/section[2]/div[1]/div[1]/div/div[1]")).click();

        //Нажать на кнопку "Оформить"
        driver.findElement(By.xpath("//*[@id=\"views\"]/form/section/section/section[6]/span/span")).click();

        //Ввод данных в заявку по застрахованным
        fillField(By.name("insured0_surname"), "Gleb");
        fillField(By.name("insured0_name"), "Boos");
        fillField(By.name("insured0_birthDate"), "17.09.1994");
        driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[1]/div/insured-input/div/fieldset[4]/div/img")).click();

        //Ввод данных в заявку по стразователю
        fillField(By.name("surname"), "Иванов");
        fillField(By.name("name"), "Иван");
        fillField(By.name("middlename"), "Иванович");
        fillField(By.name("birthDate"), "17.09.1994");
        driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[2]/div/fieldset[8]/span[1]/input")).click();

        //Ввод данных паспорта
        fillField(By.name("passport_series"), "1111");
        fillField(By.name("passport_number"), "1111111");
        fillField(By.name("issuePlace"), "Москва");
        //fillField(By.name("issueDate"), "17.09.1994"); //Не заполняется для ошибки, что не все данные введены

        //Ввод данных телефона
        fillField(By.name("phone"), "(985) 683-3950");
        fillField(By.name("email"), "gboos@aplana.com");
        fillField(By.name("emailValid"), "gboos@aplana.com");

        //Нажмимаем на кнопку "Продолжить"
        driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[5]/div[1]/span[2]")).click();

        //Проверяем, что не все поля заполнены
        assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[5]/div[2]/div[1]")).getText());
        String l;
        //l=driver.findElement(By.xpath("//*[@id=\"views\"]/section/form/section/section[5]/div[2]/div[1]")).getText();

    }

    private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }


}