import java.util.Scanner;

public class BruteForce {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		int[] input1 = new int[]{3,2,4};
		int target1 =6;
		int[] output1 = new int[2];
		int[] input2 =new int[]{0,3,2,4,0};
		int target2 =0;
		int[] output2 = new int[2];
		
		output1 = twoSum(input1,target1);
		print(output1);
		output2 = twoSum(input2,target2);
		print(output2);
		
		in.close();
		

	}
	private static void print(int[] output) {
		// TODO Auto-generated method stub
		for(int i=0;i<output.length;i++) {
			System.out.print(output[i]+"\t");
		}
		System.out.println();
	}
	public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] output= new int[2];
        for(int i=0;i<length-1;i++) {
            int j =i+1;
            while(j<length) {
                if(nums[i]+nums[j] == target) {
                    output[0] = i+1;
                    output[1] = j+1;
                    return output;
                }
                j++;
            }
        }
        return output;
    }

}
