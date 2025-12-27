package PostApiDifferentBodyTypes;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostApiDifferentBody {

	@Test
	public void bodyWithPlainTextTest() {
		
		baseURI = "https://postman-echo.com";
		
		given()
			.contentType(ContentType.TEXT)
			.body("This is Ranjit")
				.when()
					.post("/post")
						.then().log().all()
							.assertThat()
							.statusCode(200);
		
	}
	
	@Test
	public void bodyWithJavascriptTest() {
		
		baseURI = "https://postman-echo.com";
		
		String payload = "<script>\n"
				+ "var x, y, z;  // Declare 3 variables\n"
				+ "x = 5;    // Assign the value 5 to x\n"
				+ "y = 6;    // Assign the value 6 to y\n"
				+ "z = x + y;  // Assign the sum of x and y to z\n"
				+ "\n"
				+ "document.getElementById(\"demo\").innerHTML =\n"
				+ "\"The value of z is \" + z + \".\";\n"
				+ "</script>";
		
		given()
			.contentType(ContentType.JSON)
			.body(payload)
				.when()
					.post("/post")
						.then().log().all()
							.assertThat()
							.statusCode(200);
		
	}
	
	

	@Test
	public void bodyWithHTMLTest() {
		
		baseURI = "https://postman-echo.com";
		
		String payload = "<!DOCTYPE html>\n"
				+ "<html>\n"
				+ "<body>\n"
				+ "\n"
				+ "<h1>My First Heading</h1>\n"
				+ "\n"
				+ "<p>My first paragraph.</p>\n"
				+ "\n"
				+ "</body>\n"
				+ "</html>\n"
				+ "";
		
		given()
			.contentType(ContentType.HTML)
			.body(payload)
				.when()
					.post("/post")
						.then().log().all()
							.assertThat()
							.statusCode(200);
		
	}
	
	@Test
public void bodyWithXMLTest() {
		
		baseURI = "https://postman-echo.com";
		
		String payload = " <dependency>\n"
				+ "      <groupId>io.rest-assured</groupId>\n"
				+ "      <artifactId>rest-assured</artifactId>\n"
				+ "      <version>6.0.0</version>\n"
				+ "</dependency>";
		
		given().log().all()
			.contentType("application/xml;charset=utf-8")
			.body(payload)
				.when()
					.post("/post")
						.then().log().all()
							.assertThat()
							.statusCode(200);
		
	}
	
	
	@Test
	public void bodyWithMultiPartTest() {
			
			baseURI = "https://postman-echo.com";
			
			given().log().all()
				.contentType(ContentType.MULTIPART)
				.multiPart("resume", new File("./src/test/resources/files/Resume.pdf"))
				.multiPart("Name", "Ranjit")
					.when()
						.post("/post")
							.then().log().all()
								.assertThat()
								.statusCode(200);
			
		}
	
	

	@Test
	public void bodyWithPDFFileTest() {
			
			baseURI = "https://postman-echo.com";
			
			given().log().all()
				.contentType("application/pdf;charset=utf-8")
				.body(new File("/Users/ranjitsinghsaluja/Downloads/AirtelWifiBillRanjit.pdf"))
					.when()
						.post("/post")
							.then().log().all()
								.assertThat()
								.statusCode(200);
			
		}
	
	@Test
	public void bodyWithImageFileTest() {
			
			baseURI = "https://postman-echo.com";
			
			given().log().all()
				.contentType("image/jpeg")
				.body(new File("//Users/ranjitsinghsaluja/Downloads/Almirah.jpeg"))
					.when()
						.post("/post")
							.then().log().all()
								.assertThat()
								.statusCode(200);
			
		}
	
}
