/*******************************************************************************
 *       Class: MorseCodeTreeNode
 * Super Class: Object (Implicit)
 *  Implements: None
 *
 * Programmer: Robert Main
 *
 * Revision     Date                          Release Comment
 * --------  ----------  -------------------------------------------------------
 *   1.0     12/01/2015  Initial Release
 *
 *
 * Class Description
 * -----------------
 * MorseCodeTreeNode is a class for storing a single, supported Morse Code
 * character value in a Tree representation of all suppoerted Morse Code
 * "Strings.
 *
 *
 * -------------------------- Public Method Members ---------------------------
 *     Name                             Description
 * --------------  ------------------------------------------------------------
 * TreeNode(char)  Constructor: Sets "data", both "branches" to "null"
 *
 *
 * -------------------------- Public Data Members ------------------------------
 *    Class           Data
 *    Type            Type          Name               Description
 * ---------- ------------------ ---------- ------------------------------------
 * non-static char               character  Node's "char" data value
 * non-static MorseCodeTreeNode  DIT_Branch "DIT" branch "MorseCodeTreeNode" obj
 * non-static MorseCodeTreeNode  DAH_Branch "DAH" branch "MorseCodeTreeNode" obj
 *
 *******************************************************************************
 */
public class MorseCodeTreeNode
{
	// Public Interface
	// 1. Constructors
	//    A. Initializing Constructor
	//       post: constructs a node with given "data" and "next": "null"
	public MorseCodeTreeNode(char data)
	{
		this.character = data;
		DIT_Branch = null;
		DAH_Branch = null;
	}

	
	// Public Class Data Members
	// 1. Variable Declarations
	public char character;       // Data stored in this node
	public MorseCodeTreeNode DIT_Branch;
	public MorseCodeTreeNode DAH_Branch;

}	// End Class Definition: MorseCodeTreeNode
