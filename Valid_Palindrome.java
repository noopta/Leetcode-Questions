class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = 0;
//         parse string first
//         get only the alphanumeric values
        
        String parsedString = "";
        
        for(i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                parsedString += s.charAt(i);
            } else if (Character.isLetter(s.charAt(i))){
                
                parsedString += Character.toLowerCase(s.charAt(i));
            }
        }
        
        i = 0;
        j = parsedString.length() - 1;
        
        while(i < j){
            if(parsedString.charAt(i) != parsedString.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}