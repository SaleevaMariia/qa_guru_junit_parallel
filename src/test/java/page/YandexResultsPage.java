package page;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class YandexResultsPage {

    private ElementsCollection results = $$(".serp-item");

    public void checkResults(String expected){
        results.shouldBe(CollectionCondition.sizeGreaterThan(0))
                .get(0)
                .shouldHave(Condition.text(expected));
    }
}
