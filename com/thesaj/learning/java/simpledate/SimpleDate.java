package com.thesaj.learning.java.simpledate;
import java.util.Date;
import java.util.StringTokenizer;

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

public class SimpleDate {

	int month, day, year;
	
	private static int months[] = {31,28,31,30,31,30,31,31,30,31,30,31};
	private static String monthsByName[] = {"January", "February", "March","April","May","June","July","August","September","October","November","December"};
	
	private boolean isLeapYear;

    // BEGIN: Constructors *********************************************************
    
	//Standard constructor
	public SimpleDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

	//Alternate constructor, no "year". 
    public SimpleDate(int m, int d) {
        month = m;
        day = d;

        // need to utilize Sun's Date class to obtain
        // current year but we will store it as a 4 digit year
        Date now  = new Date();
        year = now.getYear() + 1900;
    }

    //Alternate constructor, no "month" or "year". 
    public SimpleDate(int d) {
        day = d;

        // need to utilize Sun's Date class to obtain
        // current year but we will store it as a 4 digit year
        // and current month but we will store Jan as 1 not 0
        Date now = new Date();
        year = now.getYear() + 1900;
        month = now.getMonth() + 1;
    }

    //Alternate constructor, no parameters. 
    public SimpleDate() {
        // need to utilize Sun's Date class to obtain
        // current year but we will store it as a 4 digit year
        // and current month but we will store Jan as 1 not 0
        // and day of month that we will store as-is

        Date now = new Date();
        year = now.getYear() + 1900;
        month = now.getMonth() + 1;
        day = now.getDate();
    }

    //Alternate constructor, single parameter sent in "m/d/yyyy" date format. 
    public SimpleDate(String date) {
        StringTokenizer st = new StringTokenizer(date, "/");
        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());
        year = Integer.parseInt(st.nextToken());
    }
    
 // END: Constructors *********************************************************
    


    //methods
    public int getDay()   { return day; }
    public int getMonth() { return month; }
    public int getYear()  { return year;  }
    
    //Public methods to invoke private methods and values.
    public String getMonthAsString()  { return monthAsString(month);}
    public int getDayOfYear(){return dayOfYear(month,day,year);}
    public int getDaysLeftInYear(){return daysLeftInYear(month,day,year);}
    public boolean isLeapYear(){return isLeapYear(year);}

    public String getDate()  { return date(month,day,year);}
    public String getDateLong()  { return getMonthAsString() + " " + day + ", " + year;}
    
    public void setDay(int d)   { day = d; }
    public void setMonth(int m) { month = m; }
    public void setYear(int y)  { year = y; }

    //Define standard Class.toString() method.
    public String toString() {
        return  month + "/" + day + "/" + year;
    }
    
    //Method to provide the results as a JSON object. 
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
        	jsonStr.append("\"date\": \"" + month + "/" + day + "/" + year + "\",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
            jsonStr.append("\"monthAsString\": \"" + monthAsString(month) + "\",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"dateLong\": \"" + monthAsString(month) + " " + day + ", " + year + "\",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"dayOfYear\": " + dayOfYear(month,day,year) + ",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"daysLeftInYear\": " + daysLeftInYear(month,day,year) + ",");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("\t");
        	jsonStr.append("\"leapYear\": " + isLeapYear(year) + "");jsonStr.append(System.getProperty("line.separator"));
        jsonStr.append("}");
            
    	return  jsonStr.toString();
    }
    
    protected String date(int month, int day, int year){    	
    	return Integer.toString(month) + "/" + Integer.toString(day) + "/" + Integer.toString(year);    	
    }
    
    protected String monthAsString(int month){    	
    	return monthsByName[month-1];    	
    }
    
    //Simple calculation for determining if value is a leap year. 
    protected boolean isLeapYear(int year){
    	boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    	return isLeapYear;
    }
    
    protected int dayOfYear(int month, int d, int year){
    	
    	int dayOfYear = 0;
    	
    	for(int i = 0; i < month-1; i++){
    		dayOfYear = dayOfYear + months[i];
    	}
    	
    	dayOfYear = (dayOfYear + d);
    	
    	
    	if(isLeapYear(year)){
    		dayOfYear = (dayOfYear + 1);
    	}
    	
    	return dayOfYear;
    }
    
    protected int daysLeftInYear(int month, int d, int year){
    	
		int daysInYear = 365;
    	if(isLeapYear(year)){    		
    		daysInYear = 366;
    	}
    	
    	int daysLeftInYear = daysInYear - dayOfYear(month,d,year);
    	
    	return daysLeftInYear;
    }
    
}