class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<List<Integer>>();
        int i = 0;
        HashMap<Integer, Integer> theMap = new HashMap<Integer, Integer>();
        HashMap<ArrayList<Integer>, Integer> visitedMap = new HashMap<ArrayList<Integer>, Integer>();
        int j = 0;
        int k = 0;
        int currentSum = 0;
        
        Arrays.sort(nums);
        
        // -1 -1 0 1 2 4
        
        for(i = 0; i < nums.length; i++){
            theMap.put(nums[i], i);
        }
        
        for(i = 0; i < nums.length - 1; i++){
            for(j = i + 1; j < nums.length; j++){
                currentSum = nums[i] + nums[j];
                if(theMap.containsKey(0 - currentSum) && (theMap.get(0 - currentSum) != i) && (theMap.get(0 - currentSum) != j) && i < j && j < theMap.get(0 - currentSum)){
                    ArrayList<Integer> tempList = new ArrayList<Integer>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[theMap.get(0 - currentSum)]);

                    if(!visitedMap.containsKey(tempList)){
                        returnList.add(new ArrayList<Integer>(tempList));
                        visitedMap.put(tempList, 1);
                    }                    

                }
            }
        }
        
        
        return returnList;
    }
}