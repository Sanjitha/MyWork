package Fibonacci;
import java.util.*;

/*The Fibonacci numbers are defined by recurrence (3.22). Give an O.n/-time
dynamic-programming algorithm to compute the nth Fibonacci number. Draw the
subproblem graph. How many vertices and edges are in the graph?
*/

public class Main {
	public static int getInputNumber() {
		System.out.println("Enter the term for which the number.");
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		in.close();
		return n;		
	}
}

