package RodCutting;

import java.util.Scanner;

public class BottomUp {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of rods");
		int n = in.nextInt();
		int[] p = Main.getInputPrices(n);
		double[] r = new double[n+1];
		r[0]=0;
		System.out.println("Dynamic programming - Bottom up approach with memoization");
		System.out.println(bottomUp(p,4,r));
		in.close();
	}

	private static double bottomUp(int[] p, int n, double[] r) {
		for(int j=1;j<=n;j++) {
			double q = Double.NEGATIVE_INFINITY;
			for(int i=1;i<=j;i++) {
				q = Main.max(q, p[i]+r[j-i]);
			}
			r[j] = q;
		}
		
		return r[n];
	}
}
