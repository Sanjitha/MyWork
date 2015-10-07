import java.util.Scanner; 

public class DArrayMaxHeapify {
	static int n;
	static int d;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the input sequence");
		n = in.nextInt();
		System.out.println("Enter the input sequence");
		int i;
		int[] a = new int[n];
		for(i=0;i<n;i++) {
			a[i] = in.nextInt();
		}
		System.out.println("Enter the value d");
		d = in.nextInt();
		in.close();
		print("Heap before calling heapify",a);
		maxHeapify(a,0);
		print("Heap after calling heapify",a);
		
	}
	
	public static void maxHeapify(int[] a,int i) {
		int largest = 0;
		int heapSize = a.length-1;
		if(!isALeafNode(a,i)) {
			int largestChild = largestChild(a,i);
			//System.out.println(i+"  "+child+" sd "+a[child]);
				if(largestChild <= heapSize && a[largestChild] > a[i])
					largest = largestChild;
				else 
					largest = i;
		
			if(largest != i) {
				swap(a,i,largest);
				maxHeapify(a,largest);
			}
		}
	}
	
	private static boolean isALeafNode(int[] a, int i) {
		if(child(i,1) > a.length-1)
			return true;
		else 
			return false;
	}

	public static int largestChild(int[] a,int i) {
			int largest = child(i,1);
			int heapSize = a.length-1;
			for(int k=2;k<=d;k++) {
				int child = child(i,k);
				//System.out.println(i+"  "+child+" sd "+a[child]);
					if(child <= heapSize && a[child] > a[largest])
						largest = child;
			}
			return largest;
	}
	
	public static void swap(int[] a,int i, int j) {
		a[i] = a[i]+a[j];
		a[j] =a[i]-a[j];
		a[i] = a[i]-a[j];		
	}
	public static int child(int i,int childCount) {
		return d*i + childCount;		
	}
	
	public static void print(String msg,int[] a) {
		System.out.println(msg);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	
	
}
