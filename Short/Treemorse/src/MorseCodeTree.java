/******************************************************************************
 *       Class: MorseCodeTree
 * Super Class: (Inferred: Object)
 *  Implements: None
 *
 * Programmer: Robert Main

 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     12/01/2015  Initial Release
 *
 *
 * Class Description
 * -----------------
 * This class encapsulates a Tree structure that represents all supported ASCII
 * characters and equivalent their Morse Code equivalent "String"s.
 *
 * The Tree serves to allow the Client to either, 1) "decode" a Morse Code
 * "String" and RETurn its equivalent, supported ASCII character, or 2) "encode"
 * a supported ASCII character and RETurn its equivalent Morse Code "String".
 * In addition, a method, toStringSideways" is provided to RETurn a "String"
 * that depicts a sideways view of the Tree used to suppoert the "encode" and
 * "decode" methods.
 *
 *
 * ----------------------------- Public Interface -----------------------------
 *      Method                               Description
 * ----------------- ----------------------------------------------------------
 * MorseCodeTree     Default Constructor: Builds Morse Code Tree
 * encode            RETurns Morse Code "String" for ASCII character supplied             
 * decode            RETurns ASCII "char" for Morse Code "String" supplied     
 * toStringSideways  RETurns "String", sideways view of Morse Code Tree
 *
 *
 * ------------------------- Private Data Members -----------------------------
 *                     Data
 *    Type            Type             Name                 Description
 * ----------  ------------------  ------------  ------------------------------
 * Non-static  MorseCodeTreeNode  topMostNode    Start of Morse Code Tree
 * 
 ******************************************************************************
 */
// Imported Packages
// None


public class MorseCodeTree
{
	// Public "static final" Value Declarations
	// 1. "dit", "dah" characters
	public static final char DIT = '.';
	public static final char DAH = '-';
	// 2. RETurn results for invalid encode/decode requests
	public static final char UNUSED_CHAR = '\0';  // decode: Unsupported Morse Code
	public static final String NO_CODE = "";      // encode: Unsupported ASCII char
	
	// Note: Private - for use in following Morse Code "String" Declarations
	private static final String DIT_S = ".";
	private static final String DAH_S = "-";
	// 3. Supported Morse Code "String" Declarations
	//    A. ASCII letters
	public static final String E = DIT_S;
	public static final String I = DIT_S + DIT;
	public static final String S = DIT_S + DIT + DIT;
	public static final String H = DIT_S + DIT + DIT + DIT;
	public static final String _5 = DIT_S + DIT + DIT + DIT + DIT;
	public static final String _4 = DIT_S + DIT + DIT + DIT + DAH;
	public static final String V = DIT_S + DIT + DIT + DAH;
	public static final String _3 = DIT_S + DIT + DIT + DAH + DAH;
	public static final String U = DIT_S + DIT + DAH;
	public static final String F = DIT_S + DIT + DAH + DIT;
	public static final String $U = DIT_S + DIT + DAH + DAH;
	public static final String _2 = DIT_S + DIT + DAH + DAH + DAH;
	public static final String A = DIT_S  + DAH;
	public static final String R = DIT_S  + DAH + DIT;
	public static final String L = DIT_S  + DAH + DIT + DIT;
	public static final String W = DIT_S  + DAH + DAH;
	public static final String P = DIT_S  + DAH + DAH + DIT;
	public static final String J = DIT_S  + DAH + DAH + DAH;
	public static final String _1 = DIT_S  + DAH + DAH + DAH + DAH;
	//    B. ASCII digits
	public static final String T = DAH_S;
	public static final String N = DAH_S + DIT;
	public static final String D = DAH_S + DIT + DIT;
	public static final String B = DAH_S + DIT + DIT + DIT;
	public static final String _6 = DAH_S + DIT + DIT + DIT + DIT;
	public static final String X = DAH_S + DIT + DIT + DAH;
	public static final String K = DAH_S + DIT + DAH;
	public static final String C = DAH_S + DIT + DAH + DIT;
	public static final String Y = DAH_S + DIT + DAH + DAH;
	public static final String M = DAH_S  + DAH;
	public static final String G = DAH_S  + DAH + DIT;
	public static final String Z = DAH_S  + DAH + DIT + DIT;
	public static final String _7 = DAH_S  + DAH + DIT + DIT + DIT;
	public static final String Q = DAH_S  + DAH + DIT + DAH;
	public static final String O = DAH_S  + DAH + DAH;
	public static final String $O = DAH_S  + DAH + DAH + DIT;
	public static final String _8 = DAH_S  + DAH + DAH + DIT + DIT;
	public static final String $CH = DAH_S  + DAH + DAH + DAH;
	public static final String _9 = DAH_S  + DAH + DAH + DAH + DIT;
	public static final String _0 = DAH_S  + DAH + DAH + DAH + DAH;
	
