import java.util.*;
//Not working
public class QuickSort {
	public static int n;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the length of the input sequence");
		n = in.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the input sequence");
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
		}
		
		in.close();
		print("Input sequence before sorting",a);
		sort(a,0,n-1);
		print("Input sequence after sorting",a);
		
	}
	private static void print(String msg,int[] a) {
		System.out.println(msg);
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
	}
	private static void sort(int[] a,int left,int right) {
		int partition = partition(a,left,right);
		System.out.println(partition+" "+left+" "+right);
		if(left < partition)
			sort(a,left,partition-1);
		if(right > partition)
			sort(a,partition,right);
	}
	private static int partition(int[] a, int left, int right) {
		//System.out.println(left+" "+right+" "+left+right/2);
		int index = left+right/2;
		int pivot = a[index];
		int i = left;
		int j = right;
		while(i<j) {
			
			while(a[i]< pivot)
				i++;
			while(a[j]>pivot)
				j--;
			if(i<j) {
			int tmp=a[i];
			a[i]=a[j];
			a[j]=tmp;
			i++;
			j--;
			}
		}
		return i;
	}

}
