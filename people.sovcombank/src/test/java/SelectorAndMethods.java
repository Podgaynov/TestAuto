import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.assertj.core.api.Assertions;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class SelectorAndMethods extends BaseTest {


    public final SelenideElement inputCity = $x("//*[@id='input-110']");
    public final SelenideElement selectMoscow = $x("//*[@id='list-item-138-0']");
    public final SelenideElement inputCompany = $x("//*[@class='v-select__selections'][1]");
    public final SelenideElement selectCompany = $x("//*[text()='Совкомбанк Технологии']");

    ElementsCollection array = $$x("//span[@class='t2vac']");


    public void clickOnInputCity() {
        inputCity.click();
    }

    public void citySelectionMoscow() {
        selectMoscow.click();
    }

    public void clickOnInputCompany() {
        inputCompany.click();
    }

    public void citySelectionCompany() {
        selectCompany.click();
    }


    public void arrayCityAndCompany() {

        List<String> arras = array.stream().map(SelenideElement::getText).collect(Collectors.toList());
        Assertions.assertThat(arras)
                .allMatch(buildPredicat());

    }

    private Predicate<? super String> buildPredicat() {
        return s -> s.contains("Москва") && s.contains("Совкомбанк Технологии");
    }


}
