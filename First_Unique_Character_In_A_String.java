class Solution {
    public int firstUniqChar(String s) {
        int i = 0;
        HashMap<Character, Integer> theMap = new HashMap<Character, Integer>();

        for (i = 0; i < s.length(); i++) {
            if (theMap.containsKey(s.charAt(i))) {
                theMap.put(s.charAt(i), theMap.get(s.charAt(i)) + 1);
            } else {
                theMap.put(s.charAt(i), 1);
            }
        }

        for (i = 0; i < s.length(); i++) {
            if (theMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}