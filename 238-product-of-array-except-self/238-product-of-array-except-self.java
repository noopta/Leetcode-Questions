class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArray = new int[nums.length];
        int[] suffixArray = new int[nums.length];
        int[] returnArray = new int[nums.length];
        int i = 0;
        
        prefixArray[0] = 1;
        for(i = 1; i < nums.length; i++){
            prefixArray[i] = nums[i - 1] * prefixArray[i - 1];
        }
        
        suffixArray[nums.length - 1] = 1;
        
        for(i = nums.length - 2; i >= 0; i--){
            suffixArray[i] = nums[i + 1] * suffixArray[i + 1];
        }
        
        for(i = 0; i < nums.length; i++){
            returnArray[i] = prefixArray[i] * suffixArray[i];
        }
        
        return returnArray;
    }
}