package RodCutting;

import java.util.Scanner;

//Drawbacks:Each time sub problem is encountered it is recalculated
public class Recursive {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rods");
		int n = in.nextInt();
		int[] p = Main.getInputPrices(n);
		System.out.println("Dynamic programming - Recursive");
		System.out.println("Enter the value rod length for which the value is to be calculated");
		int rod = in.nextInt();
		System.out.println(cutRod(p,rod));
		in.close();
	}
	
	public static double cutRod(int[] p,int n) {
		if(n==0) {
			return 0;
		}
		double q = Double.NEGATIVE_INFINITY;
		for(int i=1;i<=n;i++) {
			q = Main.max(q,p[i]+cutRod(p,n-i));
		}
		return q;		
	}
}
