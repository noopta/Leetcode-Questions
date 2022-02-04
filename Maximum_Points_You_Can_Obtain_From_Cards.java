class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxScoreFound = 0;
        int left = 0;
        int right = cardPoints.length - k;
        int windowSum = 0;
        int i = 0;
        int currentScore = 0;

        for (i = 0; i < right; i++) {
            windowSum += cardPoints[i];
        }

        for (i = right; i < cardPoints.length; i++) {
            currentScore += cardPoints[i];
        }

        maxScoreFound = currentScore;

        while (right < cardPoints.length) {
            currentScore -= cardPoints[right];
            right++;
            currentScore += cardPoints[left];
            left++;

            maxScoreFound = Math.max(currentScore, maxScoreFound);
        }

        return maxScoreFound;
    }
}