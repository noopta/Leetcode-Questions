public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int globalLen = 0;
        int left = 0;
        int right = 0;
        int numberOfZeroes = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                numberOfZeroes++;
            }

            while (numberOfZeroes == 1) {
                globalLen = Math.max(globalLen, right - left);

                if (nums[left] == 0) {
                    numberOfZeroes--;
                }
                left++;
            }

            right++;
        }

        if (numberOfZeroes < 1) {
            globalLen = Math.max(globalLen, right - left);
        }

        return globalLen;
    }
}