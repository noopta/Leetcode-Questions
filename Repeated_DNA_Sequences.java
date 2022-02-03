class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedSequences = new ArrayList<String>();
        HashMap<String, Integer> theMap = new HashMap<String, Integer>();
        int i = 0;
        int left = 0;
        int right = 0;
        int initialCount = 0;
        String currentString = "";

        while (initialCount < 10 && initialCount < s.length()) {
            currentString += s.charAt(initialCount);
            initialCount++;
        }

        StringBuilder theString = new StringBuilder(currentString);
        right = initialCount;

        theMap.put(theString.toString(), 1);

        while (right <= s.length()) {
            if (right == initialCount) {
                theMap.put(theString.toString(), 1);
            } else {

                theString = new StringBuilder(new StringBuilder(s).substring(left, right));

                if (theMap.containsKey(theString.toString())) {
                    theMap.put(theString.toString(), theMap.get(theString.toString()) + 1);
                } else {
                    theMap.put(theString.toString(), 1);
                }
            }

            left++;
            right++;
        }

        for (String currentSequence : theMap.keySet()) {
            if (theMap.get(currentSequence) > 1) {
                repeatedSequences.add(currentSequence);
            }
        }

        return repeatedSequences;
    }
}