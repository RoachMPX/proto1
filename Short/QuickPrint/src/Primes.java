/******************************************************************************
 * Bellevue Class: CS-211
 *           Term: Fall 2015
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach
 *  Edition: 3rd
 *  Authors: Stuart Reges and Marty Stepp
 *
 * Assigned Project: Project 7
 *
 * Class Name: Primes
 *  File Name: Primes.java
 *  
 * Programmer: Gary Ramli
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     11/8/2015   Project 7 - Programming Projects #1 p.905
 *
 * File Description
 * ----------------
 * This file writes a prime program that finds prime numbers using Sieves of 
 * Eratosthenes. The algorithm finds all prime numbers up to number n (user input) 
 * 
 * Class Methods
 * -------------
 *    Name                                    Description
 * -------------------		  -------------------------------------------------
 * main(String[] args)        Calls on to other methods
 *
 ******************************************************************************
 */
import java.util.*;

public class Primes{	
	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Method Description
	 * ------------------
	 * The main method calls on to other methods
	 * 
	 * This program demonstrates the use of Queues to determine the sequence of
	 * Prime Numbers up to a specified, integer value using the algorithm known
	 * as the "Sieves of Erastosthenes".
	 * 
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 *   N/A								N/A
	 *
	 * ------------------------------- Arguments ------------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String[]  args          Array of "string" argument(s) passed to main()
	 *                         when the Console program is invoked by the User.
	 * 
	 * Invoked Methods
	 * ---------------
	 *    Name                              Description
	 * ----------  ------------------------------------------------------------
	 * 	  N/A									N/A
	 **************************************************************************
	 */
	public static void main(String[] args){
		
		System.out.println("This program demonstrates the use of Queues to determine the sequence of\n" + 
						 "Prime Numbers up to a specified, integer value using the algorithm known\n" +
						 "as the \"Sieves of Erastosthenes\". \n(Enter a number less than 3 to close the program)\n");
		
		//variables declared
		Scanner console = new Scanner(System.in);
        Queue<Integer> primes;
        int max = 0;     
        
        //do while input is not 1
        do{ System.out.println("Enter a number greater than 2: ");
		    
	    	if(!console.hasNextInt()){
	    		System.out.println("The value is not a number - Please input a number");
	    		System.out.println("\nEnter a number greater than 2: ");
	    		console.next();
	    		max = console.nextInt() + 1;
	    	}else{
	    		max = console.nextInt(); 
	    		//tests to verify if input is valid (number must be greater than 2)
	    		if(max > 2){
		    		primes = getprimes(max); 
		    	    System.out.printf("The prime number(s) from 1 to %d is/are:\n  %s\n\n", max, primes);
	    		}
    		}
	    }
        while (max > 2); 
	}   
	
	
	/**************************************************************************
	 * Method: getprimes(int n)
	 * 
	 * Method Description
	 * ------------------
	 * This method implements the "Sieves of Eratosthenes" algorithm by using 2 
	 * separate Queues. The first Queue will include  all integer values up to 
	 * the the given number (n). The program then removes the first number from 
	 * the queue and adds it to a second queue, in which it already has all the 
	 * prime numbers from 2 until the given number (n). 
	 * 
	 *     RETurn
	 *      Type                            Description
	 * --------------  --------------------------------------------------------
	 * Queue<Integer>  Prime numbers from 2 to the given value n
	 *
	 * ------------------------------- Arguments ------------------------------
	 * Type     Name                         Description
	 * ----  ----------  ------------------------------------------------------
	 * int   	 n    	 The given number (via the console)
	 * 
	 * Invoked Methods
	 * ---------------
	 * N/A
	 *
	 **************************************************************************
	 */
	public static Queue<Integer> getprimes(int n){
		
		//queue for prime numbers
		Queue<Integer> result =  new LinkedList<Integer>();
		
		if(n > 1){		
			//variables declared 
			int p; //prime number
			int k; //any number (to be verified if it is a prime)
			Queue<Integer> numbers = new LinkedList<Integer>(); // constructing a new queue for the list of numbers
			
			//calculates the root of number given
			//this number will be used for the algorithm
			int root = (int)Math.sqrt(n);
			
			//fills queue with primes
			for(int i = 2; i <= n; i++)
				numbers.add(i);
			
				//removes 2 (1st prime number)
				p = numbers.remove();
				if (numbers.size() == 1){	
					result.add(p);
					}else{//determine all the other primes
						
						do{	
						//adds the next number to queue
						//this number is always prime
						result.add(p);
						int size = numbers.size();
						
						//removes value in front of queue
						for(int i = 1; i <= size; ++i){	
							k = numbers.remove();
							if(k % p != 0){	
								//adds value back in queue
								numbers.add(k);
							}
						}
						p = numbers.remove();
						if(p > root){	
							// There will be non-prime values remaining in the numbers Queue
							result.add(p);
						}
					}
					while(p <= root);
					//add remaining primes to queue 
					result.addAll(numbers);
				}
			}	
			return result;
	}
}   
