package resources;

public enum APIResources {

	ADDPlaceAPI("/maps/api/place/add/json"),
	getPlaceAPI("/maps/api/place/get/json"),
	DeletePlaceAPI("/maps/api/place/delete/json");
	

	private String resource;
	
	// RESOURCES VALUE IS PASSED FROM GIVEN BLOCK AT RUNTIME AS TO WHICH RESOURCE TO BE CALLED AT THAT TIME
	
	// valueof is passed from page where it is called 
	APIResources(String resources) {
		
		this.resource=resources; // THIS RESOURCES HAVE THE VALUE OF ADDPlaceAPI - DELETEPlaceAPI - gETPlaceAPI
	}
	
	public String getResources()
	{
		return resource;
		
	}
}
