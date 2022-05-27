class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0;
        HashMap<Character, Integer> theMap = new HashMap<Character, Integer>();
        int left = 0;
        int right = 0;
        int currentMax = 0;
        
        while(right < s.length()){
            
            if(theMap.containsKey(s.charAt(right))){
                theMap.put(s.charAt(right), theMap.get(s.charAt(right)) + 1); 
            } else {
                theMap.put(s.charAt(right), 1);
            }
            
            for(char currentKey : theMap.keySet()){
                currentMax = Math.max(currentMax, theMap.get(currentKey));
            }
            
            while((right - left + 1) - currentMax > k){    
                
                theMap.put(s.charAt(left), theMap.get(s.charAt(left)) - 1);
                
                if(theMap.get(s.charAt(left)) <= 0){
                    theMap.remove(s.charAt(left));
                }
                
    
                for(char currentKey : theMap.keySet()){
                    currentMax = Math.max(currentMax, theMap.get(currentKey));
                }  
                
                left++;
            }
            
            maxLen = Math.max(maxLen, right - left + 1);
            
            right++;
        }
        
        
        
        return maxLen;
    }
}