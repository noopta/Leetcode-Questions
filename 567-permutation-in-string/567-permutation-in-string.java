class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // create two maps, one for s1 and one for s2 with their character frequencies
        // iterate through s2 with a window of s1.length
        // adjust the number of matches for each character removed and added
        // when the number of matches == 26, then return true
        // else return false
        if(s1.length() > s2.length()){
            return false;
        }
        
        int[] s1Map = new int[26];
        int[] s2Map = new int[26];
        int i = 0;
        int numMatches = 0;
        int right = s1.length();
        int left = 0;
        
        for(i = 0; i < 26; i++){
            s1Map[i] = 0;
            s2Map[i] = 0;
        }
        
        for(i = 0; i < s1.length(); i++){
            int charIndex = (int)(s1.charAt(i)) - 97;
            int s2CharIndex = (int)(s2.charAt(i)) - 97;
            
            s1Map[charIndex]++;
            s2Map[s2CharIndex]++;
        }
        
        for(i = 0; i < 26; i++){
            if(s2Map[i] == s1Map[i]){
                numMatches++;
            }
        }
        
        /*
                    if matches == 26: return True
            
            index = ord(s2[r]) - ord('a')
            s2Count[index] += 1
            if s1Count[index] == s2Count[index]:
                matches += 1
            elif s1Count[index] + 1 == s2Count[index]:
                matches -= 1
            
            index = ord(s2[l]) - ord('a')
            s2Count[index] -= 1
            if s1Count[index] == s2Count[index]:
                matches += 1
            elif s1Count[index] - 1 == s2Count[index]:
                matches -= 1
            l += 1
        
        */
        while(right < s2.length() && numMatches != 26){
            int index = (int)s2.charAt(right) - 97;
            s2Map[index]++;
            
            if(s2Map[index] == s1Map[index]){
                numMatches++;
            } else if (s2Map[index] - 1 == s1Map[index]){
                numMatches--;
            }
            
            index = (int)s2.charAt(left) - 97;
            s2Map[index]--;
            
            if(s2Map[index] == s1Map[index]){
                numMatches++;
            } else if (s1Map[index] - 1 == s2Map[index]){
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