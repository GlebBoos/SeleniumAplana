package util;

import steps.Step_Base;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;


public class AllureListener extends AllureRunListener {
    @Override
    public void testFailure(Failure failure){
        Step_Base.takeScreenshot();
        super.testFailure(failure);
    }
}