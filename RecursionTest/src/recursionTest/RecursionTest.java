package recursionTest;

public class RecursionTest {
	public static int recursiveTest(int num)
	{
		if(num>0) {
			
			return num+recursiveTest(num-1);
			
			
		}
		else {
			return 0;
			
			
		}
		
		
	}
	public static void main(String[]args[]) {
		System.out.println(recursiveTest(5));
		
		
		
	}
	
}
