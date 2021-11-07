package localTests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LocalAndroidTest extends LocalBaseTest {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void wikipediaTest() {
        back();
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("page_list_item_title"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("another test")
    void wikipediaAnotherTest() {
        back();
        step("Tap to tree dots menu", () -> {
            $(MobileBy.id("nav_more_container")).click();
        });
        step("Tap to login", () -> {
            $(MobileBy.id("main_drawer_login_button")).click();
        });
        step("Verify section title", () -> {
            $(MobileBy.xpath("//*[@resource-id='org.wikipedia.alpha:id/action_bar']/android.widget.TextView")).shouldHave(Condition.text("Create an account"));
        });
    }
}
