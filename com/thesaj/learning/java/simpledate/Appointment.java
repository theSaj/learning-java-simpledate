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

//Class to extend Class.SimpleDate with the addition of a "location" and "attendees" labels. 
public class Appointment extends SimpleDate {

	//Variables to hold the new location and attendees labels.
	private String location;
	private String attendees;
	
	//Constant defaults when no labels are provided.
	private static final String LOCATION_DEFAULT = "UNDEFINED";
	private static final String ATTENDEES_DEFAULT = "UNDEFINED";

	//Update of SimpleDate constructors to add the location and attendees labels.
	public Appointment(int m, int d, int y, String l, String a) {
		//super(m, d, y);
		month = m;
        day = d;
        year = y;
        location = l;
        attendees = a;
	}
	
	public Appointment(int m, int d, int y) {
		super(m, d, y);
		location = LOCATION_DEFAULT;
		attendees = ATTENDEES_DEFAULT;
	}

	public Appointment(int m, int d) {
		super(m, d);
		location = LOCATION_DEFAULT;
		attendees = ATTENDEES_DEFAULT;
	}

	public Appointment(int d) {
		super(d);
		location = LOCATION_DEFAULT;
		attendees = ATTENDEES_DEFAULT;
	}

	public Appointment() {
		super();
		location = LOCATION_DEFAULT;
		attendees = ATTENDEES_DEFAULT;
	}

	public Appointment(String date) {
		super(date);
		location = LOCATION_DEFAULT;
		attendees = ATTENDEES_DEFAULT;
	}
	
	//Update methods to include location and attendees labels.
    public String getLocation()  { return location;  }
    
    public String getAttendees()  { return attendees;  }
    
    public String toString() {
        return  getDate() + " has an appointment at " + getLocation() + " with " + getAttendees();
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
        //Class.toJSON() modified to contain a sub-object for appointments. "appointment": {"location": "UNDEFINED", "attendees": "UNDEFINED"}
        jsonStr.append("\t");
        	jsonStr.append("\"appointment\": {");jsonStr.append(System.getProperty("line.separator"));
        	jsonStr.append("\t");jsonStr.append("\t");
        	jsonStr.append("\"location\": \"" + getLocation() + "\",");jsonStr.append(System.getProperty("line.separator"));
        	jsonStr.append("\t");jsonStr.append("\t");
        	jsonStr.append("\"attendees\": \"" + getAttendees() + "\"");jsonStr.append(System.getProperty("line.separator"));
        	jsonStr.append("\t");
        	jsonStr.append("}");
        	jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("}");
            
    	return  jsonStr.toString();
    }

}
