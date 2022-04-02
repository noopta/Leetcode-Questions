class Solution {
    public int maxSubArray(int[] nums) {

        int currentSum = nums[0];
        int maxArraySum = currentSum;
        int right = 1;
        
        while(right < nums.length){
            currentSum = Math.max(currentSum + nums[right], nums[right]);
            maxArraySum = Math.max(maxArraySum, currentSum);
            right++;
        }
        
        
        return maxArraySum;
    }
}