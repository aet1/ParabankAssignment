package Util;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.RandomStringUtils;
import java.time.Duration;

public class HelperFunctions {
    private static Duration TIMEOUT = Duration.ofMillis(5000);
    public static void validateElementVisible(SelenideElement locator){
        locator.shouldBe(Condition.visible,TIMEOUT);
    }


    public static String generateRandomString(int length) {
        return RandomStringUtils.randomAlphanumeric(length);


    }
    public static String generateRandomNumber(int length) {
        return RandomStringUtils.randomNumeric(length);
    }
}
