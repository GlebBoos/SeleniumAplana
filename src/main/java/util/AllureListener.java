package util;

import steps.BaseSteps;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;

/**
 * Created by sonya on 01.02.2018.
 */
public class AllureListener extends AllureRunListener {
    @Override
    public void testFailure(Failure failure){
        BaseSteps.takeScreenshot();
        super.testFailure(failure);
    }
}