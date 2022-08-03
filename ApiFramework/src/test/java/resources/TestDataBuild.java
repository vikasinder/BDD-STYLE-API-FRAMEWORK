package resources;

import java.util.ArrayList;
import java.util.List;

import pojoClasses.addNewPlace;
import pojoClasses.lonLatitude;

public class TestDataBuild {
	
	addNewPlace place=new addNewPlace();
	
	public addNewPlace addPlacePayload()
	{
		
		place.setAccuracy(50);
		place.setAddress("95 charolais blvd Brampton");
		place.setLanguage("French");
		place.setWebsite("www.astrovikas.com");
		place.setPhone_number("647 832 2008");
		place.setName("vikas sharma");
		
		// AS SETTYPE EXPECT LIST OF VALUES SO WE HAVE TO USE ARRAYLIST FOR THAT
		
		List<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("pink");
		place.setTypes(list);
		
		
		// LONLATTITDE CLASS OBJECT IS PASSED SO WE HAVE TO DO IT LIKE THIS
		// FOR PASSING SUB JSON - YOU HAVE TO CREATE AN OBJECT OF SUB JSON FILE AND PASS IT TO MAIN JSON FILE
		// PARENT JSON
		lonLatitude lonlat=new lonLatitude();
		lonlat.setLat(23.000);
		lonlat.setLng(345.09);
		place.setLocation(lonlat);
		
		return place;
		
	}
	public addNewPlace addPlacePayload(String name,String value)
	{
		
		place.setAccuracy(50);
		place.setAddress("95 charolais blvd Brampton");
		place.setLanguage(value);
		place.setWebsite("www.astrovikas.com");
		place.setPhone_number("647 832 2008");
		place.setName(name);
		
		// AS SETTYPE EXPECT LIST OF VALUES SO WE HAVE TO USE ARRAYLIST FOR THAT
		
		List<String> list=new ArrayList<String>();
		list.add("shoe park");
		list.add("pink");
		place.setTypes(list);
		
		
		// LONLATTITDE CLASS OBJECT IS PASSED SO WE HAVE TO DO IT LIKE THIS
		// FOR PASSING SUB JSON - YOU HAVE TO CREATE AN OBJECT OF SUB JSON FILE AND PASS IT TO MAIN JSON FILE
		// PARENT JSON
		lonLatitude lonlat=new lonLatitude();
		lonlat.setLat(23.000);
		lonlat.setLng(345.09);
		place.setLocation(lonlat);
		
		return place;
		
	}

}
