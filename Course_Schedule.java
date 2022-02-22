class Solution {
    public boolean depthFirstSearch(int currentClass, HashMap<Integer, ArrayList<Integer>> adjacencyList,
            HashMap<Integer, Integer> visitedMap) {
        int i = 0;

        if (visitedMap.containsKey(currentClass)) {
            return false;
        }

        if (adjacencyList.get(currentClass).size() == 0) {
            return true;
        }

        visitedMap.put(currentClass, 1);

        for (i = 0; i < adjacencyList.get(currentClass).size(); i++) {
            if (!depthFirstSearch(adjacencyList.get(currentClass).get(i), adjacencyList, visitedMap)) {
                return false;
            }
        }

        visitedMap.remove(currentClass);
        adjacencyList.put(currentClass, new ArrayList<Integer>());

        return true;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> adjacencyList = new HashMap<Integer, ArrayList<Integer>>();
        HashMap<Integer, Integer> visitedMap = new HashMap<Integer, Integer>();
        int i = 0;
        int j = 0;

        for (i = 0; i < numCourses; i++) {
            adjacencyList.put(i, new ArrayList<Integer>());
        }

        for (i = 0; i < prerequisites.length; i++) {
            int courseToTake = prerequisites[i][0];
            int preReq = prerequisites[i][1];

            if (adjacencyList.containsKey(courseToTake)) {
                ArrayList<Integer> tempList = new ArrayList<Integer>(adjacencyList.get(courseToTake));
                tempList.add(preReq);

                adjacencyList.put(courseToTake, tempList);
            } else {
                ArrayList<Integer> tempList = new ArrayList<Integer>();
                tempList.add(preReq);

                adjacencyList.put(courseToTake, tempList);
            }
        }

        for (i = 0; i < numCourses; i++) {
            if (!depthFirstSearch(i, adjacencyList, visitedMap)) {
                return false;
            }
        }

        return true;
    }
}