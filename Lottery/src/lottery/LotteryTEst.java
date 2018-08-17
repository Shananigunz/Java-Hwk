
package lottery;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class LotteryTEst {
public static void main(String[]Args) {
	Scanner scn=new Scanner(System.in);
	Random rnd=new Random();
	boolean checkWin=false;
	int balance=50;
	int tickets=0;
	int grandPrize=1000;
	int winCounter;
	boolean playAgain=true;
	
	
	
	while(balance>9&&playAgain==true) {
		ArrayList<Integer> winningTicket = new ArrayList<Integer>();

	for(int i=0; i<3; i++) {
		winningTicket.add((int) Method1.WinTicket(i));
		
	}
	winCounter=0;
	ArrayList<Integer> Tickets = new ArrayList<Integer>();
	int Ticketcounter=1;
	int counter=0;
	int Ticketscounter=0;
	System.out.println("Welcome to my lottery game. How many tickets do you want to buy?");
	System.out.println("Your balance is "+balance+". Each ticket is 10$");
	int tinput=scn.nextInt();
		int BalCalculations=balance/10;
		if(tinput<=BalCalculations) {
			tickets+=tinput;
			balance-= tinput*10;
			
		}
		else {
			System.out.println("Error");
			System.exit(1);
		}
		while(Ticketcounter<=tickets) {
			int []input=new int[3];
						for(int i=1; i<4; i++) {
							System.out.println("What do you want for your "+i+" number for ticket "+Ticketcounter);
							input[i-1]=scn.nextInt();
						}
			
			for(int i=0; i<3; i++) {
				Tickets.add(i, input[1] );
								if(checkWin==true) {
					winCounter++;
					checkWin=false;
				}
				else {
					checkWin=false;
				}
			}
			checkWin=Method1.checkWin(Tickets, winningTicket, Ticketscounter);

			Ticketcounter++;
			Ticketscounter++;
			
			
		}
		
		System.out.println("You have "+winCounter+" wins. That is "+grandPrize*winCounter+"$.");
		balance+=grandPrize*winCounter;
		
		System.out.println(winningTicket);
		System.out.println(winningTicket);
		
		
	}
	}
}
