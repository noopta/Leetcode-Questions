class Solution {
    public int maxProfit(int[] prices) {
        int maxProfitFound = 0;
        int i = 0;
        int[] priceDifferences = new int[prices.length];
        int currentSum = 0;
        
        priceDifferences[0] = 0;
        
        for(i = 1; i < prices.length; i++){
            priceDifferences[i] = prices[i] - prices[i - 1];
        }
        
        for(i = 0; i < priceDifferences.length; i++){
            currentSum = Math.max(priceDifferences[i], currentSum + priceDifferences[i]);
            maxProfitFound = Math.max(maxProfitFound, currentSum);
        }
        
        return maxProfitFound;
    }
}