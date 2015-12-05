import java.util.Scanner;

public class LongestDecreasingSubsequence {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the sequence");
		int n = in.nextInt();
		System.out.println("Enter the sequence X");
		int[] X = new int[n];
		for(int i=0;i<n;i++) {
			X[i] = in.nextInt();
		}
		System.out.println("Enter the weights of sequence X");
		int[] W = new int[n];
		for(int i=0;i<n;i++) {
			W[i] = in.nextInt();
		}
		System.out.println("Longest Decreasing Subsequence");
		int[] L = new int[n];
		find(X,L,W);
		in.close();
	}

	
	private static void find(int[] X, int[] L,int[] W) {
		int n = X.length;
		String[] output = new String[X.length];
		for ( int i = 0; i < n; i++ ) {
			L[i] = 1;
			output[i] = "";
		}	
		output[0] = String.valueOf(X[0]);
		int max =0;
		int index=0;
		int[] SumWeights = new int[n];
		SumWeights[0] = W[0];
		for(int i =0;i<n;i++) {
			for(int j=0;j<i;j++) {
				if(X[j]>X[i] && SumWeights[i]<W[i] + SumWeights[j]) {
					L[i] = 1+ L[j];
					output[i] = output[j] + String.valueOf(X[i]);
					SumWeights[i] = W[i] + SumWeights[j];
				}
			}
			
			if(max < SumWeights[i]) {
				index =i;
				max = SumWeights[i];
			}
		}
		System.out.println(output[index]+" "+max);
		
				
	}
}
