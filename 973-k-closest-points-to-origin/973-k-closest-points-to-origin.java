class Solution {
    public int calculateEuclidean(int x1, int y1, int x2, int y2){
        return (int) Math.sqrt((Math.pow(x1 - x2, 2)) + (Math.pow(y1 - y2, 2))) ;
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((p1, p2) -> p2[0] * p2[0] + p2[1] * p2[1] - p1[0] * p1[0] - p1[1] * p1[1]);
        int[][] closestPoints = new int[k][2];
        int i = 0;
        
        for(int[] currentPoints : points){
            pq.offer(currentPoints);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        for(i = 0; i < k; i++){
            closestPoints[i] = pq.poll();
        }
        
        
        return closestPoints;
        
    }
}