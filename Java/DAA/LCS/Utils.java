
public class Utils {
	public static void find(String X,String Y) {
		int m = X.length();
		int n = Y.length();
		int[][] c = new int[m][n];		
		String[][] b = new String[m][n];
		String Z = new String();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(X.charAt(i) == Y.charAt(j)) {
					if(i != 0 && j != 0) {
						c[i][j] = c[i-1][j-1] +1;
						b[i][j] = "equal";
					} else {
						c[i][j] = 1;
						b[i][j] = "equal";
					}
				}
				else if(j != 0 || i !=0 ) {
					if(i == 0) {
						c[i][j] = c[i][j-1];
						b[i][j] = "smallerY";
					}
					else if(j == 0) {
						c[i][j] = c[i-1][j];
						b[i][j] = "smallerX";
					}
					else if(c[i][j-1] > c[i-1][j]) {
						c[i][j] = c[i][j-1];
						b[i][j] = "smallerY";
					}
					else {
						c[i][j] = c[i-1][j];
						b[i][j] = "smallerX";
					}
				} else {
					c[i][j]=0;
					b[i][j] = "";
				}
			}
		}
		
		
		Print(b,X,m-1,n-1);
	}
	
	public static void Print(String[][] b,String X,int i,int j) {
		if(i==-1 || j==-1) {
			return;
		}
		if(b[i][j] == "equal") {
			if(i==0 || j==0) {
				System.out.print(X.charAt(i)+"\t");
				System.out.println();
				return;
			}else {
				Print(b,X,i-1,j-1);
				System.out.print(X.charAt(i)+"\t");
			}
		} else if(b[i][j] == "smallerY") {
				Print(b,X,i,j-1);
		} else if(b[i][j] == "smallerX"){
				Print(b,X,i-1,j);
		} else {
			System.out.println("No sequence in common");
		}
		
	}

}
