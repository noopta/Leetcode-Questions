class Solution {
    public int titleToNumber(String columnTitle) {
        int returnValue = 0;
        int i = 0;
        int j = 0;
        
        for(i = columnTitle.length() - 1; i >= 0; i--){
            returnValue += ((int)columnTitle.charAt(i) - 64) * Math.pow(26, j);
            j++;
        }
        
        return returnValue;
    }
}