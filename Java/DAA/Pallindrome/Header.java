import java.util.Scanner;

public class Header {
	 public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		 System.out.println("Enter the pallindrome");
		 String input = in.nextLine();
		 System.out.println(input+" is a pallindrome : "+Pallindrome.isPallindrome(input));
	 }
}
