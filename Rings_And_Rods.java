class Solution {
    public int countPoints(String rings) {
        int numPoints = 0;
        HashMap<Character, ArrayList<Character>> theMap = new HashMap<Character, ArrayList<Character>>();
        int i = 1;
        boolean redFlag = false;
        boolean blueFlag = false;
        boolean greenFlag = false;
        int j = 0;

        for (i = 1; i < rings.length(); i = i + 2) {
            if (theMap.containsKey(rings.charAt(i))) {
                ArrayList<Character> tempList = theMap.get(rings.charAt(i));
                tempList.add(rings.charAt(i - 1));

                theMap.put(rings.charAt(i), tempList);

            } else {
                ArrayList<Character> tempList = new ArrayList<Character>();
                tempList.add(rings.charAt(i - 1));

                theMap.put(rings.charAt(i), tempList);
            }
        }

        for (Character currentRod : theMap.keySet()) {
            ArrayList<Character> currentList = theMap.get(currentRod);

            for (j = 0; j < currentList.size(); j++) {
                if (currentList.get(j) == 'R') {
                    redFlag = true;
                } else if (currentList.get(j) == 'G') {
                    greenFlag = true;
                } else if (currentList.get(j) == 'B') {
                    blueFlag = true;
                }
            }

            if (blueFlag && greenFlag && redFlag) {
                numPoints++;
            }

            redFlag = false;
            blueFlag = false;
            greenFlag = false;

        }

        return numPoints;
    }
}