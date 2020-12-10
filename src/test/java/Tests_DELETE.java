import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Tests_DELETE {
    @Test
    public void test_1_delete()  {

                when().
                delete("https://reqres.in/api/users/2").
                then().
                statusCode(204).log().all();
    }
}
