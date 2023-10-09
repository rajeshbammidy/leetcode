class Solution {

    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i = 0, j = tokens.length - 1;
        int currentScore = 0;
        int score = 0;
        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i];
                i++;
                currentScore++;
                score = Math.max(score, currentScore);
            } else if (score > 0) {
                power += tokens[j];
                j--;
                currentScore--;
            } else {
                return score;
            }
        }
        return score;
    }
}
