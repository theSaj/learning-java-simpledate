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

public class SimpleDateTester{
	
	private static boolean DEBUG = true;
	
	
    public static void main(String args[]){
    	
        //Initialize list with SimpleDate data
        SimpleDate dates [] = populateDates();
        
    	//retrieveDateOutput(dates);
    	
    	//retrieveString(dates);
    	
    	retrieveJSON(dates);
    	

    	
    }
    
    private static SimpleDate[] populateDates(){
    	 
    	SimpleDate dateList [] = {
    			    new SimpleDate(2, 3, 2008),   //DayOfYear:34   DaysLeft:332
//    			    new SimpleDate(2, 3, 2011),   //DayOfYear:34   DaysLeft:331
//    			    new SimpleDate(3, 2, 2008),   //DayOfYear:62   DaysLeft:304
//    			    new SimpleDate(9, 2, 2011),   //DayOfYear:61   DaysLeft:304
//    			    new SimpleDate(12, 30, 2008), //DayOfYear:365  DaysLeft:1
//    			    new Holiday(12, 30, 2011), //DayOfYear:364  DaysLeft:1
//    			    new Holiday(7, 4, 2020,"4th of July"), //DayOfYear:364  DaysLeft:1
//    			    new Appointment(7, 4, 2020), //DayOfYear:364  DaysLeft:1
//    			    new Appointment(2, 13, 2020,"UMBC Training Center","Jason,Tania,Joe"),
//    			    new Appointment(2, 14, 2020,"UMBC Training Center","Jason,Tania,Joe"),
//    			    new Holiday(2, 17, 2020,"President's Day"), //DayOfYear:364  DaysLeft:1
    			    //new Appointment(2, 24, 2020,"System Source","Jason,Tania,Krupali"), //DayOfYear:364  DaysLeft:1
    			    new SimpleDate(13, 30, 2008), //Bad Date:1
    			    
    	        };
    	 
    	return dateList;
    }
    
    private static void retrieveDateOutput(SimpleDate[] dates){
    	
    	StringBuilder outputString = new StringBuilder();
    	
        outputString.append(System.getProperty("line.separator"));
        outputString.append("**** Output formatted date data. " + String.format("%-65s","").replace(" ", "*"));
        outputString.append(System.getProperty("line.separator"));
        outputString.append("|"+String.format("%97s","|").replace(" ", "-"));
        outputString.append(System.getProperty("line.separator"));
        outputString.append("| DATE       | MONTH     | DAY# | DAYS LEFT | SPECIAL INFORMATION                                |");
        outputString.append(System.getProperty("line.separator"));
        outputString.append("|"+String.format("%97s","|").replace(" ", "-"));
        outputString.append(System.getProperty("line.separator"));
        
    	for(int i = 0; i < dates.length; i++){
        	try{
	        	
        		outputString.append("| " + padString(String.format("%10s",dates[i].getDate()),11));
	        	outputString.append(padString("| " + dates[i].getMonthAsString(),12));
	        	outputString.append(padString("| " + dates[i].getDayOfYear(),7));
	        	outputString.append(padString("| " + dates[i].getDaysLeftInYear(),12) + "|");
	        	String tmpStr = "";
	        	if(dates[i].isLeapYear()== true){
	        		tmpStr = "Leap Year";
	            }
	        	if(dates[i].getClass().getName().equals("mywork.collections.ex2.Holiday")){
	        		Holiday holiday = Holiday.class.cast(dates[i]);
	            	if(tmpStr.length() > 0){
	            		tmpStr = tmpStr + ", ";
	            	}
	            	tmpStr = tmpStr + holiday.getHoliday();
	        	}
	        	outputString.append(String.format("%-51s",tmpStr) + " |" + System.getProperty("line.separator"));
	        	if(dates[i].getClass().getName().equals("mywork.collections.ex2.Appointment")){
	        		Appointment appointment = Appointment.class.cast(dates[i]);
	            	tmpStr = "|"+String.format("%-7s","") + "^^^^ | Has appointment @Location:" + appointment.getLocation() + ", w/attendees: " + appointment.getAttendees();
	            	outputString.append(tmpStr + System.getProperty("line.separator"));
	            	outputString.append(String.format("%" + (98-tmpStr.length()) + "s","|") + System.getProperty("line.separator"));
	            	outputString.append("|"+String.format("%97s","|").replace(" ", "-") + System.getProperty("line.separator"));
	        	}
	        	
        	}
            catch(Exception e){            	
            	outputString.append(" >> ERROR OCCURRED <<");
            	outputString.append(System.getProperty("line.separator"));
            	if(DEBUG == true){
        			System.out.println(e);
        		}
            }
            finally{
            	System.out.println("\"SimpleDate\" output complete!");
    	        outputString.append(System.getProperty("line.separator"));
            }
        }

    	outputString.append("|"+String.format("%97s","EOF|").replace(" ", "_") + System.getProperty("line.separator"));
    	System.out.println(outputString.toString());
    }
    
    private static void retrieveString(SimpleDate[] dates){
    	
    	StringBuilder outputString = new StringBuilder();
    	
    	try{
	    	
    		outputString.append("**** Outputs the toString methods. " + String.format("%-63s","").replace(" ", "*"));
	        for(int i = 0; i < dates.length; i++){
	        	outputString.append(dates[i].toString() + System.getProperty("line.separator"));
	        }
	        
	        
    	}
    	catch(Exception e){
    		System.out.println("ERROR (toString): Please review input.");
    		if(DEBUG == true){
    			System.out.println(e);
    		}
    	}
    	finally{
    		outputString.append("**** Output toString data complete. " + String.format("%-74s","").replace(" ", "*"));
	        outputString.append(System.getProperty("line.separator"));
	        System.out.println(outputString);
    	}
    	
    }
    
    private static void retrieveJSON(SimpleDate[] dates){
    	
    	StringBuilder outputString = new StringBuilder();
    	outputString.append("**** Outputs JSON data. " + String.format("%-74s","").replace(" ", "*"));
    	
    	try{
    		
            for(int i = 0; i < dates.length; i++){
            	outputString.append(dates[i].toJSON()+System.getProperty("line.separator"));
            }
            
    	}
    	catch(Exception e){
    		System.out.println("ERROR (toJSON): Please review input - .");
    		if(DEBUG == true){
    			System.out.println(e.getMessage());
    		}
    	}
    	finally{
    		outputString.append("**** Output of JSON data complete. " + String.format("%-74s","").replace(" ", "*"));
	        outputString.append(System.getProperty("line.separator"));
	        System.out.println(outputString);
    	}
    	
    }
    
    private static String padString(String txt2pad, int length) {
		return String.format("%-" + length + "s", txt2pad);
	}
}
