package RodCutting;
import java.util.Scanner;
public class Main {
	
	public static int[] getInputPrices(int n) {
		Scanner in = new Scanner(System.in);
		int[] p = new int[n+1];
		System.out.println("Enter the price for each of the rods.");
		p[0]=0;
		for(int i=1;i<=n;i++) {
			p[i] = in.nextInt();
		}
		in.close();
		return p;
	}
	public static double max(double a, double b) {
		if( b > a) {
			return b;
		}
		else  {
			return a;
		}
	}
}
