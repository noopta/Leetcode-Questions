class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // first check an edge case where s1.length() > s2.length()
        // if true then return false
        // else continue with the algorithm
        // create a map for s1, and a map for s2, these can be 2 arrays 
        // initialize the array with the first s1.length() characters and their frequencies 
        // have one loop to first calculate the number of matching characters 
        // then run a loop for the sliding window algorithm until right == s2.length()
        // calculate the index for the char of s2.charAt(right)
        // increment the count of this char in s2Map
        // if s2Map[index] == s1Map[index], then increment numMatches
        // if s2Map[index] - 1 == s1[Map], then decrement numMatches
        // then calculate the index for s2.charAt(left)
        // decrement s2Map for the respective character at the left index
        // if s1Map[left] == s2Map[left], then increment numMatches
        // if s1Map[left] - 1 == s2Map[left], then decrement numMatches
        // then increment left, and right pointers
        if(s1.length() > s2.length()){
            return false;
        }
        
        int numMatches = 0;
        int s1Map[] = new int[26];
        int s2Map[] = new int[26];
        int left = 0;
        int right = s1.length();
        int i = 0;
        int currentIndex = 0;
        
        for(i = 0; i < 26; i++){
            s1Map[i] = 0;
            s2Map[i] = 0;
        }
        
        for(i = 0; i < s1.length(); i++){
            currentIndex = (int)(s1.charAt(i)) - 97;
            s1Map[currentIndex]++;
            
            currentIndex = (int)(s2.charAt(i)) - 97;
            s2Map[currentIndex]++;
        }
        
        for(i = 0; i < 26; i++){
            if(s1Map[i] == s2Map[i]){
                numMatches++;
            }
        }
        
        
        while(numMatches != 26 && right < s2.length()){
            currentIndex = (int)(s2.charAt(right)) - 97;
            s2Map[currentIndex]++;
            
            if(s2Map[currentIndex] == s1Map[currentIndex]){
                numMatches++;
            } else if (s2Map[currentIndex] - 1 == s1Map[currentIndex]){
                numMatches--;
            }
            
            currentIndex = (int)(s2.charAt(left)) - 97;
            
            s2Map[currentIndex]--;
            
            if(s2Map[currentIndex] == s1Map[currentIndex]){
                numMatches++;
            } else if (s1Map[currentIndex] - 1 == s2Map[currentIndex]){
                numMatches--;
            }
            
            left++;
            right++;
        }
        
        return numMatches == 26;
    }
}