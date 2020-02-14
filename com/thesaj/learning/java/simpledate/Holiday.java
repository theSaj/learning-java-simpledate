package com.thesaj.learning.java.simpledate;


//**************************************************************************************
/* AUTHOR NOTES: 
* Java implementation for the Simple Date + Holiday + Appointment exercise from "Intro to Java". 
* Intro to Java. Please note, that there are better ways to accomplish this objective.  
* 
* However, this was accomplished primarily using the basic techniques presented to that point in class.
* Initial base code provided by instructor.
* 
* - AUTHOR: Jason Epperson | jason.j.epperson
* - INSTRUCTOR: Dan Flanagan | d.flanagan@umbctraining.com
* - COURSE: Intro to Java @ UMBC Training
*/
//**************************************************************************************

//Class to extend Class.SimpleDate with the addition of a "Holiday" label. 
public class Holiday extends SimpleDate {

	//Variable to hold the new holiday label.
	private String holiday;
	
	//Constant for default when no label is provided.
	private static final String HOLIDAY_DEFAULT = "Holiday";

	//Update of SimpleDate constructors to add the holiday label.
	public Holiday(int m, int d, int y, String h) {
		//super(m, d, y);
		month = m;
        day = d;
        year = y;
        holiday = h;
	}
	
	public Holiday(int m, int d, int y) {
		super(m, d, y);
		holiday = HOLIDAY_DEFAULT;
	}

	public Holiday(int m, int d) {
		super(m, d);
		holiday = HOLIDAY_DEFAULT;
	}

	public Holiday(int d) {
		super(d);
		holiday = HOLIDAY_DEFAULT;
	}

	public Holiday() {
		super();
		holiday = HOLIDAY_DEFAULT;
	}

	public Holiday(String date) {
		super(date);
		holiday = HOLIDAY_DEFAULT;
	}
	
	//Update methods to include holiday label.
    public String getHoliday()  { return holiday;  }
    
    public String toString() {
        return  month + "/" + day + "/" + year + " is " + getHoliday();
    } 
    
    public String toJSON() {
        StringBuilder jsonStr = new StringBuilder();
        jsonStr.append("{");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
            jsonStr.append("\"month\": " + month + ",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
            jsonStr.append("\"day\": " + day + ",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
            jsonStr.append("\"year\": " + year + ",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"date\": \"" + getDate() + "\",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
            jsonStr.append("\"monthAsString\": \"" + monthAsString(month) + "\",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"dateLong\": \"" + getDateLong() + "\",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"dayOfYear\": " + dayOfYear(month,day,year) + ",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"daysLeftInYear\": " + daysLeftInYear(month,day,year) + ",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"leapYear\": " + isLeapYear(year) + ",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"holiday\": \"" + getHoliday() + "\"");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("}");
            
    	return  jsonStr.toString();
    }

}
