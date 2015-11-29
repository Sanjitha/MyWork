import java.util.Scanner;

public class LongestCommonSubsequence {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the sequence X");
		String X = in.nextLine();
		System.out.println("Enter the sequence Y");
		String Y = in.nextLine();
		System.out.println("LCS");
		Utils.find(X, Y);
		System.out.println("LCS with variation1");
		Variations.find1(X, Y);
		in.close();
	}

}
