package apiTestCases;

import java.util.ArrayList;
import java.util.List;

import apiTestCases.POJOUserInformation.Location;

public class POJOImplementation {
	POJOUserInformation user = new POJOUserInformation();

	public void  pojoPractice() {
		user.setAddress("noida");
		user.setAge(20);
		user.setName("rounik");
		user.setPhoneno(289375203);
		List<String> list = new ArrayList<String>();
			list.add("park");
			list.add("local");
			user.setTypes(list);
			
	}
	
}
