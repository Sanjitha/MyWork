import java.util.*;
public class StackImplementation {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter the size of the stack");
		int n = in.nextInt();
		
		Stack S = new Stack(n);
		S.push(5);
		S.push(15);
		S.push(2);
		S.push(8);
		S.push(67);
		S.pop();
		S.push(5);
		S.pop();		
	}

	
}

class Stack {
	public Stack(int n) {
		// TODO Auto-generated constructor stub
	}

	public void pop() {
		// TODO Auto-generated method stub
		
	}

	public void push(int i) {
		// TODO Auto-generated method stub
		
	}
}
