import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class DataDrivenExamples extends DataForTests {


    @Parameters({"userId"})
    @Test(dataProvider = "DataForPost")
    public void testPost(String firstName, String lastName, int subjectId) {
        JSONObject resuest = new JSONObject();
        resuest.put("firstName", firstName);
        resuest.put("lastName", lastName);
        resuest.put("subjectId", subjectId);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(resuest.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().all();
    }


    @Test(dataProvider = "DeleteData")
    public void testDelete(int userId) {
        baseURI = "http://localhost:3000/";

        when().
                delete("/users/" + userId).
                then().
                statusCode(200);
    }
}
