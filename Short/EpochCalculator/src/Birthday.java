/*******************************************************************************
 * Bellevue Class: CS 211
 *           Term: Spring 2014
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach, 2nd Edition
 *  Authors: Stuart Reges and Marty Stepp
 * Exercise: 2
 *     Page: 571
 *
 * Project Client Program
 * Assigned Project: 1
 *
 * Class Name: Birthday
 * File Name:  Birthday.java
 *
 * Revision     Date                        Release Comment
 * --------  ----------  -------------------------------------------------------
 *   1.0     04/05/2013  Initial Release
 *   1.1     04/16/2014  1. Made copies of "Date" objects modified in methods
 *                          "daysTillBirthday" and "daysOld"
 *                       2. Added support to use Java, overridden "clone()"
 *                          method in class "Date".
 *
 * File Description
 * ----------------
 * This file defines the the class "Birthday", which includes all methods,
 * variables, and constant values. Specifically, this class contains the
 * Console application entry method, main(), which is a static method, since
 * no object of the class type is ever instantiated.
 * 
 * Class Methods
 * -------------
 *    Name                                    Description
 * ----------------  -----------------------------------------------------------
 * main              OS transfers control to this method upon program execution
 * getDate           Solicits a date from User, RETurns a reference to Date obj.
 * statistics        Displays the statistics for a given Date object
 * daysTillBirthday  Computes days from one Date to next Date in the same year
 * daysOld           Computes days from a previous Date to a future Date
 *
 *******************************************************************************
 */
// Imported Java Package
import java.util.*;

