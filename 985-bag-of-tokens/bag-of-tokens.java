class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score = 0;
        int maxScore = 0;
        int i = 0;
        int j = tokens.length - 1;

        while (i <= j) {
            if (power >= tokens[i]) {
                // Play the token face-up
                power -= tokens[i++];
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {
                // Play the token face-down if possible
                power += tokens[j--];
                score--;
            } else {
                // Cannot play any more tokens
                break;
            }
        }
        return maxScore;
    }
}