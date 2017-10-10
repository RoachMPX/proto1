/******************************************************************************
 *       Class: CompareLast
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
 * on the comparison of the class's student's "Last Name" data member.
 *
 * ----------------------------- Public Interface -----------------------------
 *               Method                               Description
 * ------------------------------------ ---------------------------------------
 * compareLast()					    compares two names(last) in StudentRecords 
 * 
 * ------------------------- Private Data Members -----------------------------
 *    Type       Data Type        Name                   Description
 * ----------  --------------  ----------  ------------------------------------
 *    N/A			N/A			  N/A					 N/A
 *
 ******************************************************************************
 */
import java.util.Comparator;

//create a Last name class implementing comparator
public class CompareLast implements Comparator<StudentRecords> {
	
	public int compare(StudentRecords ln1, StudentRecords ln2){
		return StudentRecords.compareLastName(ln1, ln2);
	}
}	

