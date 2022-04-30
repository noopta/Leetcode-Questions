class Solution {
    public int longestMountain(int[] arr) {
        int mountainLen = 0;
        int peak = 0;
        int valley = 0;
        boolean peakFound = false;
        boolean valleyFound = false;
        int i = 0;
        int startIndex = 0;
        
        while(i < arr.length - 1){
            if(arr[i] < arr[i + 1]){
                
                startIndex = i;
    
                while(i < arr.length - 1 && arr[i] < arr[i + 1]){
                    peakFound = true;
                    i++;
                }
                
                while(i < arr.length - 1 && arr[i] > arr[i + 1]){
                    valleyFound = true;
                    i++;
                }
                
                if(peakFound && valleyFound){
                    mountainLen = Math.max(mountainLen, i - startIndex + 1);
                }
                
                peakFound = false;
                valleyFound = false;
                
            } else {
                i++;
            }
        }
        
        
        return mountainLen;
    }
}