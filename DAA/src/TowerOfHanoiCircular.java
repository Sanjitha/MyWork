import java.util.*;
public class TowerOfHanoiCircular {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of disks");
		int n = in.nextInt();
		towerOfHanoi(n,"A","B","C");
		in.close();
	}

	private static void towerOfHanoi(int n, String from, String using, String to) {
		if(n>0) {
			towerOfHanoi(n-1,from,using,to);
			System.out.println("Move "+n+" from "+from+" to "+using);
			if(n-1 > 0) {
				System.out.println("Move "+(n-1)+" from "+to+" to "+from);
			}
			System.out.println("Move "+n+" from "+using+" to "+to);
			towerOfHanoi(n-1,from,using,to);
		}
	}
}
