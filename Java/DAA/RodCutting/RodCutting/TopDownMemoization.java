package RodCutting;

import java.util.Scanner;

//Advantage:Re-use of sub problem by storing the solutions of calculated sub problems
public class TopDownMemoization {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rods");
		int n = in.nextInt();
		int[] p = Main.getInputPrices(n);
		int[] s = new int[n+1];
		double[] r = new double[n+1];
		for(int i=0;i<=n;i++) {
			r[i] = Double.NEGATIVE_INFINITY;
		}
		System.out.println("Dynamic programming - Top down approach with memoization");
		System.out.println("Enter the value rod length for which the value is to be calculated");
		int rod = in.nextInt();
		System.out.println(cutRodMemoized(p,rod,r,s));
		System.out.println("Rods that comprises "+rod);
		while(rod >0) {
			System.out.println(s[rod]);
			rod = rod-s[rod];
		}
		in.close();
	}
	
	public static double cutRodMemoized(int[] p,int n,double[] r,int[] s) {
		if(r[n] >= 0) {
			return r[n];
		}
		if(n==0) {
			return 0;
		}
		double q = Double.NEGATIVE_INFINITY;
		for(int i=1;i<=n;i++) {
			double tmp = p[i]+cutRodMemoized(p,n-i,r,s);
			if (q < tmp) {
				q = p[i]+cutRodMemoized(p,n-i,r,s);
				s[n]=i;
				
			}
		}
		//storing the values
		
		r[n] = q;
		return q;		
	}
}
