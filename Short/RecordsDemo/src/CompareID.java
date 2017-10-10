/******************************************************************************
 *       Class: CompareID
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
 * on the comparison of the class's student's "ID" data member.
 *
 * ----------------------------- Public Interface -----------------------------
 *               Method                               Description
 * ------------------------------------ ---------------------------------------
 * compareID()						    compares two ID in StudentRecords 
 * 
 * ------------------------- Private Data Members -----------------------------
 *    Type       Data Type        Name                   Description
 * ----------  --------------  ----------  ------------------------------------
 *    N/A			N/A			  N/A					 N/A
 *    
 ******************************************************************************
 */
import java.util.Comparator;

//create an ID class implementing comparator
public class CompareID implements Comparator<StudentRecords>{
	
	public int compare(StudentRecords ID1, StudentRecords ID2){
		return StudentRecords.compareID(ID1, ID2);
	}

}	