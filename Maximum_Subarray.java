class Solution {
    public int maxSubArray(int[] nums) {
        int globalSum = 0;
        int currentSum = 0;
        int i = 0;

        if (nums.length != 0) {
            globalSum = nums[0];
            currentSum = nums[0];
        }

        for (i = 1; i < nums.length; i++) {
            if (nums[i] >= currentSum + nums[i]) {
                currentSum = nums[i];
            } else if (nums[i] + currentSum > nums[i]) {
                currentSum += nums[i];
            }

            globalSum = Math.max(globalSum, currentSum);
        }

        return globalSum;
    }
}