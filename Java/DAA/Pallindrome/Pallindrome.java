
public class Pallindrome {
	public static boolean isPallindrome(String input) {
		int i=0;
		int length = input.length();
		int j = length-1;
		boolean flag = true;
		while(i<= length/2 && j >= length/2) {
			if(input.charAt(i) != input.charAt(j)) {
				flag = false;
				break;
			}
			i++;
			j--;
		}
		if(flag)
			return true;
		else 
			return false;
	}
}
