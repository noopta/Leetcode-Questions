class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        HashMap<Character, Integer> theMap = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        
        while(right < s.length()){
            
            if(theMap.containsKey(s.charAt(right))){
                while(theMap.containsKey(s.charAt(right))){
                    theMap.put(s.charAt(left), theMap.get(s.charAt(left)) - 1);
                    
                    if(theMap.get(s.charAt(left)) <= 0){
                        theMap.remove(s.charAt(left));
                    }
                    
                    left++;
                }
                
                theMap.put(s.charAt(right), 1);
            } else {
                theMap.put(s.charAt(right), 1);
            }
            
            maxLen = Math.max(maxLen, theMap.size());
            right++;
        }
        
        
        
        return maxLen;
    }
}