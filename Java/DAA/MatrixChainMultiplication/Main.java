import java.util.Scanner;

public class Main {
	public static int[] getInputNumber() {
		System.out.println("Enter the number of matrices");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		System.out.println("Enter the sequence of dimensions");
		int[] p = new int[n+1];
		for(int i=0;i<n+1;i++) {
			p[i]= in.nextInt();
		}
		in.close();
		return p;		
	}
}
