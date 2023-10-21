package helper;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;

public class Base {
	RequestSpecBuilder req;

	public static void setup() throws IOException {
		new RequestSpecBuilder().setBaseUri(config("BaseURI")).addQueryParam("key", "qaclick123")
				.setContentType(ContentType.JSON).build();
	}

	public static String config(String key) throws IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty(("user.dir") + "src\\test\\java\\resource\\env.properties"));
		Properties prop = new Properties();
		prop.load(file);
		return prop.getProperty(key);
	}

}
