import com.google.gson.Gson;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class CustomerTests {

    private final String URL = "http://localhost:3001";
    private static Gson gson;

    @BeforeAll
    private static void setUp(){
        gson = new Gson();
    }

    @Test
    public void companySize(){

        String rawPayLoad = given()
                .baseUri(URL).body("localhost:3001")
                .when()
                 .post().body().prettyPrint();

        Map customers = gson.fromJson(rawPayLoad, Map.class);
        ((List<Map>) customers.get("customers")).stream()
                .forEach((Map c)->{ int employees = (Integer) c.get("employees");
                String size = (String) c.get("size");

                });


        System.out.println(customers);

    }

}
