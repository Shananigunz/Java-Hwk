package daysiftheweek;
import java.util.Scanner;
public class DaysOfTheWeek 
	{
public static final int SUNDAY=1;	
public static final int MONDAY=SUNDAY<<2;
public static final int TUESDAY=MONDAY<<1;
public static final int WEDNESDAY=SUNDAY<<3;
public static final int THURSDAY=WEDNESDAY<<1;
public static final int FRIDAY=WEDNESDAY<<2;
public static final int SATURDAY=SUNDAY<<6;
public static boolean running=true;
public static int code;
	public static void main(String[]args) {
		Scanner scn=new Scanner(System.in);
		System.out.println(MONDAY);
		System.out.println("This is the day of the week calculator");
		
		while(running) {
			System.out.println("What day do you want to add?(only lowercase)");
			String s=scn.nextLine();
			boolean invalid=true;		
			if(s.equals("none")) {
				running=false;
				
			}
			if(s.equals("monday")) {
				invalid=false;
								
			}
			if(s.equals("tuesday")) {
				invalid=false;
				
			}
			if(s.equals("wednesday")) {
				invalid=false;
				
			}
			if(s.equals("thursday")) {
				invalid=false;
				
				
			}
			
			if(s.equals("friday")) {
				invalid=false;
				
				
			}
			if(s.equals("sunday")) {
				invalid=false;
				
			}
			if(s.equals("saturday")) {
				invalid=false;
				
			}
			
			else if(invalid==true){
				System.out.println("You wrote something invalid. Try Again");
				
			}
			System.out.println("Your current code is ["+code+"]");
			
		}
	}
}
