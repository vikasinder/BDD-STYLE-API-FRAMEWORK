Feature: Validating Place Api's
				
@Test1
Scenario: Verify if place is being successfully added using ADD Place Api
	Given you are having payload
	When User Calls "ADDPlaceAPI" with "POST" resquest  
	Then The APi call Got SUCCESS with status code 200
	And "status" In Response Body Is "OK"
@Test2	
Scenario Outline: Verify if place is being successfully added using ADD Place Api
	Given you are having payload "<name>""<language>"
	When User Calls "ADDPlaceAPI" with "POST" resquest  
	Then The APi call Got SUCCESS with status code 200
	And "status" In Response Body Is "OK"
	And verify place_id created maps to "<name>" using "getPlaceAPI"
	Examples:
	|name|language|
	|vishal|Spanish|
	