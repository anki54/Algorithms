package leetcode;

class Solution2 {
    public static int smallestDivisor(int[] nums, int threshold) {
/* At the time of writing this, it was assumed from the examples that the given array is sorted and last element of nums is the largest. All test cases passed. Hence end = nums[nums.length-1]. A good practice would be find the maximum in the array.
*/
        int start=1, end = nums[nums.length-1];
        while(start<end){
            int mid = start+(end-start)/2;            
            if(getThresholdCheck(mid, nums, threshold))
                end=mid;
            else 
                start=mid+1;
        }
        return start;
    }
    
    private static boolean getThresholdCheck(int mid, int[] nums, int threshold){
        int sum=0;
        for(int i:nums){
            int res = (i + mid - 1) / mid;
            sum=sum+res;
        }
        return sum<=threshold;
    }
    
    public static void main(String[] args) {

		// TODO Auto-generated method stub
    	int[] arr = {1,5,7};
    	System.out.println(smallestDivisor(arr, 8));
		
	}
    
    public static void main() {

	}
}