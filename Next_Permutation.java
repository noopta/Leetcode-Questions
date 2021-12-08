class Solution {
    public void nextPermutation(int[] nums) {
        int i = 0;
        int j = 0;

        for (i = nums.length - 1; i >= 1; i--) {
            if (nums[i - 1] < nums[i]) {
                break;
            }
        }

        j = nums.length - 1;

        if ((i - 1) == -1) {
            Arrays.sort(nums);
        } else {
            while (j >= 0 && nums[j] <= nums[i - 1]) {
                j--;
            }

            swap(nums, i - 1, j);
            reverse(nums, i, nums.length - 1);
        }

    }

    public void swap(int[] nums, int i, int j) {
        System.out.println("SWAPPING : " + nums[i] + " " + nums[j]);
        int tempValue = nums[i];
        nums[i] = nums[j];
        nums[j] = tempValue;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            System.out.println("REVERSING " + nums[i] + " " + nums[j]);
            int tempInt = nums[i];
            nums[i] = nums[j];
            nums[j] = tempInt;
            i++;
            j--;
        }
    }
}