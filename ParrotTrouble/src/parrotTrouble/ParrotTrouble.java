package parrotTrouble;

public class ParrotTrouble {

	static int hour=3; 
	static boolean talking=false;
	static boolean timeok = false;
	public static void main(String[]args) {
		parrotTrouble(hour, talking);
		if(talking==true&&timeok==false) {
			System.out.println("U R in trouble");
			
		}
		else {
			System.out.println("U R okay");
			
			
		}
		
	}
	
	
	
	
	public static void parrotTrouble(int hour,boolean talking) {
		
		if(hour<7||hour>20) {
			timeok = false;
			
			
			
		}
		
		else {
			timeok=true;
			
			
			
		}
		
		
	}
	
}
