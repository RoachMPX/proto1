/******************************************************************************
 *       Class: CompareAverage
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
 * on the comparison of the class's student's "average" data member.
 *
 * ----------------------------- Public Interface -----------------------------
 *               Method                               Description
 * ------------------------------------ ---------------------------------------
 * compareAverage()					    compares two averages in StudentRecords 
 * 
 * ------------------------- Private Data Members -----------------------------
 *    Type       Data Type        Name                   Description
 * ----------  --------------  ----------  ------------------------------------
 *    N/A			N/A			  N/A					 N/A
 *
 ******************************************************************************
 */
import java.util.Comparator;

//create an average class implementing comparator
public class CompareAverage implements Comparator<StudentRecords>{
	
	public int compare(StudentRecords ave1, StudentRecords ave2){
		return StudentRecords.compareAverage(ave1, ave2);
	}
}	

