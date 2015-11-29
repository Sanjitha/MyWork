import java.util.ArrayList;
import java.util.List;

public class MatrixChainMultiply {
	public static void main(String[] args) {
		int[] p = Main.getInputNumber();
		int n = p.length -1;
		int[][] m= new int[n+1][n+1];
		int[][] s = new int[n+1][n+1];
		List<int[][]> matrixList = new ArrayList<>(); 
		MatrixChainOrder.matrix_chain_order(m, s, p, n);
		MatrixChainOrder.print_optimal(s, 1,n);
		int[][] result = matrixChainMultiply(matrixList,s,1,n);
	}
	public static int[][] matrixChainMultiply(List<int[][]> matrixList,int[][] s,int i,int j) {
		if(i == j) {
			return matrixList.get(i);
		}
		else {
			int[][] X= matrixChainMultiply(matrixList,s,i,s[i][j]);
			int[][] Y= matrixChainMultiply(matrixList,s,s[i][j]+1,j);
			return Matrix_Multiply(X,Y);
		}
		
	}
	private static int[][] Matrix_Multiply(int[][] x, int[][] y) {
		// TODO to be optimised using katasturba algorithm
		return null;
	}
}
