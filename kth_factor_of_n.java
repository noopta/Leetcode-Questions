class Solution {
    public int kthFactor(int n, int k) {
        int counterVal = 0;
        int i = 0;
        
        for(i = 1; i <= n; i++){
            if(n % i == 0){
                counterVal++;
                if(counterVal == k){
                    return i;
                }
            }
        }
        
        return -1;
    }
}