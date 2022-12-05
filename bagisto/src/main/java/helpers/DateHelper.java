package helpers;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateHelper {

	public static void main(String[] args) {
		System.out.println(getDate("TODAY"));
	}
	
	public static  String getDate(String rquestType) {		
		Calendar calendar = Calendar.getInstance();  // get a calendar instance, which defaults to "now"	   	
		 Date gettype = calendar.getTime();
		 
		if(rquestType=="AFTER_DATE") {
			calendar.add(Calendar.DAY_OF_YEAR, 5);
			 gettype = calendar.getTime();
		}
		
		return  new SimpleDateFormat("d").format(gettype);	   
	}

}
