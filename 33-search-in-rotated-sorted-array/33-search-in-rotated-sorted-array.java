class Solution {
    public int findRotationIndex(int[] nums){
        int left = 0;
        int right = nums.length - 1;
        int midPoint = 0;
        int minValue = 0;
        
        if(nums[left] < nums[right]){
            return 0;
        }
        
        
        while(left <= right){
           
            midPoint = left + ((right - left) / 2);
            
            if(nums[midPoint] > nums[midPoint + 1]){
                minValue = midPoint + 1;
                return minValue;
            } else {
                if(nums[midPoint] < nums[left]){
                    right = midPoint - 1;
                } else {
                    left = midPoint + 1;
                }
            }    
        }

        return 0;
    }
    
    public int binarySearch(int left, int right, int[] nums, int target){
        int midPoint = 0;
        
        while(left <= right){
            midPoint = left + ((right - left) / 2);
            
            if(nums[midPoint] == target){
                return midPoint;
            } else if (nums[midPoint] > target){
                right = midPoint - 1;
            } else if (nums[midPoint] < target){
                left = midPoint + 1;
            }
        }
        return -1;
    }
    
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0] == target){
                return 0;
            } else {
                return -1;
            }
        }
        
        
        int minIndex = 0;
        int left = 0;
        int right = nums.length - 1;
        int rotationIndex = findRotationIndex(nums);
        
        
        if(nums[rotationIndex] == target){
            return rotationIndex;
        }
        
        if(rotationIndex == 0){
            return binarySearch(0, nums.length - 1, nums, target);
        }
        
        
        if(target < nums[0]){
            return binarySearch(rotationIndex, nums.length - 1, nums, target);
        }
        
        return binarySearch(0, rotationIndex, nums, target);
    }
}