package com.challenge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Picture")
public class PictureInfo {
	
	public PictureInfo() {}

	public PictureInfo(String large, String medium, String thumbnail)
	{
		this.large = large;
		this.medium = medium;
		this.thumbnail = thumbnail;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	@Column(name ="large")
	private String large;
	
	@Column(name ="medium")
	private String medium;
	
	@Column(name ="thumbnail")
	private String thumbnail;
	
	@OneToOne(mappedBy = "pictureInfo")
	private Insumo insumo;
	
	public String getLarge() {
		return large;
	}
	public void setLarge(String large) {
		this.large = large;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	
	
	
}