public class Birthday
{
	/*****************************************************************************
	 * Method: main(String[])
	 * 
	 * Program Description
	 * -------------------
	 * This program solicits the (User's) birth date and today's date from the
	 * User and then displays the statistics of the birth date, which includes:
	 *   1. Day of the week of birth
	 *   2. If the year of birth was a leap year
	 *   3. The age of the User, in years, if "today" is his/her birthday
	 *   4. The number of days until the User's next birthday
	 *   5. The age of the User, in days
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ---------------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ---------------------------------------------------
	 * String[]  args          Array of "string" argument(s) passed to main()
	 *                         when the Console program is invoked by the User.
	 * 
	 * Invoked Methods
	 * ---------------
	 *    Name                              Description
	 * ----------------  ---------------------------------------------------------
	 * getDate           Solicits a date from User, RETurns reference to Date obj.
	 * statistics        Displays Day of Week of User's birth and if a leap year
	 * daysTillBirthday  Determines number of days until User's next birthday
	 * daysOld           Determines age of User, in days
	 *
	 *****************************************************************************
	 */
    public static void main(String[] args) throws CloneNotSupportedException
    {
    	// Create a Scanner object to parse the User's input values
        Scanner console = new Scanner(System.in);

        
        // Describe the Project Requirements
        System.out.println("   CS-211 Project #1 Solution: \"Date\" Class\n" +
        				   "1. Determine Day of Week for any date\n" +
        				   "2. Determine number of days between any two dates\n" +
        				   "3. Determine if a date is in a leap year");
        
        
        // Solicit the Users' birth date and today's date from the User
        Date birthdate = getDate(console, "you were born");
        Date todayDate = getDate(console, "for today's date");
        
        // Alternative to obtaining a "Date" object for "today's" Date:
        // This utilizes the non-required Class Default Constructor: See "Sate.java"
        // Date todayDate = new Date();
        
        // Display the User's birth date statistics
        statistics(birthdate);
        // Then determine the number of days until the User's next birthday
        daysTillBirthday(birthdate, todayDate);
        // and how many days old is the User.
        daysOld(birthdate, todayDate);
        
        // Close the Scanner object
        console.close();
        
    }	// End static method: main(String[] args)
    
    
	/**************************************************************************
	 * Method: getDate(Scanner,String)
	 * 
	 * Method Description
	 * -------------------
	 * This method solicits a date from the User that consists of the year
	 * (4 digits), month (2 digits max), and day (2 digits max). A "Date"
	 * object is created and a reference to it RETurned to the User.
	 * 
	 * A "String" text is passed to the method in order to customize the prompt
	 * to the User.
	 * 
	 * Important Note: It is ASSUMED the User will enter valid values!
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * Date    Reference to a "Date" object that reflects the User's inputs
	 *
	 * ------------------------------- Arguments ------------------------------
	 *   Type     Name                         Description
	 * --------  -------  -----------------------------------------------------
	 * Scanner   console  Scanner object bound to input device for parsing
	 * String    text     Customize text for solicit prompt to User.
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
    // Prompt the User for their birth date and return a reference to a
    // Date object that represents the solicited date
    private static Date getDate(Scanner console, String text)
    {
    	// Uninitialized Variable Declarations
    	int month, day, year;
        
    	
        // Solicit Date from User
        // Note: Assumes valid input values!
        System.out.print("\nEnter the month " + text + " (1 - 12): ");
        month = console.nextInt();
        System.out.print("Enter the day " + text + " (1 - 31): ");
        day = console.nextInt();
        System.out.print("Enter the year " + text + " (4 digits): ");
        year = console.nextInt();
        
        // Now create a "Date" object to represent the User's input values
        Date birthdate = new Date(year, month, day);
        
        return birthdate;  // RETurn a reference to the "Date" object
        
    }	// End static method: getDate(Scanner,String)
    
    
	/**************************************************************************
	 * Method: statistics(Date)
	 * 
	 * Method Description
	 * -------------------
	 * This method displays birth date statistics relevant to the "Date" object
	 * passed to the method, by reference.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ------------------------------
	 * Type     Name                         Description
	 * ----  ----------  ------------------------------------------------
	 * Date  birthdate   A reference to a birth date object
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
    private static void statistics(Date birthdate)
    {
        System.out.print("\nYou were born on " + birthdate + ", which was a ");
        System.out.println(birthdate.getDayOfWeek() + ".");
        if (birthdate.isLeapYear())
        {
            System.out.println(birthdate.getYear() + " was a leap year.");
        }
        
    }	// End static method: statistics(Date)
    
    
	/**************************************************************************
	 * Method: daysTillBirthday(Date,Date)
	 * 
	 * Method Description
	 * -------------------
	 * This method displays the age of a person, in years, and the number of
	 * days until the person's next birthday.
	 * 
	 * To determine these two values, the person's birth date and "today's"
	 * date, represented by "Date" object are passed by reference to this
	 * method.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ------------------------------
	 * Type     Name                         Description
	 * ----  ----------  ------------------------------------------------
	 * Date  birthdate   A reference to a birth date, "Date" object
	 * Date  todayDate   A reference to a "today's" date, "Date" object
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
    private static void daysTillBirthday(Date birthdate, Date todayDate)
    throws CloneNotSupportedException
    {
    	// Initialized Variable Declarations
    	// 1. Number of days until next birthday: 0 to start
        int daysTillBirthday = 0;
        
        // Create a copy of the caller's "todayDate" object, as it will be
        // modified here to obtain the desired result.
        // 1. Using the Java overridden "clone()" method
        //    Note: "clone()" returns a reference to "Object", so it must be
        //          explicitly cast to a "Date" reference.
        Date today = (Date)todayDate.clone();
        // 2. Using a C++ style Copy Constructor
//        Date today = new Date(todayDate);
        
        
        // Continue adding days to today's date until the month and day of
        // today's date matched the month and day of the User's birth date.
        while (today.getDay() != birthdate.getDay()     ||
        	   today.getMonth() != birthdate.getMonth() )
        {
        	today.nextDay();
        	daysTillBirthday++;
        }
        
        if (daysTillBirthday == 0)
        {	// It's the User's birthday today!!
            int age = (today.getYear() - birthdate.getYear());
            
            System.out.println("Happy birthday!  You are now age " + age + ".");
        }
        else
        {	// Otherwise, the User's birthday is in the future...
            System.out.print("It will be your birthday in " + daysTillBirthday + " day");
            if (daysTillBirthday > 1)
            {
                System.out.print("s");  // no 's' for 1 day
            }
            System.out.println(".");
        }
        
    }	// End static method: daysTillBirthday(Date,Date)
    
    
	/**************************************************************************
	 * Method: daysOld(Date,Date)
	 * 
	 * Method Description
	 * -------------------
	 * This method displays the age of a person, in days, since the person's
	 * birth date.
	 * 
	 * To determine this value, the person's birth date and "today's" date,
	 * represented by "Date" object are passed by reference to this method.
	 * 
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * void
	 *
	 * ------------------------------- Arguments ------------------------------
	 * Type     Name                         Description
	 * ----  ----------  ------------------------------------------------
	 * Date  birthdate   A reference to a birth date, "Date" object
	 * Date  todayDate   A reference to a "today's" date, "Date" object
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
    // Count the number of days since the User's birth date to today's date
    private static void daysOld(Date birthdate, Date todayDate)
    		throws CloneNotSupportedException
    {
    	// Initialized Variable Declarations
    	// 1. Age of User, in days: 0 to start
        int daysOld = 0;
        
        // Create a copy of the caller's "birth date" object, as it will be
        // modified here to obtain the desired result.
        // 1. Using the Java overridden "clone()" method
        //    Note: "clone()" returns a reference to "Object", so it must be
        //          explicitly cast to a "Date" reference.
        Date birthday = (Date)birthdate.clone();
        // 2. Using a C++ style Copy Constructor
//        Date birthday = new Date(birthdate);
        
        
        
        // Continue adding days
        while (!birthday.equals(todayDate))
        {
        	birthday.nextDay();
            daysOld++;
        }
        
        System.out.println("You are " + daysOld + " days old.");
        
    }	// End static method: daysOld(Date,Date)
    
}	// End Class: Birthday
