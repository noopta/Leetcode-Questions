class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] kFrequent = new int[k];
        HashMap<Integer, Integer> theMap = new HashMap<Integer, Integer>();
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a, b) -> theMap.get(a) - theMap.get(b));
        int i = 0;
        
        for(i = 0; i < nums.length; i++){
            if(theMap.containsKey(nums[i])){
                theMap.put(nums[i], theMap.get(nums[i]) + 1);
            } else {
                theMap.put(nums[i], 1);
            }
        }
        
        for(int currentKey : theMap.keySet()){
           minHeap.add(currentKey);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        i = 0;
        
        while(!minHeap.isEmpty()){
            kFrequent[i++] = minHeap.poll();    
        }
        
        return kFrequent;
    }
}