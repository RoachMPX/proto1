/******************************************************************************
 *       Class: StudentRecords
 *
 * Programmer: Gary Ramli
 *
 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     11/1/2015   Part of Project 6
 * 
 * Class Description
 * -----------------
 * This class 
 *
 * ----------------------------- Public Interface -----------------------------
 *             Method                                 Description
 * -------------------------------   --------------------------------------------
 * StudentRecord()					 creates a specified class object           
 * compareLastName()     			 compares "Last Name" from two file objects	
 * compareFirstName()				 compares "First Name" from two file objects
 * compareID()						 compares "ID" from two file objects
 * compareAverage()					 compares "average" from two file objects
 * compareGrade()					 compares "Grade" from two file objects
 * toString()						 returns the String description of the class object
 * 
 * ------------------------- Private Data Members -----------------------------
 *               Data
 *    Type       Type      Name                    Description
 * ----------  --------  --------   --------------------------------------------
 * non-static  String    ln   		Student's Last Name
 * non-static  String    fn			Student's First Name
 * non-static  int       ID         Student's ID number
 * non-static  average   average    Student's average grade
 * non-static  grade     grade      Student's letter grade.
 *
 ******************************************************************************
 */
public class StudentRecords{
	
	//variables declared
	private String ln; 	    //Last Name
	private String fn;	    //First Name
	private int ID; 	    //ID
	private double average; //Average
	private String grade;   //Grade

	//Primary Constructor
	StudentRecords(String ln, String fn, int ID, double average, String grade){
		//tests to see if the ID number and average grades are valid
		if (ID <= 0  ||  average < 0.0  || average > 100.0){
			throw new IllegalArgumentException();
		}
		this.ln = ln;
		this.fn = fn;
		this.ID = ID;
		this.average = average;
		this.grade = grade;
	}

	//compareLastName(StudentRecord,StudentRecord)
	public static int compareLastName(StudentRecords record1, StudentRecords record2){
		return record1.ln.compareTo(record2.ln);
	}
	
	//compareFirstName(StudentRecord,StudentRecord)
	public static int compareFirstName(StudentRecords record1, StudentRecords record2){
		return record1.fn.compareTo(record2.fn);
	}
	
	//compareStudentId(StudentRecord,StudentRecord)
	public static int compareID(StudentRecords record1, StudentRecords record2){
		return record1.ID - record2.ID;
	}
	
	//compareStudentAverage(StudentRecord,StudentRecord)
	public static int compareAverage(StudentRecords record1, StudentRecords record2){
		return(int)(record1.average - record2.average);
	}
	
	//compareStudentGrade(StudentRecord,StudentRecord)
	public static int compareGrade(StudentRecords record1, StudentRecords record2){
		return record1.grade.compareTo(record2.grade);
	}
	
    //creates the string object (constructor) 
	public String toString(){
		String display = String.format("%-10s  %-10s  %06d  %7.2f  %3s", ln, fn, ID, average, grade);
		return display;
	}
	
}	
