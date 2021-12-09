class Solution {
    public int longestConsecutive(int[] nums) {
        int globalSequence = 0;
        HashMap<Integer, Integer> theMap = new HashMap<Integer, Integer>();
        int currentSequence = 0;

        for (int num : nums) {
            if (theMap.containsKey(num)) {
                theMap.put(num, theMap.get(num) + 1);
            } else {
                theMap.put(num, 1);
            }
        }

        for (int num : theMap.keySet()) {
            if (!theMap.containsKey(num - 1)) {
                int currentNum = num;
                currentSequence = 1;

                while (theMap.containsKey(currentNum + 1)) {
                    currentSequence++;
                    currentNum++;
                }

                globalSequence = Math.max(globalSequence, currentSequence);

            }
        }

        return globalSequence;
    }
}
