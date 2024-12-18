import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.DragAndDropOptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successfulDragAndDropJUnitTest() {
        open("/drag_and_drop");
        $("[id=column-a]").shouldHave(text("A"));
        $("[id=column-b]").shouldHave(text("B"));
        $("[id=column-a]").dragAndDrop(DragAndDropOptions.to("[id=column-b]"));
        $("[id=column-a]").shouldHave(text("B"));
        $("[id=column-b]").shouldHave(text("A"));

    }
}
