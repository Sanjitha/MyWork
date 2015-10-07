import java.util.Scanner;

public class HeapKLargestElement {
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
		
		System.out.println("Enter the kth value for which the kth largest element is to be found.");
		int k = in.nextInt();
		System.out.println("Enter the value that is to be compared.");
		int x = in.nextInt();
		findKLargest(a,k,x);
		in.close();
	}
	
	private static void findKLargest(int[] a,int k,int x) {
		print("Before Build Heap",a);
		buildMaxheap(a);
		print("After Build Heap.",a);
		int j=k;
		int heapsize= a.length -1;
		//int i = heapsize/2;
		int i = 1;
		//while (j>0 && i>=1)
		while (j>0 && i<=heapsize)
		{
			swap(a,i,heapsize);
			heapsize=heapsize-1;
			maxHeapify(a, i,heapsize);
			j=j-1;
			i=i+1;
		}
		System.out.println(a.length+" "+heapsize+" "+k+" "+a[a.length - k]);
		int kLargest = a[a.length - k];
		if(kLargest >= x)
			System.out.println("Yes");
		else 
			System.out.println("No");
		
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
