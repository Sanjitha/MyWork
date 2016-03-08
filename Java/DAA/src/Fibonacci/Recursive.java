package Fibonacci;

import java.util.Arrays;

public class Recursive {
	public static int[] fib;
	public static void main(String args[]) {
		int n = Main.getInputNumber();
		fib = new int[n];
		Arrays.fill(fib, 0);
		System.out.println("The fibonacci number of "+n+" is "+Fib(n));
	}
	public static int Fib(int n ) {
		if(fib[n]!=0)
			return fib[n];
		if(n ==0) 
				return 0;
		else if(n ==1) 
				return 1;
		else {
			fib[n]=	Fib(n-1)+Fib(n-2);
			return fib[n];
		}
	}
}
