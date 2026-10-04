class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;

        int score = 0;

        // Initially take all k from left
        for (int i = 0; i < k; i++) {
            score += cardPoints[i];
        }

        int max = score;

        // Gradually replace left cards with right cards
        for (int i = 1; i <= k; i++) {

            score -= cardPoints[k - i];
            score += cardPoints[n - i];

            max = Math.max(max, score);
        }

        return max;
    }
}