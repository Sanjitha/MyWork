import java.util.Scanner;

public class LongestIncreasingSubsequence {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the sequence");
		int n = in.nextInt();
		System.out.println("Enter the sequence X");
		int[] X = new int[n];
		for(int i=0;i<n;i++) {
			X[i] = in.nextInt();
		}		
		System.out.println("Longest Increasing Subsequence");
		//int[][] W = new int[n][n];
		int[][] T = new int[n][n];
		int[][] S = new int[n][n];
		System.out.println(find(X,T,S));	
		printSequence(X,S,0,n-1);
		in.close();
	}

	private static void printSequence(int[] X, int[][] S,int i,int j) {
		if(i < j) {
			if(S[i][j]==0) {
				System.out.print(X[i]+"\t");
				printSequence(X,S,i+1,j-1);
				System.out.print(X[j]+"\t");
			}else if(S[i][j] == 1) {
				printSequence(X,S,i+1,j);
			}else {
				printSequence(X,S,i,j-1);
			}
		}
		
	}

	private static int find(int[] X, int[][] T,int[][] S) {
		int n = X.length;
		for(int i=0;i<n;i++) {
			T[i][i] =1;
		}		
		for(int l =2;l<=n;l++) {
			for(int i=0;i<n-l+1;i++) {
				int j = i+l-1;
				if(X[i] < X[j] && j == i+1)  {
					T[i][j] = 2;
					S[i][j] = 0;
				} else if(X[i] < X[j] && X[i]<X[i+1] && X[j]>X[j-1])  {
					T[i][j] = 2+ T[i+1][j-1];
					S[i][j] = 0;
				} else {
					if(T[i+1][j]> T[i][j-1]) {
						T[i][j] = T[i+1][j];
						S[i][j] = 1;
					}else {
						T[i][j] = T[i][j-1];
						S[i][j] = -1;
					}
				}
			}
		}
		return T[0][n-1];
				
	}
}
