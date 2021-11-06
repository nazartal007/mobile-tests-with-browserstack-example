package browserstackTests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class BrowserstackAndroidTest extends BrowserstackBaseTest {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void wikipediaTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("another test")
    void wikipediaAnotherTest() {
        step("Tap to tree dots menu", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
        });
        step("Tap to login", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_account_name")).click();
        });
        step("Verify section title", () -> {
            $(MobileBy.xpath("//*[@class = 'android.widget.TextView']")).shouldHave(Condition.text("Log in to Wikipedia"));
        });
    }
}
