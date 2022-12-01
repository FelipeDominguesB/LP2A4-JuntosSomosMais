package com.challenge.helpers;

import com.challenge.models.Coordinates;

public class GeneralHelpers {

	public static String GerarTipo(Coordinates coordinates)
	{
		String tipo = "Trabalhoso";
		if((-34.016466 <= coordinates.longitude && coordinates.longitude <= -26.155682) && (-54.777426 <= coordinates.latitude &&  coordinates.latitude <= -46.603598))
		{
			tipo = "Normal";
		}
		else if((-15.411580 <= coordinates.longitude && coordinates.longitude <= -2.196998) && (-46.361899 <= coordinates.latitude &&  coordinates.latitude <= -15.411580))
		{
			tipo = "Especial";
		}
		else if((-23.966413 <= coordinates.longitude && coordinates.longitude <= -19.766959) && (-52.997614 <= coordinates.latitude &&  coordinates.latitude <= -44.428305))
		{
			tipo = "Especial";
		}
			
		return tipo;
	}
}
