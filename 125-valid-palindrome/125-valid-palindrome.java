class Solution {
    public boolean isPalindrome(String s) {
        String parsedString = "";
        int i = 0;
        int left = 0;
        int right = 0;
        
        for(i = 0; i < s.length(); i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                parsedString += Character.toLowerCase(s.charAt(i));
            }
        }
        
        right = parsedString.length() - 1;
        
        while(left < right){
            if(parsedString.charAt(left) != parsedString.charAt(right)){
                return false;
            } else {
                left++; 
                right--;
            }
        }
        
        return true;
    }
}