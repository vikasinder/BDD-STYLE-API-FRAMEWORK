package stepDefinations;

import java.io.IOException;

import io.cucumber.java.Before;

public class Hooks {
	
	@Before("@DeletePlaceApi")
	public void beforeScenarion() throws IOException
	{
		apiAddPlaceStepDefination defination=new apiAddPlaceStepDefination();
		if(apiAddPlaceStepDefination.placeId==null)
		{
		defination.you_are_having_payload("Inder", "Spanish");
		defination.user_calls_with_resquest("ADDPlaceAPI", "POST");
		defination.verify_place_id_created_maps_to_using("Inder", "getPlaceAPI");
		}
	}

}
