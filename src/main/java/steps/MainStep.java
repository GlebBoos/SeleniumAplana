//Step для основной страницы

package steps;

import pages.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.allure.annotations.Step;


public class MainStep {
    WebDriver driver;


    @Step ("Выбор вкладки страхования на основной странице")
    public void selectSection (String name) {
        new MainPage(driver).selectSection(name);
    }

    @Step ("Выбор вкладкии страхования пушешественников ")
    public void travelInsurance (String name) {
        new MainPage(driver).travelInsurance(name);
    }

    @Step ("Получения страхования пушешественников")
    public WebElement getTravelInsuranceElement (String name) {
        return new MainPage(driver).getTravelInsuranceElement(name);
    }

    @Step ("Ожидание")
    public void waitElement (WebElement element) {
        new MainPage(driver).waitElement(element);
    }
}