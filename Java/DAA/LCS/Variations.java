
public class Variations {
	public static void find1(String X,String Y) {
		int m = X.length();
		int n = Y.length();
		int[][] c = new int[m][n];		
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(X.charAt(i) == Y.charAt(j)) {
					if(i != 0 && j != 0) {
						c[i][j] = c[i-1][j-1] +1;
					} else {
						c[i][j] = 1;
					}
				}
				else if(j != 0 || i !=0 ) {
					if(i == 0) {
						c[i][j] = c[i][j-1];
					}
					else if(j == 0) {
						c[i][j] = c[i-1][j];
					}
					else if(c[i][j-1] > c[i-1][j]) {
						c[i][j] = c[i][j-1];
					}
					else {
						c[i][j] = c[i-1][j];
					}
				} else {
					c[i][j]=0;
				}
			}
		}
		
		
		
		
		Print1(c,X,Y,m-1,n-1);
	}
	
	public static void Print1(int[][] c,String X,String Y,int i,int j) {
		if(i==-1 || j==-1) {
			return;
		}
		if(X.charAt(i) == Y.charAt(j)) {
			if(i==0 || j==0) {
				System.out.print(X.charAt(i)+"\t");
				System.out.println();
				return;
			}else {
				Print1(c,X,Y, i-1,j-1);
				System.out.print(X.charAt(i)+"\t");
			}
		} else if(i!=0 || j!=0) {
			if(i==0) {
				Print1(c,X,Y, i,j-1);
			}else if(j==0) {
				Print1(c,X,Y, i-1,j);
			}else if(c[i][j] == c[i][j-1]) {
				Print1(c,X,Y, i,j-1);
			} else if(c[i][j] == c[i-1][j]){
					Print1(c,X,Y,i-1,j);
			}
		} else {
			System.out.println("No sequence in common");
		}
	}

}
