package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetAndPostExamplers {
	
	@Test
	public void test1()
	{
		baseURI= "https://reqres.in/api";
		given().
			get("/users?page=2").
		then().
			body("data[4].first_name", equalTo("George")).
			body("data.first_name", hasItems("George","Rachel")).
			statusCode(200);
	}

	
	@Test
	public void postTest1()
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
			post("/users").
		then().
			statusCode(201).
			log().all();


	}
}
