class Solution {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int numRefills = 0;
        int left = 0;
        int right = plants.length - 1;
        int plantsWatered = 0;
        int aliceCap = capacityA;
        int bobCap = capacityB;
        
        while(left <= right){
            if(left != right){
                if(aliceCap - plants[left] < 0){
                    // refill
                    numRefills++;
                    aliceCap = capacityA - plants[left];
                    left++;
                } else {
                    aliceCap -= plants[left];
                    left++;
                }
                
                if(bobCap - plants[right] < 0){
                    // refill
                    numRefills++;
                    bobCap = capacityB - plants[right];
                    right--;
                } else {
                    bobCap -= plants[right];
                    right--;
                }   
            } else if(left == right){
                if(aliceCap >= bobCap){
                    if(aliceCap - plants[left]  < 0){
                        numRefills++;
                        aliceCap = capacityA - plants[left];
                        left++;
                    } else {
                        aliceCap -= plants[left];
                        left++;
                    }
                } else if (bobCap > aliceCap){
                    if(bobCap - plants[right] < 0){
                        numRefills++;
                        bobCap = capacityB - plants[right];
                        right--;
                    } else {
                        bobCap -= plants[right];
                        right--;
                    }
                } 
            }
            
            plantsWatered++;
        }
        
        return numRefills;
    }
}