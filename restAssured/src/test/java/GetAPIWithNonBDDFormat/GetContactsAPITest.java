package GetAPIWithNonBDDFormat;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetContactsAPITest {

	@Test(enabled=false)
	public void getContactsTest() {
		RestAssured.baseURI = "https://thinking-tester-contact-list.herokuapp.com";
		
		RequestSpecification request = RestAssured.given();
		request.header("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2OTI1ZDQ5MTI1MzBlYzAwMTU3MGFiOTMiLCJpYXQiOjE3NjY4Mzc5MjZ9.HxfeWX3MkY88QrvLfxPD2so7IoRkbPwVD8MIaLPNilA");
		
		Response response = request.get("/contacts");
		System.out.println("Ranjit---------------------------------");
		System.out.println("Status code is: "+response.statusCode());
		System.out.println("Status Line is: "+response.statusLine());
		//response.prettyPrint();
		Headers headers= response.headers();
		List<Header> headerList = headers.asList();
		for(Header e: headerList) {
			String headerName = e.getName();
			String headerValue = e.getValue();
			System.out.println("Header namer is: "+headerName+"                  and its value is:            "+headerValue);
		}
	}
	
	
}
