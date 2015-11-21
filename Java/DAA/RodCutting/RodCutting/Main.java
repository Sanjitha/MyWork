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
		return p;
	}
	
	public static int[] getInputCosts(int n) {
		Scanner in1 = new Scanner(System.in);
		int[] c = new int[n+1];
		System.out.println("Enter the costs for each cut.");
		c[0]=0;
		for(int i=1;i<=n;i++) {
			c[i] = in1.nextInt();
		}
		return c;
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
