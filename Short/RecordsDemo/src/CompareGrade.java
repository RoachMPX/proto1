/******************************************************************************
 *       Class: CompareGrade
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
 * on the comparison of the class's student's "grade" data member.
 *
 * ----------------------------- Public Interface -----------------------------
 *               Method                               Description
 * ------------------------------------ ---------------------------------------
 * compareGrade()					    compares two grades in StudentRecords 
 * 
 * ------------------------- Private Data Members -----------------------------
 *    Type       Data Type        Name                   Description
 * ----------  --------------  ----------  ------------------------------------
 *    N/A			N/A			  N/A					 N/A
 *
 ******************************************************************************
 */
import java.util.Comparator; 

//create a grade class implementing comparator
public class CompareGrade implements Comparator<StudentRecords>{
	
	public int compare(StudentRecords rec1, StudentRecords rec2){
		return StudentRecords.compareGrade(rec1, rec2);
	}

}	
