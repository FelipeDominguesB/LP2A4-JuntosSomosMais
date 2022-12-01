package com.challenge.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import com.challenge.models.*;

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
				
	    		  
				insumo.gender = (String) jsonObj.get("gender");
				insumo.email = (String) jsonObj.get("email");
				insumo.name = new NameInfo((String) nameObj.get("title"), (String) nameObj.get("first"), (String) nameObj.get("last"));
				insumo.cellPhone = (String) jsonObj.get("cell");
				insumo.telePhone = (String) jsonObj.get("phone");
				insumo.pictureInfo = new PictureInfo((String) pictureObj.get("large"), (String) pictureObj.get("medium"), (String) pictureObj.get("thumbnail"));
				insumo.location = new Location((String) locationObj.get("street"), (String) locationObj.get("city"), (String) locationObj.get("state"), (Integer) locationObj.get("postcode"));
				insumo.location.coordinates = new Coordinates((String) coordinatesObj.get("latitude"), (String) coordinatesObj.get("longitude"));
				insumo.location.timezones = new Timezone((String) timezoneObj.get("offset"), (String) timezoneObj.get("offset"));
				
				DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
				DateTime dt = dtf.parseDateTime((String) dobObj.get("date"));
				insumo.dateOfBirth = new DateInfo(dt.toDate());
				
				dt = dtf.parseDateTime((String) registeredObj.get("date"));
				insumo.registeredDate = new DateInfo(dt.toDate());
		    	
				insumos.add(insumo);
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  return insumos;
	  }
	  
	
}
