package com.challenge.models;

public class NameInfo {

	public NameInfo(String title, String first, String last)
	{
		this.title = title;
		this.first = first;
		this.last = last;
	}
	
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

	private String title;
	private String first;
	private String last;
}
