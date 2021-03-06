import java.util.Scanner;

public class HeapSort {
	static int n;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the input sequence.");
		n = in.nextInt();
		System.out.println("Enter the input sequence.");
		int i;
		int[] a = new int[n+1];
		for(i=1;i<=n;i++) {
			a[i] = in.nextInt();
		}
		in.close();
		print("Heap before sorting",a);
		sort(a);
		print("Heap after sorting.",a);
	}
	
	private static void sort(int[] a) {
		buildMaxheap(a);
		int heapsize = a.length-1;
		for(int i=a.length-1 ;i>=2;i--) {
			swap(a,1,i);
			heapsize = heapsize-1;
			maxHeapify(a, 1,heapsize);
		}
	}
	
	private static void buildMaxheap(int[] a) {
		int size = a.length-1;
		for(int i=size/2;i>=1;i--) {
			maxHeapify(a, i,size);
		}
	}
	
	public static void maxHeapify(int[] a,int i,int heapsize) {
		int left = 2*i;
		int right = (2*i)+1;
		int largest;
		int heapSize = heapsize;
		
			if(left <= heapSize && a[left] > a[i])
				largest = left;
			else 
				largest = i;
			
			if(right <=heapSize && a[right] > a[largest])
				largest = right;
			
			if(largest != i) {
				swap(a,i,largest);
				maxHeapify(a,largest,heapsize);
			}
		
	}
	
	public static void swap(int[] a,int i, int j) {
		a[i] = a[i]+a[j];
		a[j] =a[i]-a[j];
		a[i] = a[i]-a[j];		
	}
	
	
	public static void print(String msg,int[] a) {
		System.out.println(msg);
		for(int i=1;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
		
	}
	
	
}
