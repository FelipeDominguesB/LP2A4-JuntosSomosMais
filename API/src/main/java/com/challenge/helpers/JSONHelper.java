package com.challenge.helpers;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;

import com.challenge.models.Coordinates;
import com.challenge.models.Insumo;
import com.challenge.models.NameInfo;
import com.challenge.models.PictureInfo;
import com.challenge.models.Timezone;

public class JSONHelper {

	  public static List<Insumo> JSONToInsumo(InputStream is)
	  {
		  List<Insumo> insumos = new ArrayList<Insumo>();
		  try {
			
			String staticDataString = IOUtils.toString(is, StandardCharsets.UTF_8);
			
			JSONObject obj = new JSONObject(staticDataString);
			JSONArray jsonArray = (JSONArray) obj.get("results");
			
			for(int i = 0; i < jsonArray.length(); i++)
			{
				Insumo insumo = new Insumo();
				JSONObject jsonObj = jsonArray.getJSONObject(i);
				JSONObject nameObj = (JSONObject) jsonObj.get("name");
				JSONObject pictureObj = (JSONObject) jsonObj.get("picture");
				JSONObject locationObj = (JSONObject) jsonObj.get("location");
				JSONObject coordinatesObj = (JSONObject) locationObj.get("coordinates");
				JSONObject timezoneObj = (JSONObject) locationObj.get("timezone");
				JSONObject dobObj = (JSONObject) jsonObj.get("dob");
				JSONObject registeredObj = (JSONObject) jsonObj.get("registered");
				
	    		 
				insumo.setGender(((String) jsonObj.get("gender")).toUpperCase().charAt(0));
				insumo.setEmail((String) jsonObj.get("email"));
				insumo.setName(new NameInfo((String) nameObj.get("title"), (String) nameObj.get("first"), (String) nameObj.get("last")));
				insumo.setCellPhone((String) jsonObj.get("cell"));
				insumo.setTelePhone((String) jsonObj.get("phone"));
				insumo.setPictureInfo(new PictureInfo((String) pictureObj.get("large"), (String) pictureObj.get("medium"), (String) pictureObj.get("thumbnail")));
				insumo.getLocation().setCoordinates(new Coordinates((String) coordinatesObj.get("latitude"), (String) coordinatesObj.get("longitude")));
				insumo.getLocation().setTimezones(new Timezone((String) timezoneObj.get("offset"), (String) timezoneObj.get("offset")));
				insumo.setType(GeneralHelpers.GerarTipo(insumo.getLocation().getCoordinates()));
				insumo.setNationality("BR");
				
				DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
				DateTime dt = dtf.parseDateTime((String) dobObj.get("date"));
				insumo.setDateOfBirth(dt.toDate());
				
				dt = dtf.parseDateTime((String) registeredObj.get("date"));
				insumo.setRegisteredDate(dt.toDate());
		    	
				insumos.add(insumo);
				
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return insumos;
	  }
	  
	
}
