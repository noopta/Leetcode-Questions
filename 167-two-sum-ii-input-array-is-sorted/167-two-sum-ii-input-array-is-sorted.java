class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] indicesFound = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        int midPoint = 0;
        
        while(left < right){
            if(numbers[left] + numbers[right] == target){
                indicesFound[0] = left + 1;
                indicesFound[1] = right + 1;
                break;
            } else {
                if(numbers[left] + numbers[right] > target){
                    right--;
                } else {
                    left++;
                }
            }
        }

        return indicesFound;
    }
}