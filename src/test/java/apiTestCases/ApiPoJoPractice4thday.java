package apiTestCases;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ApiPoJoPractice4thday {
	String actualplaceid;

	@Test(priority = 0, description = "creating google place complete implementation of google place api", invocationCount = 1)
	public void CreategooglePlace() {
		// https://rahulshettyacademy.com/maps/api/place/add/json?key =qaclick123
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res = given().queryParam("key", "qaclick123").header("Content-Type", "application/json").log().all()
				.body("{\r\n" + "  \"location\": {\r\n" + "    \"lat\": -38.383494,\r\n" + "    \"lng\": 35.427362\r\n"
						+ "  },\r\n" + "  \"accuracy\": 50,\r\n" + "  \"name\": \"Frontline park\",\r\n"
						+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
						+ "  \"address\": \"29, side layout, cohen 09\",\r\n" + "  \"types\": [\r\n"
						+ "    \"shoe park\",\r\n" + "    \"shop\"\r\n" + "  ],\r\n"
						+ "  \"website\": \"http://google.com\",\r\n" + "  \"language\": \"French-IN\"\r\n" + "}\r\n"
						+ "")
				.when().post("maps/api/place/add/json").then().statusCode(200).log().all().body("status", equalTo("OK"))
				.extract().response();

		String response = res.asString();
		JsonPath js = new JsonPath(response);
		actualplaceid = js.getString("place_id");
		System.out.println(actualplaceid);

	}

	@Test(priority = 1)
	public void GetPlaceAPi() {
		// https://rahulshettyacademy.com/maps/api/place/get/json?place_id=e28b7e7799109997617fde09ed98ea6b&key=qaclick123
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res1 = given().queryParam("key", "qaclick123").queryParam("place_id", actualplaceid)
				.header("Content-Type", "application/json").log().all().when().get("maps/api/place/get/json").then()
				.log().all().statusCode(200).extract().response();
		String response1 = res1.asString();
		JsonPath js1 = new JsonPath(response1);
		System.out.println(js1.getString("place_id"));

	}

	@Test(priority = 2)
	public void UpdategooglePlace() {
		// https://rahulshettyacademy.com/maps/api/place/update/json?place_id=98c85d6e20d65ef36d6a63cdeba920cc&key=qaclick123
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		Response res2 = given().queryParam("key", "qaclick123").queryParam("place_id", actualplaceid)
				.body("{\r\n" + "\"place_id\":\"" + actualplaceid + "\",\r\n" + "\"address\":\"Sector 62 Noida\",\r\n"
						+ "\"key\":\"qaclick123\"\r\n" + "}")
				.header("Content-Type", "application/json").log().all().when().put("maps/api/place/update/json").then()
				.log().all().statusCode(200).extract().response();
		String response2 = res2.asString();
		JsonPath js2 = new JsonPath(response2);
		System.out.println(js2.getString("msg"));

	}

}
