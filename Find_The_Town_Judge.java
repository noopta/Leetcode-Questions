public class Solution {
    public int findJudge(int n, int[][] trust) {
        // create adjacency list
        int defaultIndex = -1;
        HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> trustCountMap = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> allPoints = new HashMap<Integer, Integer>();

        int i = 0;

        if (trust.length == 0 && n == 1) {
            return 1;
        }

        // creating the adjacency list
        for (i = 0; i < trust.length; i++) {
            if (!adjacencyList.containsKey(trust[i][0])) {
                adjacencyList.put(trust[i][0], new ArrayList<Integer>());
                adjacencyList.get(trust[i][0]).add(trust[i][1]);
            } else {
                adjacencyList.get(trust[i][0]).add(trust[i][1]);
            }

            if (!allPoints.containsKey(trust[i][0])) {
                allPoints.put(trust[i][0], 1);
            }

            if (!allPoints.containsKey(trust[i][1])) {
                allPoints.put(trust[i][1], 1);
            }

            if (trustCountMap.containsKey(trust[i][1])) {
                trustCountMap.put(trust[i][1], trustCountMap.get(trust[i][1]) + 1);
            } else if (!trustCountMap.containsKey(trust[i][1])) {
                trustCountMap.put(trust[i][1], 1);
            }

        }

        for (int currentPoint : allPoints.keySet()) {
            if (!adjacencyList.containsKey(currentPoint) &&
                    (trustCountMap.containsKey(currentPoint) && trustCountMap.get(currentPoint) == n - 1)) {
                return currentPoint;
            }
        }

        return defaultIndex;
    }
}