class Solution {

    public void mergeSort(int[] nums) {
        int arrayLen = nums.length;

        if (arrayLen < 2) {
            return;
        }

        int midPoint = arrayLen / 2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[arrayLen - midPoint];
        int i = 0;
        int j = 0;

        for (i = 0; i < midPoint; i++) {
            leftArray[i] = nums[i];
        }

        for (i = midPoint; i < arrayLen; i++) {
            rightArray[j] = nums[i];
            j++;
        }

        mergeSort(leftArray);
        mergeSort(rightArray);
        merge(leftArray, rightArray, nums);
    }

    public void merge(int[] leftArray, int[] rightArray, int[] originalArray) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                originalArray[k] = leftArray[i];
                i++;
            } else if (rightArray[j] < leftArray[i]) {
                originalArray[k] = rightArray[j];
                j++;
            }

            k++;
        }

        while (i < leftArray.length) {
            originalArray[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightArray.length) {
            originalArray[k] = rightArray[j];
            j++;
            k++;
        }
    }

    public int longestConsecutive(int[] nums) {
        // this can be good practice for a sorting algorithm
        // learn merge sort
        int i = 0;
        int maxCount = 1;
        int localCount = 1;

        if (nums.length == 0) {
            return 0;
        }

        mergeSort(nums);

        for (i = 1; i < nums.length; i++) {
            if (nums[i] == (nums[i - 1] + 1)) {
                System.out.println(localCount);
                localCount++;
                if (localCount > maxCount) {
                    maxCount = localCount;
                }
            } else if (!(nums[i] == nums[i - 1])) {
                localCount = 1;
            }
        }

        return maxCount;
    }
}
