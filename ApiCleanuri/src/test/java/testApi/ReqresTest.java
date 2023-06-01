package testApi;

import io.restassured.http.ContentType;
import org.junit.Test;
import java.io.IOException;
import static io.restassured.RestAssured.given;

/**
*   Позитивный сценарий:
 *  1. Ввод валидной ссылки;
 *  2. Замена "%" на "+" при кодировки пробела
 *
 *  Негативный сценарий:
 *  1. Отправка пустой строки;
 *  2. Отправка ссылки без протокола;
 *  3. Отправка ссыдки без домена верхнего уровня
 *
 *  Чтение ссылок осуществляется из "resourseByTest.properties"
 */

public class ReqresTest {

    private final static String URL = "https://cleanuri.com/";

   @Test
    public void TestPositiveCheck() throws IOException {
       System.getProperties().load(ClassLoader.getSystemResourceAsStream("resourseByTest.properties"));
       String validLink = System.getProperty("url");
       Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOk200());
        Clin clin = new Clin( "url", validLink);
         given()
                 .contentType(ContentType.JSON)
                 .body(clin)
                 .when()
                 .post("api/v1/shorten")
                 .then().log().all();
    }

    @Test
    public void TestPositiveCheckchangePercentToPlus() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("resourseByTest.properties"));
        String percentToPlus = System.getProperty("url2");
        Specifications.installSpecification(Specifications.requestSpec(URL),Specifications.responseSpecOk200());

        Clin clin = new Clin( "url",percentToPlus);
        given()
                .contentType(ContentType.JSON)
                .body(clin)
                .when()
                .post("api/v1/shorten")
                .then().log().all();
    }

    @Test
    public void TestNegativeCheckEmptyLine(){
            Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecNoOk400());
            Clin clin = new Clin("url", " ");
            given()
                    .contentType(ContentType.JSON)
                    .body(clin)
                    .when()
                    .post("api/v1/shorten")
                    .then().log().all();
    }

    @Test
    public void TestNegativeCheckSendLinkWithoutProtocol() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("resourseByTest.properties"));
        String sendLinkWithoutProtocol = System.getProperty("url3");
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecNoOk400());
        Clin clin = new Clin("url", sendLinkWithoutProtocol);
        given()
                .contentType(ContentType.JSON)
                .body(clin)
                .when()
                .post("api/v1/shorten")
                .then().log().all();
    }

    @Test
    public void TestNegativeChecknoTopLevelDomain() throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("resourseByTest.properties"));
        String noTopLevelDomain = System.getProperty("url4");
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.responseSpecNoOk400());
        Clin clin = new Clin("url", noTopLevelDomain);
        given()
                .contentType(ContentType.JSON)
                .body(clin)
                .when()
                .post("api/v1/shorten")
                .then().log().all();
    }
}
