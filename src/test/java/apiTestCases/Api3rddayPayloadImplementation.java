package apiTestCases;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import resource.Payload;

public class Api3rddayPayloadImplementation {
	@Test(priority=0, description="creating place", invocationCount=2)
	public void payloadImplementation() {

		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body(Payload.CreatePlacePayload()).when().post("maps/api/place/add/json").then().assertThat()
				.statusCode(200).extract().response();
		String response = res.asString();

		System.out.println(response);
	}

}
