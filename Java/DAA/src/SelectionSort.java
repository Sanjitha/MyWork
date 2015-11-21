import java.util.*;

public class SelectionSort {
	public static int n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the input sequence");
		int n = in.nextInt();
		int[] a= new int[n];
		System.out.println("Enter the matrix");
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
		}
		in.close();
		print("Input sequence before sorting",a);
		sort(a);
		print("Input sequence after sorting",a);
		
	}

	private static void sort(int[] a) {
		for(int i=0;i<a.length;i++) {
			int min = i;
			for(int j=i;j<a.length;j++) {
				if(a[j]<a[min]) {
					min = j;
				}
			}
			int tmp = a[min];
			a[min]=a[i];
			a[i]=tmp;
		}
	}

	private static void print(String msg,int[] a) {
		System.out.println(msg);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	
}
