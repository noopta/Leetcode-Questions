class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> theMap = new HashMap<String, ArrayList<String>>();
        int i = 0;
        
        for(i = 0; i < strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            if(!theMap.containsKey(new String(charArray))){
                theMap.put(new String(charArray), new ArrayList<String>());
            }
        }
        
        
        for(i = 0; i < strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            
            String tempString = new String(charArray);
            
            if(theMap.containsKey(tempString)){
                ArrayList<String> tempList = theMap.get(tempString);
                tempList.add(strs[i]);
                theMap.put(tempString, tempList);
            }
        }
        
        for(String currentString : theMap.keySet()){
            groupedAnagrams.add(theMap.get(currentString));
        }
        
        return groupedAnagrams;
    }
}