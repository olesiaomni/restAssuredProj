import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Tests_POST {

    @Test
    public void test_1_post()  {
       /* Map<String, Object> map = new HashMap<String, Object>();
        map.put("name", "Omni");
        map.put("job", "QA");
        JSONObject request = new JSONObject(map);

        request.put("name", "Omni");
        request.put("job", "QA");
        System.out.println(map);
*/

        JSONObject request = new JSONObject();

        request.put("name", "Omni");
        request.put("job", "QA");

        System.out.println(request.toString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).accept(ContentType.JSON).
                body(request.toJSONString()).
                when().
                post("https://reqres.in/api/users").
                then().
                statusCode(201).log().all();
    }
}
