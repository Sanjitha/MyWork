package RodCutting;

import java.util.Scanner;

public class BottomUp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rods");
		int n = in.nextInt();
		int[] p = Main.getInputPrices(n);
		double[] r = new double[n+1];
		int[] s = new int[n+1];
		r[0]=0;
		System.out.println("Dynamic programming - Bottom up approach with memoization");
		System.out.println("Enter the value rod length for which the value is to be calculated");
		int rod = in.nextInt();
		System.out.println(bottomUp(p,rod,r,s));
		System.out.println("Rods that comprises "+rod);
		while(rod >0) {
			System.out.println(s[rod]);
			rod = rod-s[rod];
		}
		in.close();
	}

	private static double bottomUp(int[] p, int n, double[] r,int[] s) {
		for(int j=1;j<=n;j++) {
			double q = Double.NEGATIVE_INFINITY;
			for(int i=1;i<=j;i++) {
				if(p[i]+r[j-i] > q) {
					s[j] = i;
					q = Main.max(q, p[i]+r[j-i]);
				}
			}
			r[j] = q;
		}
		
		return r[n];
	}
}
