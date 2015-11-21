import java.util.Scanner;

public class TowerOfHanoiVignu {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of disks");
		int n = in.nextInt();
		System.out.println("Q("+n+") = "+Q(n));
		System.out.println("R("+n+") = "+R(n));
		in.close();
	}
	
	private static int Q(int n) 
	{
		if (n == 0) return 0;
		if ( n == 1 ) return 1;
		return (2*R(n-1) + 1);
	}

	private static int R(int n) 
	{
		if (n == 0) return 0;
		if ( n == 1 ) return 2;
		return (Q(n) + Q(n-1) + 1);
	}


}
