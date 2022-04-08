package New;

import io.restassured.RestAssured;
import org.json.JSONObject;
import org.junit.Test;


public class AutotestProbe {
    @Test
    public void getTest() {
        RestAssured
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().statusCode(200);
    }
    @Test
    public void postTest() {
        JSONObject body = new JSONObject()
                .put("name", "miror")
                .put("job", "boss");

        RestAssured
                .given()
                .header("Content-type", "application/json")
                .and()
                .body(body)
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .assertThat().statusCode(201)
                .extract().response();
           }
}
