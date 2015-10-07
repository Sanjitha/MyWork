import java.util.Scanner; 

public class MaxHeapify {
	static int n;
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the input sequence");
		n = in.nextInt();
		System.out.println("Enter the input sequence");
		int i;
		int[] a = new int[n+1];
		for(i=1;i<=n;i++) {
			a[i] = in.nextInt();
		}
		in.close();
		print("Heap before calling heapify",a);
		maxHeapify(a,2);
		print("Heap after calling heapify",a);
		
	}
	
	public static void maxHeapify(int[] a,int i) {
		int left = 2*i;
		int right = (2*i)+1;
		int largest;
		int heapSize = a.length -1;
		System.out.println(i+"  "+right+" sd "+a[10]);
		
			if(left <= heapSize && a[left] > a[i])
				largest = left;
			else 
				largest = i;
			
			if(right <=heapSize && a[right] > a[largest])
				largest = right;
			
			if(largest != i) {
				swap(a,i,largest);
				maxHeapify(a,largest);
			}
		
	}
	
	public static void swap(int[] a,int i, int j) {
		a[i] = a[i]+a[j];
		a[j] =a[i]-a[j];
		a[i] = a[i]-a[j];		
	}
	public static void print(String msg,int[] a) {
		System.out.println(msg);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	
	
}
