import java.util.Scanner;

public class HeapSortSearch {
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
		
		print("Before Build Heap",a);
		buildMaxheap(a);
		print("After Build Heap.",a);
		for(int i1=0;i1<10;i1++) {
			System.out.println("Enter the key to be searched.");
			int k = in.nextInt();
			search(a,k);
		}
		in.close();
	}
	
	private static void search(int[] a,int k) {
		if(searchHeap(a,k,1)!= -1) {
			System.out.println("Index of "+k+"in the heap is "+searchHeap(a,k,1));
		}	else {
			System.out.println("None");
		}
	}
	public static int searchHeap(int[] a,int k,int index) {		
			
			int left = 2*index;
			int right = 2*index+1;
			if(k==a[index]) {
				return index;
			}	else if(k > a[index]) {
				return -1;
			}	else {
					if(right < a.length && searchHeap(a,k,2*index) == -1) {
						return searchHeap(a,k,2*index+1);
					}else if(left < a.length){
						return searchHeap(a,k,2*index);
					}
			}
			return -1;
		
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
