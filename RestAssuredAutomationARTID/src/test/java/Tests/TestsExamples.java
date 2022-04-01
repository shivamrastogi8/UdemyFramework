package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;


//static import
import static io.restassured.RestAssured.*;

import io.restassured.response.Response;

public class TestsExamples {
	
	@Test
	public void test1()
	{
		//if we not use static import then we can have methods written like this
		//Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		
		//in case of static import below is the implementation
		Response response = get("https://reqres.in/api/users?page=2");
		
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getBody().asString());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void tesst2()
	{
		baseURI = "https://reqres.in/api/";
		given().get("users?page=2").then().statusCode(200);
	}

}
