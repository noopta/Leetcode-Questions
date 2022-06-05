class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()){
            return false;
        }
        
        int []s1Map = new int[26];
        int []s2Map = new int[26];
        int i = 0;
        int left = 0;
        int right = s1.length();
        int numMatches = 0;
        
        for(i = 0; i < s1.length(); i++){
            s1Map[(int)(s1.charAt(i)) - 97]++;
            s2Map[(int)(s2.charAt(i)) - 97]++;
        }
        
        for(i = 0; i < 26; i++){
            if(s1Map[i] == s2Map[i]){
                numMatches++;
            }
        }
        
        while(numMatches != 26 && right < s2.length()){
           
            s2Map[(int)(s2.charAt(right)) - 97]++;
            
            if(s2Map[(int)(s2.charAt(right)) - 97] == (s1Map[(int)(s2.charAt(right)) - 97])){
                numMatches++; 
            } else if (s2Map[(int)(s2.charAt(right)) - 97] - 1== (s1Map[(int)(s2.charAt(right)) - 97])){
                numMatches--;
            }
            
            s2Map[(int)(s2.charAt(left)) - 97]--;
            if(s2Map[(int)(s2.charAt(left)) - 97] == (s1Map[(int)(s2.charAt(left)) - 97])){
                numMatches++;
            } else if (s2Map[(int)(s2.charAt(left)) - 97] == (s1Map[(int)(s2.charAt(left)) - 97]) - 1){
                numMatches--;
            }
            
            left++;
            right++;
        }
        
        if(numMatches == 26){
            return true;
        }
        
        return false;
    }
}