class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    
    public int binarySearch(int[] nums, int left, int right){
        while(left < right){
            int midPoint = left + ((right - left) / 2);
            
            if(nums[midPoint] < nums[midPoint + 1]){
                left = midPoint + 1;
            } else {
                right = midPoint;
            }
        }
        
        return left;
    }
}