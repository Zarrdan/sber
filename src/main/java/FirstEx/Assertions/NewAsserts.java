package FirstEx.Assertions;

import io.qameta.allure.Step;
import org.testng.Assert;

import java.util.List;

public class NewAsserts {

    @Step("Проверяю, что {message}")
    public static void assertEqualsIdCompany(List<String> actual, List<String> sort, String message) {
        Assert.assertEquals(actual, sort, message);
    }

    @Step("Проверяю, что {message}")
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    @Step("Проверяю, что {message}")
    public static void assertEqualsPost(String sent, String received, String message) {
        Assert.assertEquals(sent, received, message);
    }
}
