# SimpleDate Example

ABSTRACT: Java implementation for the Simple Date + Holiday + Appointment exercise from "Intro to Java".
   
- AUTHOR: Jason Epperson | jason.j.epperson
- INSTRUCTOR: Dan Flanagan | d.flanagan@umbctraining.com
- COURSE: Intro to Java @ UMBC Training



AUTHOR NOTES: Derived from an exercise from the Intro to Java course taught by Dan Flanagan at UMBC Training - February 2020. Java implementation for the Simple Date + Holiday + Appointment exercise from "Intro to Java".
Please note, that there are better ways to accomplish this objective. However, this was accomplished primarily using the basic techniques presented to that point in class. Initial base code provided by instructor. 

## Files

- README.md (the file you are viewing)
- SimpleDate.java
- Holiday.java (extends SimpleDate.java)
- Appointment.java (extends SimpleDate.java)
- SimpleDateTester.java (Java that runs examples of above classes)

## Utilizes

### SimpleDate

- packages, class, methods
- overloading 
- statics
- arrays
- string builder
- leap year calculation
- toString

### Holiday/Appointment
 
 - extending classes, (i.e. SimpleDate)
 - super
 - overriding
 - static final
  
### SimpelDateTester (used to rune examples of the above classes)
 
 - array of class objects
 - String.format, (used to pad output)
 - retrieving class name, (used to evaluate class object prior to invoking methods of extended classes)
 - Class.class.cast(), used to cast the array object to appropriate extended classes
 
 
## Closing thoughts?
 
I rather liked the idea of toString() standard, but felt that having the output be more portable data would be more beneficial. And so I implemented a "toJSON" method, I confess that Jason (me) may have some bias on this.
