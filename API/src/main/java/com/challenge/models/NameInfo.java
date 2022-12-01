package com.challenge.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity(name = "NameInfo")
@Table(name = "nameInfo")
public class NameInfo {

	public NameInfo() {}
	
	public NameInfo(String title, String first, String last)
	{
		this.title = title;
		this.first = first;
		this.last = last;
	}
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id")
	private Long id;
	
	@Column(name = "title")
	private String title;
	@Column(name = "first")
	private String first;
	@Column(name = "last")
	private String last;

	@OneToOne(mappedBy = "name")
	private Insumo insumo;
	

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getLast() {
		return last;
	}
	public void setLast(String last) {
		this.last = last;
	}

	
}
