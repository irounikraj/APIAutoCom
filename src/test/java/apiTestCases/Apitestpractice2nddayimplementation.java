package apiTestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

public class Apitestpractice2nddayimplementation {
	// https://rahulshettyacademy.com/maps/api/place/add/json?key =qaclick123
	@Test(priority=0, description="creating place", invocationCount=2)
	public void Createplace2nd() {
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.body("  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 33.427362\r\n"
						+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Frontline house\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"33, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"French-IN\"\r\n" + "}\r\n"
						+ "")
				.when().post("maps/api/place/add/json").then().log().all().assertThat().statusCode(200).extract()
				.response();
		String response = res.asString();

		JsonPath js = new JsonPath(response);
		String actualStatus = js.getString("status");
		System.out.println(actualStatus);
	}

}
