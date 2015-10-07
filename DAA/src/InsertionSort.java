import java.util.Scanner;
public class InsertionSort {
	
	public static  int n;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the input sequence");
		n = in.nextInt();
		System.out.println("Enter the input sequence");
		int i;
		int[] a = new int[n];
		for(i=0;i<n;i++) {
			a[i] = in.nextInt();
		}
		in.close();
		print("Array before sorting",a);
		sort(a);
		print("Array after sorting",a);
	}
	
	public static void sort(int[] a) {
		
		for(int j=1;j<a.length;j++) {
			int key = a[j];
			int i  = j-1;
			while(i>=0 && a[i]>key) {
				a[i+1]=a[i];
				i=i-1;
			}
			a[i+1]=key;
		}
		
	}
	
	public static void print(String msg,int[] a) {
		System.out.println(msg);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}

}
