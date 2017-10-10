/******************************************************************************
 *       Class: BookRead
 *
 * Programmer: Gary Ramli
 *
 * Revision     Date                          Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     10/18/2015  BookRead
 * 
 * Class Description
 * -----------------
 * This class reads words from a book to two different files and storing them 
 * into two map objects. This map object sorts words in an ascending order to keep things need.
 *
 * ----------------------------- Public Interface -----------------------------
 *           Method                               Description
 * --------------------------- ------------------------------------------------
 * main(String[] args)			main method
 * getCountMap()				creates a map object of words within file (selective)  
 * intro()						explains what the program does (makes things neater)
 * ------------------------- Private Data Members -----------------------------
 *                  Data
 *    Type          Type         Name                    Description
 * ----------  --------------  ----------  ------------------------------------
 * non-Static	TreeSet			 Tree		creates a tree set of a particular file	
 * non-Static	Map				 count1		creates a map that counts selected words in file1
 * non-Static	Map				 count2		creates a map that counts selected words in file2
 * non-Static	String			 name1		name of file1 (Hamlet.txt)
 * non-Static 	String			 name2		name of file2 (KingLear.txt)
 * non-Static	String			 word		selected word
 * non-Static	int				 num		number of the selected word
 * non-Static	int				 rejected	number of the rejected word
 * non-Static	int				 length		length of the selected word
 ******************************************************************************
 */

import java.io.*; 
import java.util.*;

public class BookRead {
	
	//this is the main method,
	//a method which calls on to other methods to run.
	public static void main(String[] args) 
			throws FileNotFoundException{
		
		//variables declared
		Scanner scan; //Scanner
		TreeSet<String> tree; //treeSet
		Map<String, Integer> count1; //map for file1 (hamlet)
		Map<String, Integer> count2; //map for file2 (kinglear)
        String name1 = "Hamlet.txt"; //name of file "hamlet"
        String name2 = "KingLear.txt"; //name of file "kinglear"
        
        //intro called
        intro();
        
        //constructs two file objects given (hamlet and kinglear).
        File file1 = new File(name1);
        File file2 = new File(name2);
       
        // tests to see if both of these files exist
    	if (file1.exists() || file2.exists()){
    		   
    		//file1 is now read by the scanner
    		scan = new Scanner(file1);
    		System.out.println("Statistics for file: " + name1);    
    		//calls getCountMap()
    		count1 = getCountMap(scan);
    		//closes file1
    		scan.close();
    		//output1
    		System.out.println("  After processing, there are " + count1.size() + " distinct words in the file\n");
       
       		   
    		//file2 is then read by the scanner
    		scan = new Scanner(file2);       
    		System.out.println("Statistics for file: " + file2);
    		//calls getCountMap() again
    		count2 = getCountMap(scan);
    		//closes file2
    		scan.close();
    		//output2
            System.out.println("  After processing, there are " + count2.size() +" distinct words in the file\n");

       		   
            //creates a TreeSet object
            //this makes a copy map created for "hamlet"
            tree = new TreeSet<String>(count1.keySet());
            tree.retainAll(count2.keySet());
       			
            //output
            System.out.println("There are " + tree.size() + " common words in files " + name2 + " and " + name1 + ".\n"
            				 + "The common words are: " +
       					       "\n    Word      " + name1 + "    " + name2 +
       					       "\n------------  ------------  ------------");
            for (String word: tree){
            	int countFile1 = count1.get(word);
            	int countFile2 = count2.get(word);
            	//ensures that the spacing of the output is correct
            	System.out.printf("%12s %8d% 16d\n", word, countFile1, countFile2);
       		   	}
    	}else{
    		//program will only print message if files does not exist
    		//(will do nothing other than printing)
    		if (!file1.exists()){
    			System.out.println("File "+ name1 +" does not exist.");
    		  	}else if(!file2.exists()){
    		  		System.out.println("File " + name2 + " does not exist.");
    		  	}	
    	  	}
		}
	
		//this method declares a Map to store selected words contained in the file 
		//this method also counts the number of these words within the file
        public static Map<String, Integer> getCountMap(Scanner scan){
        	//map declared
            Map<String, Integer> countMap = new TreeMap<String, Integer>();
          
            //other variables declared
            String word;
            int num = 0; //number of the word in text
            int rejected = 0; //number of the word rejected in text
            int length; //length of the word
            scan.useDelimiter("[^a-zA-Z']+");

            //ensures that the entire file is read
            while(scan.hasNext()){ 
            	//increments the number of words counted
            	num++;
            	
            	//pass the string to lower case
                word = scan.next().toLowerCase();
                length = word.length(); 
                
                //tests to see if the word is an apostrophe
                if(word.charAt(0) == '\''){
                	if(length == 1) { 
                		//removes word
                		length = 0;  
                	}else{	
                    	word = word.substring(1); 
                		}
                } 
                //counts and removes rejected words
                if(length == 0){	
                	rejected++;
                	}else{ 
                		if(!countMap.containsKey(word)){	
                		countMap.put(word, 1); 
                		}else{	
                			int count = countMap.get(word); 
                			countMap.put(word, count + 1);
                	}
                }
            }
            //output
            System.out.printf("  There are a total of " + num +  " words in the file.\n"
            		        + "  Of those, " + rejected + " were ignored, leaving " + (num - rejected) + " words to process.\n");
            return countMap;
        }
        
      //this method prints out the introduction to the scanner when the program is run.
        public static void intro(){
    		System.out.println("             Chapter 11, Assigned Project #4");
    		System.out.println("This program determines the distinct words in two different books");
    		System.out.println("(from disk files) and the number of times each word occurs in the");
    		System.out.println("file, determines the common words in both files, and final displays");
    		System.out.println("of the results.\n");
    	}
}