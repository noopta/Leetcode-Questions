class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] returnIndices = new int[2];
        int left = 0;
        int right = numbers.length - 1;
        
        while(left < right){
           if(numbers[left] + numbers[right] == target){
               returnIndices[0] = left + 1;
               returnIndices[1] = right + 1;
               break;
           } else if (numbers[left] + numbers[right] > target){
               right--;
           } else if (numbers[left] + numbers[right] < target){
               left++;
           }
        }
        
        
        return returnIndices;
    }
}