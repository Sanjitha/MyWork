
public class LongestPallindromeSubsequence {
	public static void findRecursive(String input) {
		int n = input.length();
		int[][] L = new int[n][n];
		System.out.println(LPS(input,L,0,n-1));		
	}

	private static int LPS(String input, int[][] L, int i, int j) {
		if(i == j)
			L[i][j]=1;
		else if(j==i+1 && input.charAt(i) == input.charAt(j)) {
			L[i][j]=2;
		}
		else if(input.charAt(i) == input.charAt(j)){
			L[i][j]=LPS(input,L,i+1,j-1)+2;
		}
		else {
			L[i][j]=max(LPS(input,L,i,j-1),LPS(input,L,i+1,j));
		}
		return L[i][j];	
	}

	private static int max(int i, int j) {
		if(i>j)
			return i;
		else 
			return j;
	}
	public static void findBottomUp(String input) {
		int n = input.length();
		int[][] L = new int[n][n];
		int[][] P = new int[n][n];
		System.out.println(LPSBottomUp(input,L,P,0,n-1));	
		PrintSequence(input,P,0,n-1);
	}

	private static void PrintSequence(String input, int[][] P, int i, int j) {
		if(i<j) {
			if(P[i][j] == 0) {
				System.out.print(input.charAt(i)+" ");
				PrintSequence(input,P,i+1,j-1);
				System.out.print(input.charAt(j)+" ");
			}
			else if(P[i][j] == -1) {
				PrintSequence(input,P,i,j-1);
			}
			else {
				PrintSequence(input,P,i+1,j);
			}
		}
	}

	private static int LPSBottomUp(String input, int[][] L,int[][] P, int start, int end) {
		int n = input.length();
		for(int i=0;i<n;i++){
			L[i][i] =1;
		}
		for(int l=2;l<=n;l++) {
			for(int i=0;i<n-l+1;i++) {
				
				int j = i+l-1;
				System.out.println(i+" "+j);
				if(input.charAt(i) == input.charAt(j) && j==i+1) {
					L[i][j]=2;
					P[i][j]=0;
				}
				else if( input.charAt(i) == input.charAt(j) ){
					L[i][j]=L[i+1][j-1]+2;
					P[i][j]=0;
				}
				else {
					if(L[i+1][j]> L[i][j-1]) {
						P[i][j]=1;
						L[i][j] = L[i+1][j];
					}else {
						L[i][j] = L[i][j-1];
						P[i][j]=-1;
					}
				}
			}
		}
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				System.out.print(L[i][j]+"\t");
			}
			System.out.println();
		}
		
		return L[start][end];
	}

}
