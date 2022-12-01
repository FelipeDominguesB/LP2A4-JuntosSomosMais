package com.challenge.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity(name= "Insumo")
@Table(name = "insumo")
public class Insumo {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	@Column(name = "gender")
	private char gender;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "dateOfBirth")
	private Date dateOfBirth;
	
	@Column(name = "registeredDate")
	private Date registeredDate;
	
	@Column(name = "telePhone")
	private String telePhone;
	
	@Column(name ="cellPhone")
	private String cellPhone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "location_id", referencedColumnName = "id")
	private Location location;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "picture_id", referencedColumnName = "id")
	private PictureInfo pictureInfo;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "nameInfo_id", referencedColumnName = "id")
	private NameInfo name;
	
	@Column(name = "nationality")
	private String nationality;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public NameInfo getName() {
		return name;
	}

	public void setName(NameInfo name) {
		this.name = name;
	}

	
	public PictureInfo getPictureInfo() {
		return pictureInfo;
	}

	public void setPictureInfo(PictureInfo pictureInfo) {
		this.pictureInfo = pictureInfo;
	}
	
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getRegisteredDate() {
		return registeredDate;
	}

	public void setRegisteredDate(Date registeredDate) {
		this.registeredDate = registeredDate;
	}

	public String getTelePhone() {
		return telePhone;
	}

	public void setTelePhone(String telePhone) {
		this.telePhone = telePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}

	

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	
	
	
	
}
