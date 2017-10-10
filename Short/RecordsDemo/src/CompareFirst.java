/******************************************************************************
 *       Class: CompareFirst
 *  Implements: Comparator<StudentRecords>
 *
 * Programmer: Gary Ramli
 *
 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     11/01/2015  Part of Project 6
 * 
 * Class Description
 * -----------------
 * This class implements the comparator interface method "compare" based
 * on the comparison of the class's student's "First Name" data member.
 *
 * ----------------------------- Public Interface -----------------------------
 *               Method                               Description
 * ------------------------------------ ---------------------------------------
 * compareFirst() 				 	    compares two names(first) in StudentRecords 
 * 
 * ------------------------- Private Data Members -----------------------------
 *    Type       Data Type        Name                   Description
 * ----------  --------------  ----------  ------------------------------------
 *    N/A			N/A			  N/A					 N/A
 *
 ******************************************************************************
 */
import java.util.Comparator;

//create a first name class implementing comparator
public class CompareFirst implements Comparator<StudentRecords>{
	
	public int compare(StudentRecords fr1, StudentRecords fr2){
		return StudentRecords.compareFirstName(fr1, fr2);
	}

}	