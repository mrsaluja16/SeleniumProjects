package PostApiTest;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;

public class CreateUserApiTest {
	
	public String getRandomEmailId() {
		return "apiautomation"+System.currentTimeMillis()+"@learning.com";
	}
	
	@Test
	public void createUserWithJSONStringTest() {
		RestAssured.baseURI = "https://gorest.co.in";

		String email = getRandomEmailId();
		
		given().log().all()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.contentType(ContentType.JSON)
			.body("{\n"
					+ "        \"name\": \"Tanya Bhagat\",\n"
					+ "        \"email\": \""+email+"\",\n"
					+ "        \"gender\": \"female\",\n"
					+ "        \"status\": \"active\"\n"
					+ "    }")
				.when()
					.post("/public/v2/users")
						.then().log().all()
							.assertThat().statusCode(201);
	}
	
	@Test
	public void createUserWithJSONFileTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		System.out.println("");
		given().log().all()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/jsons/userData.json"))
			.when()
				.post("/public/v2/users")
					.then().log().all()
						.assertThat().statusCode(201);
	}
	
	@Test
	public void createUserWithJSONFileEmailStringReplacementTest() throws Exception {
		RestAssured.baseURI = "https://gorest.co.in";
		
		String email = getRandomEmailId();
		
		String rawJson = new String(Files.readAllBytes(Paths.get("./src/test/resources/jsons/userData.json")));
		String updatedJson = rawJson.replace("{{email}}", email);
		
		Integer userID =  given().log().all()
			.header("Authorization", "Bearer d27acb07a309596ffa68b0b7766230cdf973efdc94c5c77747408de941f3c4fd")
			.contentType(ContentType.JSON)
			.body(updatedJson)
			.when()
				.post("/public/v2/users")
					.then().log().all()
						.assertThat().statusCode(201)
						.and()
						.extract()
						.path("id");
		
		System.out.println("Newly created user, user id is: "+userID);
	}
}
