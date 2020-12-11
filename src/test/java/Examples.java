import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Examples {

    @Test
    public void testGet(){
        baseURI = "http://localhost:3000/";
        given().
                param("name", "Auto").
                get("/subjects").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testPost(){ //sreate new user
        JSONObject resuest = new JSONObject();
        resuest.put("firstName", "Tom");
        resuest.put("lastName", "Cooper");
        resuest.put("subjectId", 1);

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

    @Test
    public void testPatch(){ //update smth
        JSONObject resuest = new JSONObject();

        resuest.put("lastName", "Shepered");

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(resuest.toJSONString()).
                when().
                patch("/users/4").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testPut(){ //update smth
        JSONObject resuest = new JSONObject();

        resuest.put("firstName", "Mary");
        resuest.put("lastName", "Jane");
        resuest.put("subjectId", 1);

        baseURI = "http://localhost:3000/";

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                header("Content-Type", "application/json").
                body(resuest.toJSONString()).
                when().
                put("/users/4").
                then().
                statusCode(200).
                log().all();
    }

    @Test
    public void testDelete(){
        baseURI = "http://localhost:3000/";

        when().
                delete("/users/4").
                then().
                statusCode(200);
    }
}
