package apiTestCases;

import java.util.List;

public class POJOUserInformation {
	
	private String name;
	private String address;
	private long phoneno;
	private int age; 
	private List<String> types;
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	private Location location;
	
	public class Location{
		private long lng;
		public long getLng() {
			return lng;
		}
		public void setLng(long lng) {
			this.lng = lng;
		}
		public long getLat() {
			return lat;
		}
		public void setLat(long lat) {
			this.lat = lat;
		}
		private long lat;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(long phoneno) {
		this.phoneno = phoneno;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
