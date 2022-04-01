package Tests;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchDeleteExample {
	
	@Test
	public void putTest1()
	{
		JSONObject request = new JSONObject();
		request.put("name", "Shivam");
		request.put("job", "Tester");
		
		baseURI = "https://reqres.in/api";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void patchTest1()
	{
		JSONObject request = new JSONObject();
		request.put("name", "Shivam");
		request.put("job", "Tester");
		
		baseURI = "https://reqres.in";
		
		given().
			header("Content-Type", "application/json").
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/api/users/2").
		then().
			statusCode(200).
			log().all();
	}
	
	
	@Test
	public void DeleteTest1()
	{
		baseURI = "https://reqres.in";
		
		when().
			delete("/api/users/2").
		then().
			statusCode(204);
	}
}
