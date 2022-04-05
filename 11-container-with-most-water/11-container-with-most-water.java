class Solution {
    public int maxArea(int[] height) {
        int maxAreaFound = 0;
        int left = 0;
        int right = height.length - 1;
        int  currentArea = 0;
        
        while(left < right){
            currentArea = Math.min(height[left], height[right]) * (right - left);
            maxAreaFound = Math.max(maxAreaFound, currentArea);
            
            if(height[left] <= height[right]){
                left++;
            } else if (height[right] < height[left]){
                right--;
            } 
        }
        
        return maxAreaFound;
    }
}