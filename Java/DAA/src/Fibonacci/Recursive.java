package Fibonacci;

public class Recursive {
	public static void main(String args[]) {
		int n = Main.getInputNumber();
		
		System.out.println("The fibonacci number of "+n+" is "+Fib(n));
	}
	public static int Fib(int n ) {
		if(n ==0) 
				return 0;
		else if(n ==1) 
				return 1;
		else 
			return 	Fib(n-1)+Fib(n-2);
	}
}
