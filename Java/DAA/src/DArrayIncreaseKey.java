import java.util.Scanner; 

public class DArrayIncreaseKey {
	static int n;
	static int d;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the input sequence");
		n = in.nextInt();
		System.out.println("Enter the input sequence");
		
		int[] a = new int[n];
		for(int j=0;j<n;j++) {
			a[j] = in.nextInt();
		}
		System.out.println("Enter the value d");
		d = in.nextInt();
		System.out.println("Enter the key");
		int k = in.nextInt();
		System.out.println("Enter the index which is to be increased.");
		int i = in.nextInt();
		in.close();
		print("Heap before calling heapify",a);
		increaseKey(a,i,k);
		print("Heap after calling heapify",a);
		
	}
	
	private static void increaseKey(int[] a, int i, int k) {
		
		if(k>a[i]) {
			a[i] =k;
			bubbleUp(a,i);
		}else {
			System.out.println("Error");
		}
	}

	public static void bubbleUp(int[] a,int i) {	
		int parent = parent(i);
		int largest = parent;
		if(parent!= i && parent >=0 && a[largest] < a[i]) {
			largest = i;
		}
		if(largest != parent) {
			swap(a,parent,largest);
			bubbleUp(a,parent);
		}
		
	}
	
	private static int parent(int i) {
		return (i-1)/d;
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
