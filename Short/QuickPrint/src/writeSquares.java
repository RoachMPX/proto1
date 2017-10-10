/******************************************************************************
 *       Class: writeSquares
 *
 * Programmer: Gary Ramli
 *
 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     10/25/2015  Project 4 - Exercise #6 from p.809 in book
 * 
 * Class Description
 * -----------------
 * The class introduces a method that accepts an integer as parameter n and
 * prints the first n squares separated by commas, with the odd squares in 
 * descending order followed by the even squares in ascending order. For example,
 * writeSquares(8); prints the following output:
 * 
 * 49, 25, 9, 1, 4, 16, 36, 64  
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * main(String[] args)			main method
 * writeSquares()				outputs a series of square numbers in given order
 * ------------------------- Private Data Members -----------------------------
 *                  Data
 *    Type          Type         Name                    Description
 * ----------  --------------  ----------  ------------------------------------
 *	  N/A			N/A			 N/A			         N/A
 ******************************************************************************
 */
public class writeSquares {
	
	//this is the main method
	//the method calls on to other methods
	public static void main(String[] args){
		writesquares(10);
	}
	
	//this method writes squares of numbers in the following order:
	//descending odd squares, 1, ascending even squares until the square of number given
	//Example: writeSquares(8) gives:
	//49, 25, 9, 1, 4, 16, 36, 64
	public static void writesquares(int n){
		
		//throws exception when a value passed is less than 1
		if(n < 1){
			throw new IllegalArgumentException();
		}
		
		//checks if the number is 1 and prints 1
		if(n == 1){
			System.out.print("1");
			return; //important
		}
		
		//prints odd number squares
		if(n%2 == 1){
			System.out.print(n * n + ", ");
			writesquares(n - 1);
			
		//prints even number squares/change to odd number squares
		}else{
			//if at first number is even, automatically changes it to odd
			//note that the spacing is called before the squares
			writesquares(n - 1);
			System.out.print(", " + n * n);
		}
	}
		
}
