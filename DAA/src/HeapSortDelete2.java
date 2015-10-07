import java.util.Scanner;

public class HeapSortDelete2 {
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
		System.out.println("Enter the index to be deleted.");
		int k = in.nextInt();
		in.close();
		print("Before Build Heap",a);
		buildMaxheap(a);
		print("After Build Heap.",a);
		delete(a,k);
		print("After delete.",a);
	}
	
	private static void delete(int[] a,int k) {
		int heapsize = a.length-1;
		int largestChild = findLargest(a,k, heapsize);
		if(largestChild != 0) {
			a[k] = a[largestChild];
			delete(a,largestChild);
		} else {
			a[k] = 0;
		}
		
	}
	
	private static void buildMaxheap(int[] a) {
		int size = a.length-1;
		for(int i=size/2;i>=1;i--) {
			maxHeapify(a, i,size);
		}
	}
	
	public static int findLargest(int[] a,int i,int heapsize) {
		int left = 2*i;
		int right = (2*i)+1;
		int largest = 0;
		int heapSize = heapsize;
		
			if(left <= heapSize && right <=heapSize) {
				if(a[left] > a[right]) 
					largest = left;
				else 
					largest = right;
			} 
			else if(left <= heapsize)
				largest = left;
			else if(right <=heapSize)
				largest = right;
			return largest;
			
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
