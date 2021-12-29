class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        PriorityQueue<Integer> squaredValues = new PriorityQueue<Integer>();

        for (i = 0; i < nums.length; i++) {
            double tempDouble = (double) nums[i];
            squaredValues.add((int) Math.pow(tempDouble, 2));
        }

        i = 0;

        while (squaredValues.size() > 0) {
            nums[i] = squaredValues.poll();
            i++;
        }

        return nums;
    }
}