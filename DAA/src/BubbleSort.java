import java.util.Scanner;
public class BubbleSort {
	public static int n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the input sequence");
		n = in.nextInt();
		int[] a =new int[n];
		System.out.println("Enter the input sequence");
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
		}
		in.close();
		print("Array before sorting",a);
		sort(a);
		print("Array after sorting",a);
	}
	private static void sort(int[] a) {
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n-1-i;j++) {
				if(a[j]>a[j+1]) {
					a[j]=a[j]+a[j+1];
					a[j+1]=a[j]-a[j+1];
					a[j]=a[j]-a[j+1];
				}
			}
		}
		
	}
	private static void print(String msg, int[] a) {
		System.out.println(msg);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
}
