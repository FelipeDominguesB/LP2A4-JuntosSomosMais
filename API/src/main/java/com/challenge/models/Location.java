package com.challenge.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.challenge.helpers.GeneralHelpers;

@Entity
@Table(name = "Location")
public class Location {

	public Location() {}
	public Location(String street, String city, String state, int postcode)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.postcode = postcode;
		this.region = GeneralHelpers.GetRegiao(state);
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	@Column(name = "region")
	private String region;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "postcode")
	private int postcode;
	
	@OneToOne(mappedBy = "location")
	private Insumo insumo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "coordinates_id", referencedColumnName = "id")
	private Coordinates coordinates;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "timezones_id", referencedColumnName = "id")
	private Timezone timezones;


	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPostcode() {
		return postcode;
	}
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
	public Coordinates getCoordinates() {
		return coordinates;
	}
	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	public Timezone getTimezones() {
		return timezones;
	}
	public void setTimezones(Timezone timezones) {
		this.timezones = timezones;
	}

	
	
	
}
