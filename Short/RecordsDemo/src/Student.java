/******************************************************************************
* Bellevue Class: CS-211
*           Term: Fall 2015
*     Instructor: Robert Main
*     
* Textbook: Building Java Programs, A Back to Basics Approach
*  Edition: 3rd
*  Authors: Stuart Reges and Marty Stepp
*  
* Assigned Project: 6
*
* Class Name: Student
*  File Name: Student.java
*
* Programmer: Gary Ramli
*
* Revision     Date                        Release Comment
* --------  ----------  ------------------------------------------------------
*   1.0     11/01/2015  Part of Project 6 - Main Method (client)
*
* File Description
* ----------------
* This class runs all the other classes and calls to print the sorted as well as
* the record before it is sorted
*
* User Defined Types (UDTs) Utilized
* ----------------------------------
*      Name                               Description
* --------------  -------------------------------------------------------------
*	   N/A							          N/A
* 
* Program Inputs
* --------------
*  Device                            Description
* --------  -------------------------------------------------------------------
* Keyboard  List program inputs
* Mouse		Organizes and point-click to things in class
* 
* Program Outputs
* ---------------
*  Device                            Description
* --------  ------------------------------------------------------------------
* Monitor   outputs the records
* 
* Class Methods
* -------------
*       Name                                    Description
* ------------------  ----------------------------------------------------------------
* main(String[]args)  Program produces output of after numerous sorting according to 
*                     different categories
* 
******************************************************************************
*/
import java.io.*;
import java.util.*;

public class Student{
	//record written
	private static final String Student_Records = "StudentRecords.txt";
	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Method Description
	 * ------------------
	 * This method calls on to the other methods
	 * 
	 * Pre-Conditions
	 * --------------
	 * N/A
	 * 
	 * ------------------------------- Arguments ------------------------------
	 *   Type           Name                         Description
	 * ------------ ------------  ------------------------------------------------
	 * String[]args     N/A		  Array of "string" argument passed to main method
	 *                       	  when the program runs
	 *
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 *  N/A							     	N/A
	 *
	 * Invoked Methods
	 * ---------------
	 *         Name                              Description
	 * --------------------     --------------------------------------------------
	 * buildStudenRecordsList	Creates the students records ArrayList from the appropriate text file
	 * display				Displays the ArrayList of objects from Student Record                        
	 **************************************************************************                         
	 */
	public static void main(String[] args) throws FileNotFoundException{
		
		//ArrayList created
        ArrayList<StudentRecords> list = new ArrayList<StudentRecords>();      
        if (Records(list, Student_Records)){        
        	
        	//display the list by the order that the student records were added
        	System.out.println("Student Records, as read from the database file:");
        	display(list); 
        	
        	//sorts and prints the list by student's last name
        	Collections.sort(list, new CompareLast()); 
        	System.out.println("\nStudent Records, after sorting by last name:");
        	display(list); 
        
        	//sorts and prints the list by student's first name
        	Collections.sort(list, new CompareFirst());
        	System.out.println("\nStudent Records, after sorting by first name:");
        	display(list); 
        	
        	//sorts and prints the list by student's ID
        	Collections.sort(list, new CompareID());
        	System.out.println("\nStudent Records, after sorting by student ID:");
        	display(list); 
        	
        	//sorts and prints the list by student's average
        	Collections.sort(list, new CompareAverage());
        	System.out.println("\nStudent Records, after sorting by average:");
        	display(list); 
        	
        	//sorts and prints the list by student's grade
        	Collections.sort(list, new CompareGrade());
        	System.out.println("\nStudent Records, after sorting by letter grade:");
        	display(list); 
        }
	}  
		
	/**************************************************************************
	 * Method: Records(List<StudentRecord>,String)
	 * 
	 * Method Description
	 * ------------------
	 * This method reads StudentRecords from the specified file name and
	 * adds them in the file to the ArrayList list of StudentRecord objects.
	 * 
	 * 
	 *  RETurn
	 *   Type                            Description
	 * --------        -------------------------------------------------------
	 * boolean         returns true if file is found, otherwise returns false
	 *
	 * ------------------------------- Arguments ------------------------------
	 *        Type            Name                         Description
	 * -------------------  --------  -----------------------------------------
	 * List<StudentRecord>  rec       ArrayList of StudentRecords.java objects
	 * String               fileName  File name of StudentRecords.java
	 * Boolean				a		  verifies if file exists
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
	private static boolean Records(List<StudentRecords> rec, String fileName)
			throws FileNotFoundException{
		
		//create file object of StudentRecords.java
        File file = new File(Student_Records);
        boolean a;
        a = file.exists(); 
        
        //tests to see if the file exist
        if(a == true){            
        	String ln;		//Last Name
        	String fn;		//First Name
        	String grade;	//Grade
        	int ID;			//ID
        	double average;	//Average
        	
        	//creates scanner
        	Scanner console = new Scanner(file);
        	//checks if the scanner object has a String 
        	while(console.hasNextLine() ){
        		String record = console.nextLine();
        		Scanner list2 = new Scanner(record); 
        		
        			ln = list2.next();
        			fn = list2.next();
        			ID = list2.nextInt();
        			average = list2.nextDouble();
        			grade  = list2.next();
        		
        		rec.add(new StudentRecords(ln, fn, ID, average, grade) );
        		
        		list2.close();
        	}
        	console.close();
        }
		return a;
	}   
	
	
	/**************************************************************************
	 * Method: display(List<StudentRecord>)
	 * 
	 * Method Description
	 * ------------------
	 * Display the ArrayList of StudentRecords.java's objects
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * N/A
	 *
	 * ------------------------------- Arguments ------------------------------
	 *        Type            Name                         Description
	 * -------------------  --------  -----------------------------------------
	 * List<StudentRecord>  list      ArrayList of StudentRecords.java objects
	 * 
	 * Invoked Methods
	 * ---------------
	 * N/A
	 *
	 **************************************************************************
	 */
	private static void display(List<StudentRecords> list){
		//prints out the list
		System.out.println("Last Name   First Name    ID    Average  Grade" +
						 "\n----------  ----------  ------  -------  -----");
        for (StudentRecords record : list){
        	System.out.println(record);
        }
	}   
}  
