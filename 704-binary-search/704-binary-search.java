class Solution {
    
    public int binarySearch(int[] nums, int left, int right, int target){
        if(left > right){
            return -1;
        }
        
        int midPoint = left + ((right - left) / 2);
        
        if(nums[midPoint] == target){
            return midPoint;
        } else if (nums[midPoint] < target){
            return binarySearch(nums, midPoint + 1, right, target);
        } else if (nums[midPoint] > target){
            return binarySearch(nums, left, midPoint - 1, target);
        }
        
        return - 1;
    }
    
    public int search(int[] nums, int target) {
        return binarySearch(nums, 0, nums.length - 1, target);
    }
}