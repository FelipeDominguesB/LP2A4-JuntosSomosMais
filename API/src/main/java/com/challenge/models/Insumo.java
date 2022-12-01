package com.challenge.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Insumo {

	private @Id @GeneratedValue Long id;
	public String gender;
	public String email;
	public NameInfo name;
	public Location location;
	public DateInfo dateOfBirth;
	public DateInfo registeredDate;
	public String telePhone;
	public String cellPhone;
	public PictureInfo pictureInfo;
	
	
}
