class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] sortedArr = new int[nums.length];
        int i = 0;
        int j = 0;
        int k = nums.length - 1;
        
        for(int num : nums){
            if(num % 2 == 0){
                sortedArr[j++] = num;
            } else {
                sortedArr[k--] = num;
            }
        }
        
        return sortedArr;
    }
}