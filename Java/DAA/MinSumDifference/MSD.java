import java.util.Scanner;

public class MSD {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of pair of Skis");
		int m = in.nextInt();
		System.out.println("Enter the number of Skiers");
		int n = in.nextInt();
		System.out.println("Enter the heights of each ski");
		int[] S = new int[m+1];
		for(int i=1;i<=m;i++) {
			S[i] = in.nextInt();
		}
		System.out.println("Enter the heights of each skier");
		int[] H = new int[n+1];
		for(int i=1;i<=n;i++) {
			H[i] = in.nextInt();
		}
		System.out.println("Assignment of skis to skiers");
		pairUp(S,H,m,n);
	}

	private static void pairUp(int[] S, int[] H, int m, int n) {
		if(m == n) {
			int[] sTmp = S;
			int[] hTmp = H;
			
			BubbleSort.sort(sTmp);
			BubbleSort.sort(hTmp);
			for(int i=0;i<n;i++) {
				System.out.println("The person with height "+sTmp[i]+" uses  the ski with height "+hTmp[i]);
			}
		}else {
			int[] sTmp = S;
			int[] hTmp = H;
			BubbleSort.sort(sTmp);
			System.out.println("Sorted S");
			for(int i=1;i<=n;i++) {
				System.out.print(sTmp[i]+"\t");
			}
			BubbleSort.sort(hTmp);
			System.out.println("Sorted H");
			for(int i=1;i<=n;i++) {
				System.out.print(hTmp[i]+"\t");
			}
			System.out.println();
			
			int[][] T = new int[n+1][m+1];
			for(int i=0;i<=m;i++) {
				T[0][i] = 0;
			}
			for(int i=1;i<=n;i++) {
				for(int j=0;j<=n;j++) {
					T[i][j] = (int) Double.POSITIVE_INFINITY;
				}
			}
			int[] assign = new int[n+1];
			for(int i=1;i<=n;i++) {	
				
				for(int j=i;j<=i+m-n;j++) {
						if(Math.abs(H[i]-S[j])+T[i-1][j-1] > T[i][j-1]) {
							T[i][j] = T[i][j-1];
						}else {
							T[i][j] = Math.abs(H[i]-S[j]) + T[i-1][j-1];
							assign[i] =j;
						}					
				}
				
			}
			

			for(int i=0;i<=n;i++) {
				for(int j=0;j<=m;j++) {
					System.out.print(T[i][j]+"\t");
				}
				System.out.println();
			}
			for(int i=1;i<=n;i++) {
				System.out.print(assign[i]+"\t");			
			}
		}
		
	}
}
