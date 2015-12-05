import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class AllPallindromes {
	//Time complexity - O(N^2)  Space Complexity - O(N^2) 
	static ArrayList<Object> A1 = new ArrayList<Object>();
	public static void find1(String input) {
		int n = input.length();
		int maxLength = 0;
		boolean[][] table = new boolean[n][n];
		for(boolean[] row : table) {
			Arrays.fill(row, false);
		}
		for(int i=0;i<n;i++) {
			table[i][i]= true;
			maxLength =1;
			if(!A1.contains(input.charAt(i)))
				A1.add(input.charAt(i));
		}
		for(int i=0;i<n-1;i++) {
			if(input.charAt(i) == input.charAt(i+1)) {
				table[i][i+1] = true;
				maxLength =2;
				if(!A1.contains(input.substring(i,i+2)))
					A1.add(input.substring(i,i+2));
			}
		}
		for(int len=3;len<=n;len++) {
			for(int i=0;i<n-len+1;i++) {
				int j = i+len-1;
				if(input.charAt(i) == input.charAt(j) && table[i+1][j-1]) {
					table[i][j] = true;
					maxLength =len;
					if(!A1.contains(input.substring(i,j+1)))
						A1.add(input.substring(i,j+1));
				}
			}
		}	
		System.out.println(maxLength);
		print();
	}
	private static void print() {
		Iterator<Object> I = A1.iterator();
		while(I.hasNext()){
			System.out.println(I.next());
		}
		
	}
	//Time complexity - O(N^2) and Space Complexity - O(1)
	public static void find2(String input) {
		int n = input.length();
		if(n == 0) return;
		String longest = input.substring(0, 1);
		for(int i=0;i<n-1;i++) {
			String p1 = expandFromCentre(input, i,i);
			if(p1.length() > longest.length()) 
				longest = p1;
			
			
			String p2= expandFromCentre(input, i,i+1);
			if(p2.length() > longest.length())
				longest = p2;
			
		}
		System.out.println(longest.length());
		print();
	}
	private static String expandFromCentre(String input,int i, int j) {
		int n = input.length();
		
		while(i>=0 && j<=n-1 && input.charAt(i) == input.charAt(j)) {
			if(!A1.contains(input.substring(i,j+1)))
				A1.add(input.substring(i,j+1));
			i--;
			j++;
		}
		if((i+1)>(j-1-i))
			return "";
		else 
			return input.substring(i+1,j-1-i);
	}
}
