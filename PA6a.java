package edu.wit.cs.comp1000;
import java.util.Scanner;
public class PA6a {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the year: ");
		int year = in.nextInt();
		System.out.print("Enter the day of the week of January 1st (0=Sunday, 1=Monday, ... 6=Saturday): ");
		int start = in.nextInt();
		
		in.close();
		
		if(year<=0){
			System.out.println(E_YEAR);
			System.exit(0);
		}
		if(start<0 || start>6){
			System.out.println(E_DAY);
			System.exit(0);
		}
		
		int febDays;
		if(isLeapYear(year)){
			febDays = 29;
		}else{
			febDays = 28;
		}
		
		printMonth("January", start, 31);
		int a = (start+31)%7;
		printMonth("February", a, febDays);
		int b = (a+febDays)%7;
		printMonth("March", b, 31);
		int c = (b+31)%7;
		printMonth("April", c, 30);
		int d = (c+30)%7;
		printMonth("May", d, 31);
		int e = (d+31)%7;
		printMonth("June", e, 30);
		int f = (e+30)%7;
		printMonth("July", f, 31);
		int g = (f+31)%7;
		printMonth("August", g, 31);
		int h = (g+31)%7;
		printMonth("September", h, 30);
		int i = (h+30)%7;
		printMonth("October", i, 31);
		int j = (i+31)%7;
		printMonth("November", j, 30);
		int k = (j+30)%7;
		printMonth("December", k, 31);
	}
	/**
	 * Error to output if year is not positive
	 */
	static final String E_YEAR = "The year must be positive!";
	
	/**
	 * Error to output if the day is not between 0 and 6
	 */
	static final String E_DAY = "The day of January 1st must be between 0 and 6!";
	
	/**
	 * Determines if an input is a leap year
	 * 
	 * @param year year in question
	 * @return true if a leap year
	 */
	public static boolean isLeapYear(int year) {
		if(year%4==0 && year%100!=0 || year%400==0){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * Outputs a month to the console
	 * 
	 * @param month title
	 * @param startDay 0=Sunday ... 6=Saturday
	 * @param numDays number of days in the month
	 * @return day of the week after the last day of the month
	 */
	public static int printMonth(String month, int startDay, int numDays) {
		System.out.println(month);
		int end_week=0;
		
		if(startDay==1){
			System.out.print("   ");
			end_week = 1;
		}else if(startDay==2){
			System.out.print("      ");
			end_week = 2;
		}else if(startDay==3){
			System.out.print("         ");
			end_week = 3;
		}else if(startDay==4){
			System.out.print("            ");
			end_week = 4;
		}else if(startDay==5){
			System.out.print("               ");
			end_week = 5;
		}else if(startDay==6){
			System.out.print("                  ");
			end_week = 6;
		}
		
		for(int i=1;i<=numDays;i++){
			if(i<10){
				if(end_week/7==1){
					System.out.println();
					end_week=0;
				}
				System.out.print("  "+i);
				end_week++;
			}else{
				if(end_week/7==1){
					System.out.println();
					end_week=0;
				}
				System.out.print(" "+i);
				end_week++;
			}
		}
		
		if(end_week==7){
			end_week=0;
		}
		
		System.out.println();
		System.out.println();
		return end_week;
	}

	/**
	 * Program execution point:
	 * input year, day of the week (0-6) of January 1
	 * output calendar for that year
	 * 
	 * @param args command-line arguments (ignored)
	 */
}