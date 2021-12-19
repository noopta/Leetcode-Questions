class Solution {
    public void sortColors(int[] nums) {
        int i = 0;
        int numZeroes = 0;
        int numOnes = 0;
        int numTwos = 0;
        
        for(i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                numZeroes++;
            } else if (nums[i] == 1){
                numOnes++;
            } else {
                numTwos++;
            }
        }
        
        i = 0;
        
        while(numZeroes > 0){
            nums[i] = 0;
            numZeroes--;
            i++;
        }
        
        while(numOnes > 0){
            nums[i] = 1;
            numOnes--;
            i++;
        }
        
        while(numTwos > 0){
            nums[i] = 2;
            numTwos--;
            i++;
        }
        
    }
}