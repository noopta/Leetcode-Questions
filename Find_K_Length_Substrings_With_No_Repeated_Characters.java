class Solution {
    public int numKLenSubstrNoRepeats(String s, int k) {
        int numNoRepeats = 0;
        int left = 0;
        int right = 0;
        int i = 0;
        StringBuilder currentString = new StringBuilder();

        while (right < s.length()) {
            currentString.append(s.charAt(right));

            if (currentString.toString().length() >= k) {
                HashMap<Character, Integer> currentMap = new HashMap<Character, Integer>();
                String tempString = currentString.toString();
                boolean hasRepeats = false;
                for (i = 0; i < tempString.length(); i++) {
                    if (currentMap.containsKey(tempString.charAt(i))) {
                        hasRepeats = true;
                        break;
                    } else {
                        currentMap.put(tempString.charAt(i), 1);
                    }
                }

                if (!hasRepeats) {
                    numNoRepeats++;
                }

                currentString.deleteCharAt(0);
            }

            right++;
        }

        return numNoRepeats;
    }
}