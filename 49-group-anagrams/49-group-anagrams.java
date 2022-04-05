class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<List<String>>();
        HashMap<String, ArrayList<String>> theMap = new HashMap<String, ArrayList<String>>();
        int i = 0;
        
        for(i = 0; i < strs.length; i++){
            char[] charArray = strs[i].toCharArray();
            Arrays.sort(charArray);
            if(!theMap.containsKey(new String(charArray))){
                ArrayList<String> tempList = new ArrayList<String>();
                tempList.add(strs[i]);
                theMap.put(new String(charArray), tempList);
            } else {
                ArrayList<String> tempList = theMap.get(new String(charArray));
                tempList.add(strs[i]);
                theMap.put(new String(charArray), tempList);
            }
        }
        
        
        for(String currentString : theMap.keySet()){
            groupedAnagrams.add(theMap.get(currentString));
        }
        
        return groupedAnagrams;
    }
}