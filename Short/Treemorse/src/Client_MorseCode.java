/******************************************************************************
* Bellevue Class: CS-211
*           Term: Fall 2015
*     
* Textbook: Building Java Programs, A Back to Basics Approach
*  Edition: 3rd
*  Authors: Stuart Reges and Marty Stepp
*  
* Instructor Project Solution
* Assigned Project: 10
*     Text Chapter: 17
*          Project: 2 (Morse Code)
*
*
*  Class Name: Client_MorseCode
* Super Class: Object (Implicit)
*  Implements: None
*
*
* Programmer: Robert Main
*
* Revision     Date                        Release Comment
* --------  ----------  ------------------------------------------------------
*   1.0     12/01/2015  Initial Release
*
* File Description
* ----------------
* This file defines the the class Client_MorseCode, which includes all methods,
* variables, and constant values. Specifically, this class contains the Console
* application entry method, main(), which is a static method, since no object
* of the class type is ever instantiated.
*
*
* User Defined Types (UDTs) Utilized
* ----------------------------------
*      Name                               Description
* --------------  -------------------------------------------------------------
* MorseCodeTree   Provides "encode" and "decode" methods for, 1) A "String"
*                 Morse Code for a supported ASCII character, and 2) An ASCII
*                 character for a supported Morse Code "String".
*
*
* Program Inputs
* --------------
* None
*
* 
* Program Outputs
* ---------------
*  Device                            Description
* --------  ------------------------------------------------------------------
* Monitor   Results of multiple calls to Morse Code Tree methods "encode" and
*           "decode".
*
* 
* Class Methods
* -------------
*    Name                                    Description
* ----------  ----------------------------------------------------------------
* main        The OS transfers control to this method upon program execution
*
******************************************************************************
*/
// Imported Packages
// None

public class Client_MorseCode
{	
	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Method Description
	 * ------------------
	 * This static method is the entry point to the program.
	 * 
	 * The purpose of this Client program is to test the UDT class
	 * "MorseCodeTree" methods "encode" and "decode" to REurn supported values
	 * and to RETurn values that signify an unsupported request to both methods.
	 * 
	 * 
	 * Pre-Conditions
	 * --------------
	 *  None
	 * 
	 *
	 * ------------------------------- Arguments ------------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String[]  args          Array of "string" argument(s) passed to main()
	 *                         when the Console program is invoked by the User.
	 *
	 *
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * void      No value RETurned by the method
	 *
	 *
	 * Invoked Methods
	 * ---------------
	 *         Name                              Description
	 * --------------------  --------------------------------------------------
	 *                            *** None ***
	 *                         
	 **************************************************************************                         
	 */
	public static void main(String[] args)
	{
		// Constant "final" Array Declarations
		// 1. Array of Morse Codes for all ASCII letter characters
		final String letterCodes[] =
			{ MorseCodeTree.A, MorseCodeTree.B, MorseCodeTree.C, MorseCodeTree.D,
			  MorseCodeTree.E, MorseCodeTree.F, MorseCodeTree.G, MorseCodeTree.H,
			  MorseCodeTree.I, MorseCodeTree.J, MorseCodeTree.K, MorseCodeTree.L,
			  MorseCodeTree.M, MorseCodeTree.N, MorseCodeTree.O, MorseCodeTree.P,
			  MorseCodeTree.Q, MorseCodeTree.R, MorseCodeTree.S, MorseCodeTree.T,
			  MorseCodeTree.U, MorseCodeTree.V, MorseCodeTree.W, MorseCodeTree.X,
			  MorseCodeTree.Y, MorseCodeTree.Z
			};
		// 2. Array of Morse Codes for all ASCII digit characters
		final String numberCodes[] =
			{ MorseCodeTree._0, MorseCodeTree._1, MorseCodeTree._2, MorseCodeTree._3,
			  MorseCodeTree._4, MorseCodeTree._5, MorseCodeTree._6, MorseCodeTree._7,
			  MorseCodeTree._8, MorseCodeTree._9
			};
		// 3. Array of unsupported Morse Codes
		final String badCodes[] = { "----", "..--" };
		final char badCharacters[] = { '<', ',', '!', (char)214, (char)220 };
		
		// Initialized ADT Objects
		MorseCodeTree tree = new MorseCodeTree();
		
		
		System.out.println("Tree built");
		System.out.println("\n\"Sideways\" View of Morse Code Tree" +
						   "\nNote: '*' denotes an \"unused\" Node");
		System.out.println(tree.toStringSideways());
		
		
		for (String code : letterCodes)
		{
			char chr = tree.decode(code);
			
			if (chr != MorseCodeTree.UNUSED_CHAR)
				System.out.printf("Code: %-5s  Character: %s\n", code , chr);
			else
				System.out.println("Error: Could not find Code: " + code);
		}

		for (String code : numberCodes)
		{
			char chr = tree.decode(code);
			
			if (chr != MorseCodeTree.UNUSED_CHAR)
				System.out.printf("Code: %-5s  Character: %s\n", code , chr);
			else
				System.out.println("Error: Could not find Code: " + code);
		}
		
		char startLetter = 'A';
		char endLetter = 'Z';
		System.out.println();
		for (char letter = startLetter; letter <= endLetter; ++letter)
		{
			String code = tree.encode(letter);
			System.out.println("Character: " + letter + "  Code: " + code);
		}
		
		
		char startNumber = '0';
		char endNumber =   '9';
		for (char number = startNumber; number <= endNumber; ++number)
		{
			String  code = tree.encode(number);
			System.out.println("Character: " + number + "  Code: " + code);
		}
		
		System.out.println();
		startLetter = 'a';
		endLetter = 'z';
		for (char letter = startLetter; letter <= endLetter; ++letter)
		{
			String code = tree.encode(letter);
			System.out.println("Character: " + letter + "  Code: " + code);
		}
		
		
		System.out.println();
		for (int index = 0; index < badCodes.length; ++index)
		{
			String code = badCodes[index];

			char chr = tree.decode(code);
		
			if (chr == MorseCodeTree.UNUSED_CHAR)
				System.out.printf("Success: Code: %s was NOT found\n", code);
			else
				System.out.printf("Error, invalid code found: Code: %-5s  Character: %s\n", code , chr);
		}		
		
		
		System.out.println();
		for (int index = 0; index < badCharacters.length; ++index)
		{
			char chr= badCharacters[index];

			String code = tree.encode(chr);
		
			if (code.equals(MorseCodeTree.NO_CODE) )
				System.out.printf("Success: Character: %s was NOT found\n", chr);
			else
				System.out.printf("Error, invalid Character found: cCharacter: %-5s  Code: %s\n", chr , code);
		}		
		
	}   // End method: main(String[])
	
}   // End Class Definition: Client_MorseCode
