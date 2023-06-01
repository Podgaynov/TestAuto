import org.junit.Test;

public class SettingsPageByTest {

    private static final String BASE_URL = "https://people.sovcombank.ru/vacancies";


    @Test
    public void connect() throws InterruptedException {


        ÑonnectionSite ñonnectionSite = new ÑonnectionSite(BASE_URL);
        SelectorAndMethods selectorAndMethods = new SelectorAndMethods();
        selectorAndMethods.clickOnInputCity();
        selectorAndMethods.citySelectionMoscow();
        selectorAndMethods.clickOnInputCompany();
        selectorAndMethods.citySelectionCompany();
        Thread.sleep(5000);
        selectorAndMethods.arrayCityAndCompany();

    }

}
