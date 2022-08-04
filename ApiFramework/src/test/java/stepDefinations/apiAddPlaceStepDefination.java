package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojoClasses.addNewPlace;
import pojoClasses.lonLatitude;
import pojoClasses.responseJsonRecieved;
import resources.APIResources;
import resources.TestDataBuild;
import utils.specBuilderSpecifications;

import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;

import static io.restassured.RestAssured.given;
	public class apiAddPlaceStepDefination extends specBuilderSpecifications {
		
		// SPECBUILDERSPECIFICATION CLASS IS EXTENDED HERE AS IT HAS METHODS(REQUEST SEPCIFICATION / RESPONSE SEPCIFICATION ) THAT ARE NEEDED IN EVERY CLASS
		
		TestDataBuild data=new TestDataBuild();
		RequestSpecification   payLoadSend;
		responseJsonRecieved response;
		Response responsequesry;
		JsonPath json;
		String actualvalue;
		static	String placeId;
		@Given("you are having payload")
		public void you_are_having_payload() throws IOException {
		
			// Given - Query Parameters + Header value( JSON / XML ) + Body ( Payload )
				
///////////// THIS IS A POST REQUEST  ////////////////////
		//Given : All Input Details
				//When : Submit The API / Resource
				//Then : Validate the Response
				// Given - Query Parameters + Header value( JSON / XML ) + Body ( Payload )
		// check instead of writing complete , we are using spec builder class
		// BREAKING REQUEST BODY AND WHEN THE REPONSE COMES FROM EACH OTHER IN DIFFRENT WAY 
		
			payLoadSend=given().spec(requestSpecification())
					.body(data.addPlacePayload());
		
			
		}

		@Given("you are having payload {string}{string}")
		public void you_are_having_payload(String name, String lang) throws IOException {

			payLoadSend=given().spec(requestSpecification())
					.body(data.addPlacePayload(name,lang));
		
		
		}

		@When("User Calls {string} with {string} resquest")
		public void user_calls_with_resquest(String resource, String method_of_request) {

		// DYNAMICALLY GETTING VALUE OF API REQUEST COMPLETE PATH FOR APRICYULAR REQUEST- DELETE ADD GET -
			// /maps/api/place/add/json --- /maps/api/place/get/json --- /maps/api/place/delete/json
			
		APIResources resourceApi= APIResources.valueOf(resource);// RESOURCE HAVING VALUE OF (ADDPlaceApi,DeletePalceApi,getPlaceApi) 
		
		
		
		// this code is invoking constructor of APIResource page
		// AND VALUE OF METHOD WILL RETURN VALUE OF ADDPlaceAPi which is - /maps/api/place/add/json
		
		
		//*************************************************/////
//		if(resourceApi.getResources()=="/maps/api/place/add/json") 
//		{
//			response	 = payLoadSend.when().post(resourceApi.getResources())// WHEN GET RESOURCE METHOD IS CALLING IT IS RETURNING GLOBAL VARIABLE VALUE OF RESOURCE
//					.then().assertThat().spec(responseSpecification())
//					.extract().response().as(responseJsonRecieved.class);
//			System.out.println("add code executed");
//			
//		}
//		else if (resourceApi.getResources()=="/maps/api/place/delete/json") {
//			response	 = payLoadSend.when().post(resourceApi.getResources())// WHEN GET RESOURCE METHOD IS CALLING IT IS RETURNING GLOBAL VARIABLE VALUE OF RESOURCE
//					.then().assertThat().spec(responseSpecification())
//					.extract().response().as(responseJsonRecieved.class);
//			System.out.println("delete code executed");// NOT WRITTEN JSON RESPONSE
//		
//		}else {
//			
//			response	 = payLoadSend.when().post(resourceApi.getResources())// WHEN GET RESOURCE METHOD IS CALLING IT IS RETURNING GLOBAL VARIABLE VALUE OF RESOURCE
//					.then().assertThat().spec(responseSpecification())
//					.extract().response().as(responseJsonRecieved.class);
//			System.out.println("get code executed");
//			
//			}
		//************************************************************//
		if(method_of_request.equalsIgnoreCase("POST"))
			responsequesry=payLoadSend.when().post(resourceApi.getResources());
		else if(method_of_request.equalsIgnoreCase("GET"))
			responsequesry=payLoadSend.when().get(resourceApi.getResources());
		
		}
		
		
		@Then("The APi call Got SUCCESS with status code {int}")
		public void the_a_pi_call_got_success_with_status_code(Integer status) {
		  
	//		System.out.println((response.getStatus().toString()));
			Assert.assertEquals(responsequesry.getStatusCode(),200);
			
			String deleteValue=responsequesry.asString();
			json=new JsonPath(deleteValue);// and then that string value is sent so as to get it converted to object
			
			placeId=	json.get("place_id");
		}
		
		@Then("{string} In Response Body Is {string}")
		public void in_response_body_is(String Key, String Value) {
		    
//		String expectedScope=	response.getStatus().toString();
//			Assert.assertEquals(expectedScope,Value);
//			
			actualvalue=responsequesry.asString();// Response is converted to string
			//System.out.println(actualvalue);
			json=new JsonPath(actualvalue);// and then that string value is sent so as to get it converted to object
			String keyCheck=	json.get("status");
			placeId=	json.get("place_id");
			
			Assert.assertEquals(keyCheck,Value);
			
			
		}
	
	
		@Then("verify place_id created maps to {string} using {string}")
		public void verify_place_id_created_maps_to_using(String name, String resourceValue) throws IOException {
			
			String	placeId=	getJsonPath(responsequesry, "place_id");
			payLoadSend=given().spec(requestSpecification()).queryParam("place_id", placeId);
		
			user_calls_with_resquest(resourceValue,"GET"); // WE DONT HAVE TO WRITE THAT METHOD AGAIN 
//			// WE CAN USE THE SAME METHOD THAT WE HAVE USED WHEN WE (When User Calls "ADDPlaceAPI" with "POST" resquest )
//			// THIS IS ANOTHER WAY TO USE THAT FUNCTION AGAIN
//			
//			actualvalue=responsequesry.asString();// Response is converted to string
//			json=new JsonPath(actualvalue);// and then that string value is sent so as to get it converted to object
//			String actualName=	json.get("name").toString();
//			
//			//********************************///
//			
			
			
			// BY using another method
//			
			String actualName=getJsonPath(responsequesry,"name");// BY USING METHOD WE ARE PASSING VARIABLE OF TYPE RESPONSE AND KEY WHOSE VALUE WE NEEDS TO GET
	
			Assert.assertEquals(actualName,name);
		
			
			//*******************************//
		}
		
		
		@Given("you are having deleteplace payload")
		public void you_are_having_deleteplace_payload() throws IOException {

			
			payLoadSend=given().spec(requestSpecification()).body("{\r\n"
					+ "    \"place_id\":\""+placeId+"\"\r\n"
					+ "}\r\n"
					+ "");
		
			
		}

	
}
