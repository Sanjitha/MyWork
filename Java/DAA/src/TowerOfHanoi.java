import java.util.*;
public class TowerOfHanoi {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the no. of disks");
		int n = in.nextInt();
		towerOfHanoi(n,"A","C","B");
		in.close();
	}

	private static void towerOfHanoi(int n, String from, String to, String using) {
		if(n>0) {
			towerOfHanoi(n-1,from,using,to);
			System.out.println("Transfer "+n +" from "+ from +" to "+to);
			towerOfHanoi(n-1,using,to,from);
		}
	}
}
