
public class Pallindrome {
	public static boolean isPallindrome1(String input) {
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
	public static boolean isPallindrome2(String input) {
		int length = input.length();
		
		//delimiter
		input = "#"+input;
		boolean isEven = isEven(length);
		
		if(isEven) {
			int i = length/2;
			int j = i+1;
			while(i>0 && j <= length) {
				if(input.charAt(i) != input.charAt(j)) {
					return false;
				}
				i--;
				j++;
			}
			return true;
		} else {
			int i = length/2 +1;
			int n = length/2;
			while(n>0) {
				if(input.charAt(i-1) != input.charAt(i+1)) {
					return false;
				}
				n--;
			}
			return true;
		}
		
	}
	private static boolean isEven(int length) {
		if(length%2 ==0)
			return true;
		else 
			return false;
	}
}
