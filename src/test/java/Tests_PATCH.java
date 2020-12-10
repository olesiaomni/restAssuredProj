import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Tests_PATCH {

    @Test
    public void test_1_patch() {

        JSONObject request = new JSONObject();

        request.put("name", "Omni");
        request.put("job", "QA");

        System.out.println(request.toString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                patch("https://reqres.in/api/users").
                then().
                statusCode(200).log().all();

    }
}
