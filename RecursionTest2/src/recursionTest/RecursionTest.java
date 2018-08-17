package recursionTest;
import java.util.Random;

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
	
	public static int factorials(int num) {
		if(num>1) {
			return num*factorials(num-1);
			
			
			
		}
		else {
			return num;
			
			
		}
		
		
		
	}
	
	public static int fib(int num) {

		if(num>1) {
			return fib(num-1)+fib(num-2);  
			
			
		}
		else {
			return num;
			
		
		
		}
		
		
		
	}
	
	
	
	public static void main(String[] args) {
		Random rnd=new Random();
		int fact=rnd.nextInt(200);
		int rec=rnd.nextInt(100);
		int fibb=rnd.nextInt(500);
		System.out.println(recursiveTest(5));
		System.out.println(factorials(4));
		
		
		System.out.println(fib(41));
	}		
		
}