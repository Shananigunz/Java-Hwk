package cootieCatcher;
import java.util.Scanner;
public class CootieCatcher {
	public static void main(String[]args){
		int input1=0;
		int input2=0;
		int input3=0;
		Scanner scn=new Scanner(System.in);
		boolean playAgain=true;
		while(playAgain==true) {
		System.out.println("Welcome to my fortune teller.....");	
		System.out.println("Please choose a number from 1-10");	
		input1=scn.nextInt();	
		if(input1%2==0) {
		System.out.println("You have 4 options...2, 4, 6, or 8....Choose wisely.");
		input2=scn.nextInt();	
		if(input2==2) {
			System.out.println("Something great will occur today.");
			
		}
		if(input2==4) {
			System.out.println("You will succeed in your long term goal eventually.");
			
		}	
		if(input2==6) {
			System.out.println("You will be the greatest human being that has ever walked this Earth.");
			
		}	
		if(input2==8) {
			System.out.println("You are retarted.");
			
		}
		}
		else {
		System.out.println("You have 4 options...1, 3, 5, or 7....Choose wisely.");	
		input2=scn.nextInt();	
		if(input2==1) {
			System.out.println("You will greatly amaze others.");
			
		}
		if(input2==3) {
			System.out.println("You will fail indefinitely.");
			
		}	
		if(input2==5) {
			System.out.println("You are cool");
			
		}	
		if(input2==7) {
			System.out.println("You will be immortal in the hearts of others.");
			
		}		
		}
		System.out.println("Play again?(1 for yes, 2 for no)");	
		input3=scn.nextInt();
		if(input3==2) {
			playAgain=false;
		}
		}
	}
}
