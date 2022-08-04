package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class specBuilderSpecifications {

	public static	RequestSpecification requestBuild;// we make it static so that it have only one instance throughout execution
	
	ResponseSpecification responseBuild;
	
	
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if(requestBuild==null)
		{
		PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
				requestBuild= new RequestSpecBuilder().setBaseUri(getGlobalValueProperties("baseUrl"))
				.addQueryParam("key", "qaclick123")
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON)
				.build();
				return requestBuild;
		}
		return requestBuild;
	}
	
	public ResponseSpecification responseSpecification()
	{
			
				responseBuild= new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
				return responseBuild;
	}
	
	
	public static String getGlobalValueProperties(String key) throws IOException
	{
		Properties prop=new Properties();
		FileInputStream file=new FileInputStream("C:\\Users\\vikas\\git\\BDDframeworkapistyle\\ApiFramework\\src\\test\\java\\utils\\global.properties");
		prop.load(file);
		return	prop.getProperty(key);
		
	}
	public String getJsonPath(Response res, String Key)
	{
		String responseValue=res.asString();
		JsonPath jsonResponse=new JsonPath(responseValue);
		return	jsonResponse.get(Key).toString();
	}
}
