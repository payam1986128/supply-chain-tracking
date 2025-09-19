package ir.greenweb.examples.supplychaintracking.application;

import io.restassured.RestAssured;
import ir.greenweb.examples.supplychaintracking.contract.enumeration.Role;
import ir.greenweb.examples.supplychaintracking.contract.presentation.dto.user.CreateUserRequest;
import jakarta.annotation.PostConstruct;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SupplyChainTrackingApplicationTests {

    @LocalServerPort
    public int serverPort;

    @PostConstruct
    public void initRestAssured() {
        RestAssured.port = serverPort;
    }

    @Test
    void givenUserData_whenCreateUser_thenSuccess() {
        CreateUserRequest request = new CreateUserRequest();
        request.setUsername("admin");
        request.setPassword("password");
        request.setRole(Role.MANUFACTURER);

        RestAssured
                .given()
                    .contentType(APPLICATION_JSON_VALUE)
                    .accept(APPLICATION_JSON_VALUE)
                .when()
                    .with().body(request)
                    .post("/api/auth/users")
                .then()
                    .statusCode(HttpStatus.CREATED.value())
                    .body("id", Matchers.notNullValue());
    }

    @Test
    void givenGetProducts_whenNotProvidedAccessToken_thenUnauthorised() {
        RestAssured
                .given()
                    .accept(APPLICATION_JSON_VALUE)
                .when()
                    .get("/api/products")
                .then()
                    .statusCode(HttpStatus.UNAUTHORIZED.value());
    }
}
