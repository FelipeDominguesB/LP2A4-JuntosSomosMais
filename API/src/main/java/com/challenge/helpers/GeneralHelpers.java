package com.challenge.helpers;

import java.util.HashMap;
import java.util.Map;

import com.challenge.models.Coordinates;

public class GeneralHelpers {

	public static String GerarTipo(Coordinates coordinates)
	{
		String tipo = "Trabalhoso";
		if((-34.016466 <= coordinates.getLongitude() && coordinates.getLongitude() <= -26.155682) && (-54.777426 <= coordinates.getLatitude() &&  coordinates.getLatitude() <= -46.603598))
		{
			tipo = "Normal";
		}
		else if((-15.411580 <= coordinates.getLongitude() && coordinates.getLongitude() <= -2.196998) && (-46.361899 <= coordinates.getLatitude() &&  coordinates.getLatitude() <= -15.411580))
		{
			tipo = "Especial";
		}
		else if((-23.966413 <= coordinates.getLongitude() && coordinates.getLongitude() <= -19.766959) && (-52.997614 <= coordinates.getLatitude() &&  coordinates.getLatitude() <= -44.428305))
		{
			tipo = "Especial";
		}
			
		return tipo;
	}
	
	public static String GetRegiao(String estado)
	{
		
		Map<String, String> regiao = new HashMap<String, String>();
		regiao.put("acre","NORTE");
		regiao.put("alagoas","NORDESTE");
		regiao.put("amapá","NORTE");
		regiao.put("amazonas","NORTE");
		regiao.put("bahia","NORDESTE");
		regiao.put("ceará","NORDESTE");
		regiao.put("distrito federal","CENTRO-OESTE");
		regiao.put("espírito santo","SUDESTE");
		regiao.put("goiás","CENTRO-OESTE");
		regiao.put("maranhão","NORDESTE");
		regiao.put("mato grosso do sul","CENTRO-OESTE");
		regiao.put("mato grosso","CENTRO-OESTE");
		regiao.put("minas gerais","SUDESTE");
		regiao.put("pará","NORTE");
		regiao.put("paraíba","NORDESTE");
		regiao.put("paraná","SUL");
		
		regiao.put("pernambuco","NORDESTE");
		regiao.put("piauí","NORDESTE");
		regiao.put("rio de janeiro","SUDESTE");
		regiao.put("rio grande do norte","NORDESTE");
		regiao.put("rio grande do sul","SUL");
		regiao.put("rondônia","NORTE");
		regiao.put("roraima","NORTE");
		regiao.put("santa catarina","SUL");
		regiao.put("são paulo","SUDESTE");
		regiao.put("sergipe","NORDESTE");
		regiao.put("tocantins","NORTE");
		
		
		return regiao.get(estado);
	}
}
