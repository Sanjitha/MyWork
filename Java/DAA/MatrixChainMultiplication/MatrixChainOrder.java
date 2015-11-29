
public class MatrixChainOrder {
	
	public static void main(String[] args) {
		int[] p = Main.getInputNumber();
		int n = p.length -1;
		int[][] m= new int[n+1][n+1];
		int[][] s = new int[n+1][n+1];
		matrix_chain_order(m,s,p,n);
		print_optimal(s,1,n);
	}
	public static void matrix_chain_order(int[][] m,int[][] s,int[] p,int n) {
		
		for(int i=1;i<=n;i++)
			m[i][i] = 0;
		for(int l =2;l<=n;l++) {
			for(int i=1;i<=n-l+1;i++) {
				int j=i+l-1;
					m[i][j] = (int) Double.POSITIVE_INFINITY;
					for(int k=i;k<=j-1;k++) {
						int q = m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
						if(q < m[i][j] ) {
							m[i][j] = q;
							s[i][j] = k;
							}
					}
				}
			
		}
		for(int i=0;i<=n;i++) {
			for(int j=0;j<=n;j++) {
				System.out.print(m[i][j]+"\t");
			}
			System.out.println("");
		}
	}
	public static void print_optimal( int[][] s, int i, int j) {
		if(i == j) {
			System.out.print("A"+i);
		}else {
			System.out.print("(");
			print_optimal(s,i,s[i][j]);
			print_optimal(s,s[i][j]+1,j);
			System.out.print(")");
		}
		
	}
}
