class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] kMostFrequent = new int[k];
        HashMap<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));
        int i = 0;
        
        for(int currentNum : nums){
            if(frequencyMap.containsKey(currentNum)){
                frequencyMap.put(currentNum, frequencyMap.get(currentNum) + 1);
            } else {
                frequencyMap.put(currentNum, 1);
            }
        }
        
        for(int currentKey : frequencyMap.keySet()){
            minHeap.add(currentKey);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        while(!minHeap.isEmpty()){
            kMostFrequent[i++] = minHeap.poll();
        }
        
        return kMostFrequent;
    }
}