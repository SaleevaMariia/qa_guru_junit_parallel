import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.api.parallel.ResourceLock;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import page.YandexMainPage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

//выполнение класса только в 1-м потоке
//@Execution(value = ExecutionMode.SAME_THREAD)
public class ParallelTests {


    //@ResourceLock("SelenideConfig")
    @ValueSource(
    strings = {
        "qa_guru",
        "selenide",
        "qameta",
        "allure"
    })
    @ParameterizedTest(name = "{0} test")
    void yandexSearchTest(String searchQuery, TestInfo testInfo) {
        Configuration.startMaximized = true;
        open("http://ya.ru");
        new YandexMainPage()
                .doSearch(searchQuery)
                .checkResults(searchQuery);
        System.out.println("Config for test:" +
                testInfo.getDisplayName() +
                " " + Configuration.startMaximized);
    }

    @Test
    void anotherTest(){
        assertTrue(true);
    }

    //блокировка параллельного запуска тестов
    // с одинаковыми строками в данной аннотации
    //@ResourceLock("SelenideConfig")
    @Test
    void minimizedTest(TestInfo testInfo){
        Configuration.startMaximized = false;
        open("http://ya.ru");
        new YandexMainPage()
                .doSearch("JDI")
                .checkResults("JDI");
        System.out.println("Config for test:" +
                testInfo.getDisplayName() +
                " " + Configuration.startMaximized);
    }
}
