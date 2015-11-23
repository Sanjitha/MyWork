package Fibonacci;

public class NonRecursiveTopDown {
	public static void main(String args[]) {
		int n = Main.getInputNumber();
		int[] f = new int[n];
		f[0]=0;
		f[1]=1;
		for(int i=2;i<n;i++) {
			f[i] = f[i-1] + f[i-2];
		}
		System.out.println("Fibonacci Numbers");
		for(int i=0;i<n;i++) {
			System.out.print(f[i]+" ");
		}
	}
}
