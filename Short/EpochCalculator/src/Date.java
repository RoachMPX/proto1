
public class Date {
	
	/******************************************************************************
	 *       Class: Date    
	 * Super Class: Birthday
	 *
	 * Programmer: Gary Ramli

	 * Project      Date                          Release Comment
	 * --------  ----------  ------------------------------------------------------
	 *    1      09/27/2015  Project 1, revision of chapter 8
	 * 
	 * Class Description
	 * -----------------
	 * This project is the problem from Programming Projects in the textbook, p.571
	 * This 
	 *
	 * ----------------------------- Public Interface -----------------------------
	 *           Method                               Description
	 * --------------------------- ------------------------------------------------
	 * Date()                      Constructor
	 * addDays()                   Mutates d
	 * addWeeks()                  Mutates d
	 * daysto()          		   Finds difference in days
	 * getDay()					   Returns int d
	 * getMonth()				   Returns int m
	 * getYear()				   Returns int y
	 * clone()					   Copies object "date" (returns this date)
	 * equals()					   Returns true/false and compares dates
	 * getDayOfWeek()			   Returns the day of the week in any given date
	 * nextDay()				   Advances day by 1
	 * isLeapYear()				   Checks if a year is a leap year 
	 * toString()                  Returns "String" description of class object
	 * 
	 * ------------------------- Private Data Members -----------------------------
	 *                  Data
	 *    Type          Type         Name                    Description
	 * ----------  --------------  ----------  ------------------------------------
	 *  private			int  		   y				year of the date
	 *  private			int 		   m    			month of the date
	 *  private			int 		   d  				day of the date
	 ******************************************************************************
	 */
	
	//the variables below are declared in private form
	//other classes will not be able to access these variables without returning them
		private int y; 
		private int m;
		private int d;
	
	//Constructs a new Date object to represent the given date (constructor)
	public Date( int year, int month, int day){
		this.y = year;
		this.m = month;
		this.d = day;
	}
	
	//This method moves the date forward by adding a number of dates
	//The method also considers the number of days in a month and months in a year.
	public void addDays(int days){
		 d += days;
		 while(((m == 2) && (isLeapYear() == true)) && (d > 29)){
				d -= 29; 
				m += 1;
				while(m > 12){
					m -= 12; 
					y += 1;
				}
			}while((d > 28) && (m == 2)){
				d -= 28; 
				m += 1;
				while(m > 12){
					m -= 12; 
					y += 1;
				}
			}while((d > 31) && (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)){
				d -= 31;
				m += 1;
				while(m > 12){
					m -= 12;
					y += 1;
				}
			}while((d > 30) && (m == 4 || m == 6 || m == 9 || m == 11)){
				d -= 30; 
				m += 1;
				while(m > 12){
					m -= 12; 
					y += 1;
			}
		}
	}

	//This method adds the numbers in the Date object
	//Again this method considers the number of days in a month and months in a year.
	public void addWeeks(int weeks){
		 d += 7*weeks;
		 while(((m == 2) && (isLeapYear() == true)) && (d > 29)){
				d -= 29; 
				m ++;
				while(m > 12){
					m -= 12; 
					y ++;
				}
			}while((d > 28) && (m == 2)){
				d -= 28; 
				m += 1;
				while(m > 12){
					m -= 12; 
					y ++;
				}
			}while((d > 31) && (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)){
				d -= 31;
				m ++;
				while(m > 12){
					m -= 12;
					y ++;
				}
			}while((d > 30) && (m == 4 || m == 6 || m == 9 || m == 11)){
				d -= 30; 
				m ++;
				while(m > 12){
					m -= 12; 
					y ++;
			}
		}
	}

	//Returns the number of days that the date must adjust to make it equal to the other date
	//adds one day if the day is not equal the the new date object
	//also overrides equals()
	public int daysTo(Date other){
		Date zz = clone();
		int nodays = 0; //new variable declared
		while (zz.equals(other) != true){
		zz.nextDay();
		nodays++;
		}
		return nodays;
	}
	
