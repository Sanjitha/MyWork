import java.util.Scanner;

public class Header {
	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter the pallindrome");
		 String input = in.nextLine();
		 System.out.println(input+" is a pallindrome method 1: "+Pallindrome.isPallindrome1(input));
		 System.out.println(input+" is a pallindrome method 2: "+Pallindrome.isPallindrome2(input));
		 System.out.println("All the pallindromes of a given string method1");
		 AllPallindromes.find1(input);
		 System.out.println("All the pallindromes of a given string method2");
		 AllPallindromes.find2(input);
		 System.out.println("Longest Pallindrome Subsequence of a given string");
		 LongestPallindromeSubsequence.findRecursive(input);
		 System.out.println("Longest Pallindrome Subsequence of a given string");
		 LongestPallindromeSubsequence.findBottomUp(input);
	 }
}
