package com.challenge.models;

import java.util.Calendar;
import java.util.Date;

public class DateInfo {

	public DateInfo(Date date)
	{
		this.date = date;
		Calendar present = Calendar.getInstance();
	    Calendar now = Calendar.getInstance();
	    now.setTime(date);
		this.age = getAge(now, present);
	}
	
	private int getAge(Calendar first, Calendar second)
	{
		int years = 0;
		
		while(first.before(second))
		{
			first.add(Calendar.YEAR, 1);
			if(first.before(second)) years++;
		}
		
		return years;
	}
	
	public Date date;
	public int age;
}
