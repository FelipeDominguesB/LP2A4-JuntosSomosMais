package com.challenge.models;

public class Location {

	public Location(String street, 
			String city, 
			String state, 
			int postcode)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
	}
	
	public String street;
	public String city;
	public String state;
	public int postcode;
	public Coordinates coordinates;
	public Timezone timezones;
	
}
