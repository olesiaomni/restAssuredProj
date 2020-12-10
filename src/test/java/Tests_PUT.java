import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Tests_PUT {
    @Test
    public void test_1_put()  {

        JSONObject request = new JSONObject();

        request.put("name", "Omni");
        request.put("job", "QA");

        System.out.println(request.toString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                put("https://reqres.in/api/users").
                then().
                statusCode(200).log().all();

    }
}
