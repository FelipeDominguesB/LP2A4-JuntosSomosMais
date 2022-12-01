package com.challenge.models;

public class Coordinates {

	public Coordinates(String latitude, String longitude)
	{
		this.latitude = Double.parseDouble(latitude);
		this.longitude =  Double.parseDouble(longitude);
	}
	
	public Double latitude;
	public Double longitude;
}
