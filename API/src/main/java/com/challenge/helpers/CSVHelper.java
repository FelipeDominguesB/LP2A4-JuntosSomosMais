package com.challenge.helpers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.web.multipart.MultipartFile;

import com.challenge.models.*;

public class CSVHelper {
	public static String TYPE = "text/csv";
	  static String[] HEADERs = { "Id", "Title", "Description", "Published" };

	  public static boolean hasCSVFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }
	  
	  public static List<Insumo> csvToInsumo(InputStream is)
	  {
		  try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
			   CSVParser csvParser = new CSVParser(fileReader,
			   CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {

			      List<Insumo> insumos = new ArrayList<Insumo>();

			      Iterable<CSVRecord> csvRecords = csvParser.getRecords();

			      for (CSVRecord csvRecord : csvRecords) {
			    	  
			    	  try {
			    		  Insumo insumo = new Insumo();
			    		  
				    	  insumo.setGender(csvRecord.get(0).toUpperCase().charAt(0));
				    	  insumo.setEmail(csvRecord.get("email"));
				    	  insumo.setName(new NameInfo(csvRecord.get("name__title"), csvRecord.get("name__first"), csvRecord.get("name__last")));
				    	  insumo.setPictureInfo(new PictureInfo(csvRecord.get("picture__large"),csvRecord.get("picture__medium"),csvRecord.get("picture__thumbnail")));
				    	  insumo.setCellPhone(csvRecord.get("cell"));
				    	  insumo.setTelePhone(csvRecord.get("phone"));
				    	  insumo.setLocation(new Location(csvRecord.get("location__street"), csvRecord.get("location__city"), csvRecord.get("location__state"), Integer.parseInt(csvRecord.get("location__postcode"))));
				    	  insumo.getLocation().setCoordinates(new Coordinates(csvRecord.get("location__coordinates__latitude"), csvRecord.get("location__coordinates__longitude")));
				    	  insumo.getLocation().setTimezones(new Timezone(csvRecord.get("location__timezone__offset"), csvRecord.get("location__timezone__description")));
				    	  
				    	  insumo.setType(GeneralHelpers.GerarTipo(new Coordinates(csvRecord.get("location__coordinates__latitude"), csvRecord.get("location__coordinates__longitude"))));
				    	  insumo.setNationality("BR");
				    	  
				    	  DateTimeFormatter dtf = DateTimeFormat.forPattern("yyyy-MM-dd'T'HH:mm:ss'Z'");
				    	  DateTime dt = dtf.parseDateTime(csvRecord.get("dob__date"));
				    	  insumo.setDateOfBirth(dt.toDate());
				    	  
				    	  dt = dtf.parseDateTime(csvRecord.get("registered__date"));
				    	  insumo.setRegisteredDate(dt.toDate());
				    	  
				    	  
				    	  insumos.add(insumo);
			    	  }
			    	  catch (Exception e){
			    		  System.out.println(e.getMessage());
			    	  }
			    	  
			      }

			      return insumos;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse CSV file: " + e.getMessage());
	    }
	  }
	  
	
}
