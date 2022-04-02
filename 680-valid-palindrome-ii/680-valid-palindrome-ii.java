class Solution {
    
    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length() - 1;
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            
            left++;
            right--;
        }
        
        System.out.println();
        
        return true;
    }
    
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        int charsDeleted = 0;
        StringBuilder tempString = new StringBuilder(s);
        
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                if(isPalindrome(tempString.substring(left + 1, right + 1)) || isPalindrome(tempString.substring(left, right))){
                    return true;
                } else {
                    return false;
                }
            }
            
            left++;
            right--;
        }
        
        
        return true;
    }
}