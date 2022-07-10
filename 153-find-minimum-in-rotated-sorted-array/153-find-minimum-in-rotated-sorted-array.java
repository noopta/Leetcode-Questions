class Solution {
    public int findMin(int[] nums) {
        int minValue = 0;
        int left = 0;
        int right = nums.length - 1;
        int midPoint = 0;
        
        if(nums[left] < nums[right] || nums.length == 1){
            return nums[0];
        }
        
        while(left < right){
            midPoint = left + ((right - left) / 2);
            
            if(nums[midPoint] > nums[midPoint + 1]){
                return nums[midPoint + 1];
            }
            
            if(nums[midPoint - 1] > nums[midPoint]){
                return nums[midPoint];
            }
            
            if(nums[midPoint] > nums[left]){
                left = midPoint + 1;
            } else if (nums[midPoint] < nums[left]){
                right = midPoint - 1;
            }
            
        }
        
        
        
        return minValue;
    }
}