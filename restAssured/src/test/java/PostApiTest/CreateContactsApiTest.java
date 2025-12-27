package PostApiTest;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.io.File;

public class CreateContactsApiTest {
	
	@Test
	public void createContactsTest() {
		
		baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		given()
			.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OTI1ZDQ5MTI1MzBlYzAwMTU3MGFiOTMiLCJpYXQiOjE3NjY4Mzc5MjZ9.HxfeWX3MkY88QrvLfxPD2so7IoRkbPwVD8MIaLPNilA")
			.contentType(ContentType.JSON)
			.body(new File("./src/test/resources/jsons/contactsData.json"))
				.when()
					.post("/contacts")
						.then().log().all()
							.assertThat()
								.statusCode(201);
		
	}
	

}
