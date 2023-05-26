package placelab.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
import placelab.utils.AuthenticationRequest;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

public class LoginTest {
    private static final Logger LOGGER = Logger.getLogger("Login Test");


    @Test(priority = 1)
    public void testLoginValidCredentials() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest();
        LOGGER.info("Submit authentication POST request");

        //GIVEN
        given()
                .baseUri("https://demo.placelab.com")
                .contentType("application/json")
                .body(authenticationRequest.requestBody.toString())

                //WHEN
                .when().post("/api/v2/sessions")
//
//                //THEN
                .then()
                .statusCode(201)
                .contentType("application/json")
                .body("api_token", notNullValue());
    }

    Faker faker = new Faker();
    private final String emailFake = faker.internet().emailAddress().toString();
    private final String passwordFake = faker.internet().password().toString();

    @Test(priority = 2)
    public void testLoginInvalidCredentials() {
        AuthenticationRequest authenticationRequest = new AuthenticationRequest(emailFake, passwordFake);
        LOGGER.info("Submit authentication POST request");

        //GIVEN
        given()
                .baseUri("https://demo.placelab.com")
                .contentType("application/json")
                .body(authenticationRequest.requestBody.toString())

                //WHEN
                .when()
                .post("/api/v2/sessions")

                //THEN
                .then()
                .statusCode(401)
                .contentType("application/json")
                .body("error", equalTo("Password mismatch."));
    }
}
