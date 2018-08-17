package parrotTrouble;

public class Temp {
	static int Temp1=50;
	static int Temp2=100;
	public static void main(String[]args) {
		System.out.println(tempCheck(Temp1, Temp2));
		
		
		
	}
	
	
	
	public static boolean tempCheck(int temp1, int temp2) {
		if(temp1<0&&temp2>100) {
			return true;
			
			
			
			
		}
		else {
			return false;
			
			
		}
		
		
		
		
		
		
	} 
}
