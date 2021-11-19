class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        // min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>((a,b) -> a - b);
        int i = 0;
        
        for(i = 0; i < nums.length; i++){
            minHeap.add(nums[i]);
            
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
}