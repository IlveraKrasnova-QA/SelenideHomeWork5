import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OpeningThePageJUnitTest {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1928x1080";
        Configuration.pageLoadStrategy = "eager";
    }
    @Test
    void successfulOpeningThePageJUnitTest(){
        open("https://github.com/");
        $("[class=HeaderMenu-nav]").$(byText("Solutions")).hover();
        $(Selectors.byTagAndText("a", "Enterprises")).click();
        $("[id=hero-section-brand-heading]").shouldHave(text("The AI-powered")).shouldHave(text("developer platform"));

    }
}
