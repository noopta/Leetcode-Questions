class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int maxSubstringLen = 0;
        int currentSubstringLen = 0;
        HashMap<Character, Integer> theMap = new HashMap<Character, Integer>();
        int right = 0;
        int left = 0;

        while (right < s.length()) {
            if (theMap.containsKey(s.charAt(right))) {
                theMap.put(s.charAt(right), theMap.get(s.charAt(right)) + 1);
            } else {
                theMap.put(s.charAt(right), 1);
            }

            currentSubstringLen++;

            while (theMap.size() > 2) {
                theMap.put(s.charAt(left), theMap.get(s.charAt(left)) - 1);
                currentSubstringLen--;

                if (theMap.get(s.charAt(left)) <= 0) {
                    theMap.remove(s.charAt(left));
                }

                left++;

            }

            maxSubstringLen = Math.max(maxSubstringLen, currentSubstringLen);
            right++;
        }

        return maxSubstringLen;
    }
}