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
	
	private static boolean DEBUG = false;
	
	
    public static void main(String args[]){
    	
    	//Declare class is run, and use String.format() to pad comment and String.replace() to replace spaces with astericks.
    	System.out.println("**** RUN SimpleDateTester " + String.format("%-72s","").replace(" ", "*")+"\n\n");
    	
        //Initialize list with SimpleDate data
        SimpleDate dates [] = populateDates();
        
        //Retrieve SimpleDate data and display for terminal. 
    	retrieveDateOutput(dates);
    	
    	//Retrieve SimpleDate data with standard Class.toString() output.
    	retrieveString(dates);
    	
    	//Retrieve SimpleDate data using custom coded method Class.toJSON() and present output as JSON objects.
    	retrieveJSON(dates);
    	
    }
    
    private static SimpleDate[] populateDates(){
    	
    	//Creates an array of SimpleDate objects, including Holidays and Appointments - which extend SimpleDate.
    	SimpleDate dateList [] = {
    			    new SimpleDate(2, 3, 2008),   //DayOfYear:34   DaysLeft:332
    			    new SimpleDate(2, 3, 2011),   //DayOfYear:34   DaysLeft:331
    			    new SimpleDate(3, 2, 2008),   //DayOfYear:62   DaysLeft:304
    			    new SimpleDate(9, 2, 2011),   //DayOfYear:61   DaysLeft:304
    			    new SimpleDate(12, 30, 2008), //DayOfYear:365  DaysLeft:1
    			    new Holiday(12, 25, 2011), //Holiday: Christmas - UNDEFINED
    			    new Holiday(7, 4, 2020,"4th of July"), //Holiday: Independence Day
    			    new Appointment(7, 4, 2020), //Appointment: Undefined
    			    new Appointment(2, 13, 2020,"UMBC Training Center","Jason,Tania,Joe"),//Appointment: SimpleDate+Details
    			    new Appointment(2, 14, 2020,"UMBC Training Center","Jason,Tania,Joe"),//Appointment: SimpleDate+Details
    			    new Holiday(2, 17, 2020,"President's Day"), //Holiday: President's Day
    			    new Appointment(2, 24, 2020,"System Source","Jason,Tania,Krupali"), //Appointment: SimpleDate+Details
    			    new SimpleDate(13, 30, 2008), //Error Handling: Bad Date    			    
    	        };
    	 
    	return dateList;
    }
    
    private static void retrieveDateOutput(SimpleDate[] dates){
    	
    	//Construct a StringBuilder to collate output content.
    	StringBuilder outputString = new StringBuilder();
    	
    	//Populate StringBuilder via StringBuilder.append() method.
        outputString.append("**** Output formatted date data. " + String.format("%-65s","").replace(" ", "*"));
        outputString.append(System.getProperty("line.separator"));
        outputString.append("|"+String.format("%97s","|").replace(" ", "-"));
        outputString.append(System.getProperty("line.separator"));
        outputString.append("| DATE       | MONTH     | DAY# | DAYS LEFT | SPECIAL INFORMATION                                |");
        outputString.append(System.getProperty("line.separator"));
        outputString.append("|"+String.format("%97s","|").replace(" ", "-"));
        outputString.append(System.getProperty("line.separator"));
        
        //For array dates of SimpleDate[], iterate. 
    	for(int i = 0; i < dates.length; i++){
    		
        	try{
        		//NOTE: padString is custom private method to simply String.format calls.
        		outputString.append("| " + padString(String.format("%10s",dates[i].getDate()),11));
	        	outputString.append(padString("| " + dates[i].getMonthAsString(),12));
	        	outputString.append(padString("| " + dates[i].getDayOfYear(),7));
	        	outputString.append(padString("| " + dates[i].getDaysLeftInYear(),12) + "|");
	        	
	        	String tmpStr = "";
	        	
	        	//Output if year isLeapYear.
	        	if(dates[i].isLeapYear()== true){
	        		tmpStr = "Leap Year";
	            }
	        	
	        	/*Handle Class Holiday by inquiring of array "dates" of SimpleDate[], and asking if object at
	        	 *  array index has a class name of "Holiday", if so, cast the SimpleDate object to a Holiday object
	        	 *  in order to access extended class methods.
	        	 */
	        	if(dates[i].getClass().getName().equals("mywork.collections.ex2.Holiday")){
	        		
	        		Holiday holiday = Holiday.class.cast(dates[i]);
	            	
	        		//IF data exists in SPECIAL column (namely, "Leap Year"), insert a comma before appending string.
	        		if(tmpStr.length() > 0){
	            		tmpStr = tmpStr + ", ";
	            	}
	            	tmpStr = tmpStr + holiday.getHoliday();
	        	}
	        	
	        	outputString.append(String.format("%-51s",tmpStr) + " |" + System.getProperty("line.separator"));
	        	
	        	/*Handle Class Appointment by inquiring of array "dates" of SimpleDate[], and asking if object at
	        	 *  array index has a class name of "Holiday", if so, cast the SimpleDate object to a Appointment object
	        	 *  in order to access extended class methods.
	        	 */
	        	if(dates[i].getClass().getName().equals("mywork.collections.ex2.Appointment")){
	        		Appointment appointment = Appointment.class.cast(dates[i]);
	            	tmpStr = "|"+String.format("%-7s","") + "^^^^ | Has appointment @Location:" + appointment.getLocation() + ", w/attendees: " + appointment.getAttendees();
	            	outputString.append(tmpStr + System.getProperty("line.separator"));
	            	outputString.append(String.format("%" + (98-tmpStr.length()) + "s","|") + System.getProperty("line.separator"));
	            	outputString.append("|"+String.format("%97s","|").replace(" ", "-") + System.getProperty("line.separator"));
	        	}
	        	
        	}
            catch(Exception e){
            	//Handle Exception error with notification. 
            	outputString.append(" >> ERROR OCCURRED <<");
            	outputString.append(System.getProperty("line.separator"));
            	
            	//IF DEBUG boolean is on, show detailed error message.
            	if(DEBUG == true){
        			System.out.println(e);
        		}
            }
            finally{
            }
        }
    	
    	outputString.append("|"+String.format("%97s","EOF|").replace(" ", "_") + System.getProperty("line.separator"));
    	outputString.append("**** \"SimpleDate\" output complete! " + String.format("%-63s","").replace(" ", "*"));
    	
    	//Write StringBuilder output to console. 
    	System.out.println(outputString.toString()+"\n\n");
    	
    }
    
    private static void retrieveString(SimpleDate[] dates){
    	
    	StringBuilder outputString = new StringBuilder();
    	outputString.append("**** Outputs the toString methods. " + String.format("%-63s","").replace(" ", "*")+ System.getProperty("line.separator"));
        
    	try{
	    	
    		for(int i = 0; i < dates.length; i++){
    			//Utilizes the commonly incorporated Class.toString() method.
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
    		
    	}
    	outputString.append("**** Output toString data complete. " + String.format("%-63s","").replace(" ", "*"));
        outputString.append(System.getProperty("line.separator")+System.getProperty("line.separator"));
        System.out.println(outputString);
    	
    }
    
    private static void retrieveJSON(SimpleDate[] dates){
    	
    	StringBuilder outputString = new StringBuilder();
    	outputString.append("**** Outputs JSON data. " + String.format("%-74s","").replace(" ", "*")+System.getProperty("line.separator"));
    	
    	try{
    		
            for(int i = 0; i < dates.length; i++){
            	outputString.append(dates[i].toJSON()+System.getProperty("line.separator"));
            }
            
    	}
    	catch(Exception e){
    		System.out.print("ERROR (toJSON): Please review input");
    		
    		/*Convert the error message to an array of words via split in order to later attempt 
    		 * extraction of the Index provided in the Exception error message.   		 */
    		String[] tmpStr = e.getMessage().split(" ");
    		
    		//Attempt to retrieve the SimpleDate.date() value of the object that caused an error.
    		try{				
    			System.out.print(", " + dates[Integer.parseInt(tmpStr[1])].getDate() + ".");
			}
			catch(Exception e2){} 
    		finally{}
    		
    		if(DEBUG == true){
    			System.out.println(e);
       		}
    	}
    	finally{
    		System.out.println("");
    	}
    	
    	outputString.append("**** Output of JSON data complete. " + String.format("%-74s","").replace(" ", "*"));
        outputString.append(System.getProperty("line.separator"));
        System.out.println(outputString);
    }
    
    //Method to simplify padding. Intend to extend to take an optional Left(L)/Right(R) parameter.
    private static String padString(String txt2pad, int length) {
		return String.format("%-" + length + "s", txt2pad);
	}
}
