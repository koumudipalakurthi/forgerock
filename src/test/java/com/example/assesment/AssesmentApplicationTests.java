package com.example.assesment;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.runner.RunWith;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given; 

@RunWith(value=SpringRunner.class)
@SpringBootTest
public class AssesmentApplicationTests {
	private static String requestBody = "{\"featureConfiguration\": {\"id\": 1,\"name\": \"DeviceFeatures\",\"transforms\": [{\"name\": \"device_os\",\"useInML\": true,\"enabled\": true,\"jsltExpression\": \".device.osType\"},{\"name\": \"device_description\",\"useInML\": true,\"enabled\": true,\"jsltExpression\": \".device.osType + \\\" \\\" + .device.model\"}]},\"inputJson\": {\"eventId\": \"878237843\",\"device\": {\"osType\": \"Linux\",\"model\": \"Laptop\"},\"ip\": \"10.45.2.30\",\"sessionId\": \"ads79uoijd098098\"}}";

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:9673/forgerock/assesment/retrieve/mlfeatures";
    }

    // basic test case to check whether the API is giving 200 as status
    @Test
    public void postRequest() {
    	System.out.println("Enetered");
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post()
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertNotNull(response);
    }
}
