package lottery;
import java.util.ArrayList;
import java.util.Random;
public class Method1 {
static boolean checkWin=false;
static int[]Store=new int[3];
static double []Final=new double[3];
public static double WinTicket(int i) {
	Random rnd=new Random();
	
		Final[i]=rnd.nextInt(100);
		return Final[i];
		
	
	
}

public static boolean checkWin(ArrayList<Integer> finalTicket, ArrayList<Integer> winningTicket, int TC) {

	for(int i=0; i<3; i++) {
	if(finalTicket(i).contains(winningTicket)(i)) {
		checkWin=true;
		
	}
	}
	
	
return checkWin;
}
	

}