	//Returns the day value of the Date.
	public int getDay(){
		return d;
	}
	
	//Returns the month value of the Date.
	public int getMonth(){
		return m;
	}
	
	//Returns the year value of the Date.
	public int getYear(){
		return y;
	}
	
	//Creates a new Date object and returns back to the main method
	public Date clone(){
		Date duplicate = new Date(y,m,d);
		return duplicate;
	}
	
	//this method checks if birthdate and todaydate are equal
	//returns true if yes, otherwise returns false.
	public boolean equals(Date zz){
		//variables declared
		int a = zz.d;
		int b = zz.m;
		int c = zz.y;
		
		//checks if both days, months and years are equal to one another.
		if((a == d) && (b == m) && (c == y)){
			return true;
		}else
			return false;
	}
	
	//returns true if the year of the date is a Leap Year
	//otherwise returns false
	public boolean isLeapYear(){
		if(y%400 == 0){
			return true;
		}else if(y%100 == 0){
			return false;
		}else if(y%4 == 0){				
			return true;
		}else{
			return false;
		}
	}
	
	//This method determines the day of the week in the Date object.
	public String getDayOfWeek(){
		//Variables declared
		int i = y%100;
		int j = y - i;
		int k = 0;
		int l = 0;
			//Finds the number needed to calculate in accordance to the date's century number
				  if(j == 1300 || j == 1700 || j == 2100){
				 k = 4;
			}else if(j == 1400 || j == 1800 || j == 2200){
				k = 2;
			}else if(j == 1500 || j == 1900 || j == 2300){
				k = 0;
			}else if(j == 1600 || j == 2000 || j == 2400){ 
				k = 6;
			}
			//Finds the numbers needed to calculate in accordance to the months and leap year.
			if((m == 1 && isLeapYear() == true)|| m == 4 || m == 7){
				l = 6;
			}else if((m == 2 && isLeapYear() == true)|| m == 8){
				l = 2;
			}else if(m == 1 || m == 10){
				l = 0;
			}else if(m == 2 || m == 3 || m == 11){
				l = 3;
			}else if(m == 5){
				l = 1;
			}else if( m == 9 || m == 12){
				l = 5;
			}else if (m == 6){
				l = 4;
			}
		//Determines the day of the given Date.
		int x = (d + l + i + (i/4) + k)%7;
			if(x == 1){
				return "Monday";
			}else if (x == 2){
				return "Tuesday";
			}else if (x == 3){
				return "Wednesday";
			}else if (x == 4){
				return "Thursday";
			}else if (x == 5){
				return "Friday";
			}else if (x == 6){
				return "Saturday";
			}else
				return "Sunday";
	}
	
	//advances date by 1
	//this method ensures that the month and year will advance in accordance to the date
	//the leap year is also considered in this case
	public void nextDay(){
		d += 1;
		if(((m == 2) && (isLeapYear() == true)) && (d > 29)){
			d = 1; 
			m += 1;
			if(m > 12){
				m = 1; 
				y += 1;
			}
		}else if((d > 28) && (m == 2)){
			d = 1; 
			m += 1;
			if(m > 12){
				m = 1; 
				y += 1;
			}
		}else if((d > 31) && (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12)){
			d = 1;
			m += 1;
			if(m > 12){
				m = 1;
				y += 1;
			}
		}else if((d > 30) && (m == 4 || m == 6 || m == 9 || m == 11)){
			d = 1; 
			m += 1;
			if(m > 12){
				m = 1; 
				y += 1;
			}
		}
	}
	
	//Returns a String representation of the date in year/month/day format
	public String toString(){
		if(getMonth() < 10 && getDay() <10){
		return "Date: " + getYear() + "/0" + getMonth() + "/0" + getDay();
		}
		else if(getMonth() < 10){
			return "Date: " + getYear() + "/0" + getMonth() + "/" + getDay();
		}
		else if(getDay() < 10){
			return "Date: " + getYear() + "/" + getMonth() + "/0" + getDay();
		}
		else
			return "Date: " + getYear() + "/" + getMonth() + "/" + getDay();
	}
}
