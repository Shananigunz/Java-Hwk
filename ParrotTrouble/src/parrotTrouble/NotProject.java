package parrotTrouble;

public class NotProject {
	
	public static void main(String[]args) {
		System.out.println(changeString("NotLOL"));
		
		
		
		
	}
public static String changeString(String origString) {
	if(origString.startsWith("Not")||origString.startsWith("not")) {
	return origString;

	}
	else {
		
		return"Not "+origString;
	}
}
}
