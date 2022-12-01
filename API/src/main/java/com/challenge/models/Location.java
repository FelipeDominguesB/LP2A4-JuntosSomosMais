package com.challenge.models;

import com.challenge.helpers.GeneralHelpers;

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
		this.region = GeneralHelpers.GetRegiao(state);
	}
	
	public String region;
	public String street;
	public String city;
	public String state;
	public int postcode;
	public Coordinates coordinates;
	public Timezone timezones;
	
}
