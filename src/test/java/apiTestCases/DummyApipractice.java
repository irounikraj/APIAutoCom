package apiTestCases;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyApipractice {

	// https://dummy.restapiexample.com/api/v1/create
	@Test(priority=0, description="creating place", invocationCount=2)
	public void createdummy() {
		RestAssured.baseURI = "https://dummy.restapiexample.com";
		Response res = given().header("Content-Type", "application/json").log().all()
				.body("	\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"").when().post("api/v1/create").then()
				.assertThat().statusCode(200).log().all().extract().response();
		String response = res.asString();
		System.out.println(response);
		JsonPath js = new JsonPath(response);
		String actualStatus = js.getString("status");
		System.out.println("proceeding......................");
		Assert.assertEquals(actualStatus, "success");
	}

	@Test(priority=1, description="creating place", invocationCount=2)
	public void putrequestDummy() {
		// https://dummy.restapiexample.com/api/v1/update/21
		Response res1 = given().log().all().header("Content-Type", "application/json")
				.body("{\"name\":\"test\",\"salary\":\"123\",\"age\":\"23\"}").when().put("api/v1/update/21").then()
				.log().all().assertThat().statusCode(200).extract().response();
		String response1 = res1.asString();
		JsonPath js1 = new JsonPath(response1);
		String actualstatus1 = js1.getString("status");
		Assert.assertEquals(actualstatus1, "success");

	}

}
