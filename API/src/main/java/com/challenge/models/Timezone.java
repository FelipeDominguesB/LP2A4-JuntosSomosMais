package com.challenge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name = "Timezone")
@Table(name = "timezone")
public class Timezone {

	public Timezone() {}
	
	public Timezone(String offset, String description)
	{
		this.offset = offset;
		this.description = description;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	@Column(name = "offset")
	private String offset;
	
	@Column(name = "description")
	private String description;
	
	@OneToOne(mappedBy = "timezones")
	private Location location;


	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
