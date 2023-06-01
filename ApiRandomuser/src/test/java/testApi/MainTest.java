package testApi;

import io.restassured.http.ContentType;
import org.junit.Test;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

public class MainTest {
/**
*Позитивный сценарий:
 * 1. Преобразование ответа в объект;
 * 2. Создание 5 пользователей;
 *
 * Негативный сценарий:
 * 1. Ссылка с пробелом;
 * 2. Указать версию API через запятую;
*/

    private final static String URL = "https://randomuser.me/";

    @Test
    public void conversionToObject(){

        List<UserData> users = given()
                .contentType(ContentType.JSON)
                .when()
                .get( URL+"api/?gender=female&results=5")
                .then().log().all()
                .body("results.info.results", notNullValue())
                .extract().body().jsonPath().getList("results.info",UserData.class);
    }

    @Test
    public void creationOfFiveUsers(){

      given()
                .contentType(ContentType.JSON)
                .when()
                .get( URL+"api/?gender=female&results=5")
                .then().log().all()
                .body("info.results",equalTo(5));
    }

    @Test
    public void linkWithASpace(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get( URL+"api/ ?format=csv")
                .then().log().all()
                .statusCode(404);
    }

    @Test
    public void commaSeparatedSersion(){
        given()
                .contentType(ContentType.JSON)
                .when()
                .get( URL+"api/1,4")
                .then().log().all()
                .statusCode(404);
        }
    }
