package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class YandexMainPage {

    private SelenideElement searchInput = $(".input__control");
    private SelenideElement searchBtn = $("button[type='submit']");

    public YandexResultsPage doSearch(String query){
        searchInput.setValue(query);
        searchBtn.click();
        return new YandexResultsPage();
    }
}
