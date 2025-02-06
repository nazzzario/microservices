package com.mic.order;

import com.mic.order.stubs.InventoryClientStub;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.context.annotation.Import;

import static org.hamcrest.Matchers.equalTo;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWireMock(port = 0)
class OrderServiceApplicationTests {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void shouldPlaceOrder() {
        String requestBody = """
                {
                	"skuCode": "iphone_16",
                	"price": 1000,
                	"quantity": 1
                }
                """;

        InventoryClientStub.stubInventoryCall("iphone_16", 1);

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v1/orders")
                .then()
                .statusCode(201)
                .body(equalTo("Order placed successfully"));
    }

    @Test
    void shouldNotPlaceOrder() {
        String requestBody = """
                {
                	"skuCode": "iphone_16",
                	"price": 1000,
                	"quantity": 101
                }
                """;

        InventoryClientStub.stubBadInventoryCall("iphone_16", 101);

        RestAssured.given()
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/api/v1/orders")
                .then()
                .statusCode(500);
    }

}