	// Public Interface
	// 1. Constructors
	//    A. Default Constructor
	MorseCodeTree()
	{
		topMostNode = new MorseCodeTreeNode(UNUSED_CHAR);
		buildTree();
	}
	//
	// 2. Observer Methods
	String encode(char chr)
	{
		String code = encode(topMostNode, Character.toUpperCase(chr), NO_CODE);

		return (code != null) ? code : "";
	}
	
	
	char decode(String code)
	{
		char key;
		
		for (int index = 0; index < code.length(); ++index)
		{
			key = code.charAt(index);
			if (key != DIT && key != DAH)
				throw new IllegalArgumentException("Bad Morse Code sequence");
		}
		
		key = code.charAt(0);
		if (key == DIT)	
			return decode(code, 0, topMostNode.DIT_Branch);
		else
			return decode(code, 0, topMostNode.DAH_Branch);
	}
	
	public String toStringSideways()
	{
		String str = "";
		str += toStringSideways(topMostNode, 0, str);
		
		return str;
	}

	
	// Private Class Data Members
	// 1. Variable Declarations
	private MorseCodeTreeNode topMostNode;
	//
	// 2. Class "static final" Values
	//    A. Parallel Arrays
	//       i. treeChars
	//          Morse Code sequences for letters/digits in the sequence to be
	//          added to the Morse Code Tree structure
	private static final char treeChars[] =
		{ 'E', 'I', 'S', 'H', '5', '4', 'V', '3', 'U', 'F', UNUSED_CHAR, '2', 'A',
		  'R', 'L', 'W', 'P', 'J', '1',
		  'T', 'N', 'D', 'B', '6', 'X', 'K',
		  'C', 'Y', 'M', 'G', 'Z', '7', 'Q', 'O', UNUSED_CHAR, '8', UNUSED_CHAR, '9', '0'
		};
	//       i. treeCodes
	//          The Corresponding characters for the Morse codes added to the
	//          Tree. These are the "data" values for each Tree node
	private static final String treeCodes[] =
		{ E, I, S, H, _5, _4, V, _3, U, F, $U, _2, A, R, L, W, P, J, _1,
		  T, N, D, B, _6, X, K, C, Y, M, G, Z, _7, Q, O, $O, _8, $CH, _9, _0
		};
	
	//
	//          g. toStringSideways(IntTreeNode,int,String)
	private String toStringSideways(MorseCodeTreeNode node, int level, String str)
	{
		// Test for NOT the Base Case, as nothing is to done for the Base Case,
		// i.e. just RETurn to the previous Tree level.
		if (node != null)
		{	// For the visual display of the Tree, the right
			// branch Nodes are to be displayed first, since
			// the deepest, right Node is displayed on the
			// first display line.
			
			// Find the deepest right Node, from THIS root level
			str = toStringSideways(node.DAH_Branch, level + 1, str);
			// Before displaying it, need to give level spacing
			for (int count = 1; count <= level; ++count)
				str += "    ";
			
			// Will display the Nodes "in order"  traversal
			char chr = node.character;
			if (chr == UNUSED_CHAR)
				str += ('*' + "\n");
			else
				str += (node.character + "\n");
			// Now find all the left branch Nodes, from THIS root level
			str = toStringSideways(node.DIT_Branch, level + 1, str);
		}
		
		return str;
	}

	// Private Class  Methods
	private void buildTree()
	{
		for (int index = 0; index < treeCodes.length; ++index)
			topMostNode = addMorseCode(topMostNode, treeCodes[index], 0, treeChars[index]);
	}
	
	private MorseCodeTreeNode addMorseCode(MorseCodeTreeNode node, String code, int index, char chr)
	{
		if (node == null || index >= code.length() )
			node = new MorseCodeTreeNode(chr);
		else if (code.charAt(index) == DIT)
			node.DIT_Branch = addMorseCode(node.DIT_Branch, code, index + 1, chr);
		else
			node.DAH_Branch =  addMorseCode(node.DAH_Branch, code, index + 1, chr);
		
		return node;
	}
	
	private char decode(String code, int index, MorseCodeTreeNode node)
	{
		if (node == null || index >= code.length() )
			return UNUSED_CHAR;
		else if (index == code.length() - 1)
			return node.character;
		else if (code.charAt(++index) == DIT)
			return decode(code, index, node.DIT_Branch);
		else
			return decode(code, index, node.DAH_Branch);
	}
	
	private String encode(MorseCodeTreeNode node, char chr, String code)
	{
		if (node == null)
			return null;
		else if (node.character == chr)
			return code;
		else
		{
			String newCode = encode(node.DIT_Branch, chr, code + DIT);
			if (newCode == null)
				newCode = encode(node.DAH_Branch, chr, code + DAH);
						
			return newCode;
		}
	}
	
}	// End Class Definition: MorseCode
