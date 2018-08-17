
package blackJack;
import java.util.Random;
import java.util.Scanner;
public class BlackJack {
	static int [] PCards=new int [11];
	static int [] DCards=new int [11];
	static boolean dBusted=false;
	static boolean pBusted=false;
	public static void main(String[]args) {
	boolean playAgain=true;
	
	while(playAgain==true) {
		
		Scanner scn=new Scanner(System.in);
		dealCards(false, 0);
		dealCards(false, 1);
		dealCards(true, 0);
		dealCards(true, 1);
		System.out.println("Dealer drew a "+DCards[0]+ " and a hidden card.");
		
		pDraw();
		System.out.println("Dealer has "+checkHand(true)+" and you have "+checkHand(false));
		if(checkHand(false)>checkHand(true)&&pBusted==false) {
			System.out.println("You win.");
			
			
		}
		else if(checkHand(true)>checkHand(false)&&dBusted==false){
			System.out.println("Dealer wins.");
			
		}
		int playInput=0;
		System.out.println("Play again?(1 for yes, 2 for no)");
		playInput=scn.nextInt();
		if(playInput==2) {
			playAgain=false;
			
			
		}
		if(playInput==1) {
			reset();
			
			
		}
		
	}
	
	
	}
	
	
	public static void dealCards(boolean Dealer, int counter) {
		Random rnd=new Random();
		if(Dealer==true) {
			DCards[counter]=rnd.nextInt(9)+2;
		
			
		}
		else {
			PCards[counter]=rnd.nextInt(9)+2;
			System.out.println("You drew a "+PCards[counter]);
		}
		
	}
	public static int checkHand(boolean Dealer) {
		int total=0;
		for(int i=0; i<11; i++) {
			if(Dealer==true) {
				total+=DCards[i];
				
			}
			else {
				total+=PCards[i];
				
			}
			
		}
		return total;
		
		
	}
	public static void pDraw() {
		int counter=2;
		Scanner scn=new Scanner(System.in);
		boolean hit=true;
		while(hit==true) {
			
			if(checkHand(false)>21) {
				System.out.println("You busted...You lose.");
				pBusted=true;
				hit=false;
				return;
			}
			else {
				int choice=21;
				System.out.println("Hit or stay?(1 for hit, 2 for stay)");
				choice=scn.nextInt();
				
				if(choice==1) {
				dealCards(false, counter);
				System.out.println("You have a total of "+checkHand(false)+".");
				counter++;
				
				}	
				else if(choice==2) {
				hit=false;	
				System.out.println("You have a total of "+checkHand(false)+".");
				dDraw();
				}
				
				
			}
			
		}
		
		
		
	}
	public static void dDraw() {
		int counter=2;
		
		while(checkHand(true)<17) {
			
			dealCards(true,counter);
						counter++;
			System.out.println("Dealer draws a card");
			
			if(checkHand(true)>21) {
				System.out.println("Dealer has busted....You win....Dealer had a total of "+checkHand(true));
				dBusted=true;
				return;
			}
			
		}
		System.out.println("Dealer stops drawing....Time to compare hands.");
	
	}
	public static void reset() {
		for(int i=0; i<11; i++) {
			PCards[i]=0;
			DCards[i]=0;
			pBusted=false;
			dBusted=false;
		}
		
		
	}
	
	
	
	}
	
	
	

