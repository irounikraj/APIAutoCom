package apiTestCases;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import requestPOJO.LocationChildPOJO;
import requestPOJO.createplaceGooglePOJO;
import rsponsePOJO.createplaceresponsepojo;

public class POJOIMPlementationFixed {
	String actualplaceid;

	@Test(priority = 0, description = "creating google place complete implementation of google place api", invocationCount = 1)
	public void CreategooglePlace() {

		createplaceGooglePOJO p = new createplaceGooglePOJO();
		LocationChildPOJO loc = new LocationChildPOJO();
		loc.setLat(-38.383494);
		loc.setLng(33.427362);
		p.setLocation(loc);
		p.setAccuracy(50);
		p.setName("Frontline area");
		p.setPhone_number("123456");
		p.setAddress("Noida");
		List<String> list = new ArrayList<String>();
		list.add("shoe park");
		list.add("shop");
		p.setTypes(list);
		p.setWebsite("http://google.com");
		p.setLanguage("French-IN");
		// https://rahulshettyacademy.com/maps/api/place/add/json?key =qaclick123
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		createplaceresponsepojo res = given().queryParam("key", "qaclick123").header("Content-Type", "application/json")
				.log().all().body(p).when().post("maps/api/place/add/json").then().statusCode(200).log().all()
				.body("status", equalTo("OK")).extract().response().as(createplaceresponsepojo.class);
		System.out.println(res.getId());
		System.out.println(res.getPlace_id());
		System.out.println(res.getReference());
		System.out.println(res.getScope());
		System.out.println(res.getStatus());

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
